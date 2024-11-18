import oracle.jdbc.OracleConnection;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
public class BaseDonnee {
    public final String ETUDIANTS="etudiants",ENSEIGNANTS="enseignants",PFES="pfes",GROUPS="groups",SOUTENANCES="soutenances";
    public final String[]ETUDIANTHEADER={"CIN","NOM","AGE","FORMATION"},
            ENSEIGNANTHEADER={"CIN","NOM","AGE","SPECIALITE","GROUP A ENCADRE"},
            GROUPHEADER={"NUMERO DE GROUP","ETUDIANTS","ENCADREUR"},
            PFEHEADER={"NOM DE PFE","NUMERO DE GROUP","ENCADREUR"},
            SOUTENANCEHEADER={"DATE","HEURE","LOCALE","PRESIDENT","RAPPORTEUR","EXAMINATEUR","ENCADREURS","N°GROUP","PFE","ETAT","NOTE"};

    private static String INSERTINTO="insert into ";
    private OracleConnection c;
    private Statement stmt;
    private PreparedStatement pstm;
    public ArrayList<Etudiant> etudiants;
    public ArrayList<Enseignant> enseignants;
    public ArrayList<Group> groups;
    public ArrayList<Pfe> pfes;
    public ArrayList<Soutenance> soutenances;
    public String[]login;
    private ResultSet rs;
    public BaseDonnee() {
        try{
        c=(OracleConnection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","GestionPFE","1234");
        stmt=c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+":"+e.getMessage());
            System.exit(0);
        }
        getDATA();
    }
    public void getDATA(){
        enseignants=getEnseignants();
        etudiants=getEtudiants();
        groups=getGroups();
        pfes=getPfes();
        soutenances=getSoutenances();
        login=getLogin();
    }

    public void insertInto(String tableName,DATA data) throws Exception{
        if(tableName.equalsIgnoreCase("Etudiant")) {
            Etudiant dt = (Etudiant) data;
            stmt.executeUpdate(INSERTINTO + "Etudiant values('" + dt.getCIN()
                    + "','" + dt.getFullName() + "','" + dt.getAge() + "','" + dt.getEd()+"')");
        }
        else if(tableName.equalsIgnoreCase("Enseignant")) {
            Enseignant dt = (Enseignant) data;
            Array arr=c.createOracleArray("INTTABLE",dt.getgEncadrer().toArray());
            pstm= c.prepareStatement(INSERTINTO + "Enseignant values('" + dt.getCIN()
                    + "','" + dt.getFullName() + "','" + dt.getAge() + "','" + dt.getSpecialite()+"',"+"?"+ ")");
            pstm.setArray(1,arr);
            pstm.executeUpdate();
        }
        else if(tableName.equalsIgnoreCase("Groups")){
            Group gp=(Group) data;
            Array arr=c.createOracleArray("CINTABLE",gp.getEtds());
            pstm=c.prepareStatement(INSERTINTO+tableName+" values('"
                    +gp.getNb()+"',"+"?"+",'"+gp.getEncadreur()+"')");
            pstm.setArray(1,arr);
            pstm.executeUpdate();
        }
        else if(tableName.equalsIgnoreCase("PFE")){
            Pfe pfe=(Pfe) data;
            stmt.executeUpdate(INSERTINTO + tableName+" values('" + pfe.getName()
                    + "','" + pfe.getGrp() + "','" + pfe.getEncadreur() +"')");
        }
        else if(tableName.equalsIgnoreCase("Soutenance")){
            Soutenance stn=(Soutenance) data;
            Array arr=c.createOracleArray("CINTABLE",stn.getEncadreur());
            pstm=c.prepareStatement(INSERTINTO+tableName+" values(" +
                    "?" +",'"+stn.getHeure()+"','"+stn.getLocale()+"','"+stn.getPresident()
                    +"','"+stn.getRapporteur()+"','"+stn.getExaminateur()+"',?,"+stn.getGrp()+",'"
                    +stn.getPfeName()+"','"+stn.getPassee()+"',"+stn.getNote()+")");
            pstm.setArray(2,arr);
            pstm.setDate(1,stn.getDate());
            pstm.executeUpdate();
        }
    }

    private ArrayList<Etudiant> getEtudiants(){
        ArrayList<Etudiant> etudiants=new ArrayList<>();
        try{
            rs = stmt.executeQuery("select * from etudiant");
            while (rs.next()){

                etudiants.add(new Etudiant(rs.getString(1), rs.getString(2),
                        rs.getInt(3),Formation.getFormation(rs.getString(4))));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+":"+e.getMessage());
            System.exit(0);
        }
        return etudiants;
    }
    private ArrayList<Enseignant> getEnseignants(){
        ArrayList<Enseignant> enseignants=new ArrayList<>();
        try{
            rs = stmt.executeQuery("select * from enseignant");
            while (rs.next()){
                Array z=rs.getArray(5);
                ArrayList<Integer>y=new ArrayList<>();
                for(BigDecimal i:(BigDecimal[])z.getArray()){
                    y.add(i.intValue());
                };
                enseignants.add(new Enseignant(rs.getString(1), rs.getString(2),
                        rs.getInt(3),rs.getString(4),y));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+":"+e.getMessage());
            System.exit(0);
        }
        return enseignants;
    }
    private ArrayList<Group> getGroups(){
        ArrayList<Group> groups=new ArrayList<>();
        try{
            rs = stmt.executeQuery("select * from groups");
            while (rs.next()){

                groups.add(new Group(rs.getInt(1),(String[]) rs.getArray(2).getArray(), rs.getString(3)));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+":"+e.getMessage());
            System.exit(0);
        }
        return groups;
    }
    private ArrayList<Pfe> getPfes(){
        ArrayList<Pfe> pfes=new ArrayList<>();
        try{
            rs = stmt.executeQuery("select * from pfe");
            while (rs.next()){

                pfes.add(new Pfe(rs.getString(1), rs.getInt(2),
                        rs.getString(3)));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+":"+e.getMessage());
            System.exit(0);
        }
        return pfes;
    }
    private ArrayList<Soutenance> getSoutenances(){
        ArrayList<Soutenance> soutenances=new ArrayList<>();
        try{
            rs = stmt.executeQuery("select * from soutenance");
            while (rs.next()){
                Array z=rs.getArray(7);
                String[] x=(String []) z.getArray();
                soutenances.add(new Soutenance(rs.getDate(1), rs.getInt(2),
                        rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),x,
                        rs.getInt(8),rs.getString(9),rs.getString(10),
                        rs.getDouble(11)));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+":"+e.getMessage());
            System.exit(0);
        }
        return soutenances;
    }
    private String[] getLogin(){
        String[] l=new String[2];
        try {
            rs = stmt.executeQuery("select * from login");
            while (rs.next()) {
                l[0] = rs.getString(1);
                l[1]=rs.getString(2);
            }
        }catch (Exception e){

        }
        return l;
    }

    public int findEtudiant(Predicate<Etudiant> predicate){
        Etudiant e=etudiants.stream().filter(predicate).findAny().orElse(null);
        return etudiants.indexOf(e);
    }
    public int findEnseignant(Predicate<Enseignant> predicate){
        Enseignant e=enseignants.stream().filter(predicate).findAny().orElse(null);
        return enseignants.indexOf(e);
    }
    public int findGroup(Predicate<Group> predicate){
        Group e=groups.stream().filter(predicate).findAny().orElse(null);
        return groups.indexOf(e);
    }
    public int findPfe(Predicate<Pfe> predicate){
        Pfe e=pfes.stream().filter(predicate).findAny().orElse(null);
        return pfes.indexOf(e);
    }
    public int findSoutenance(Predicate<Soutenance> predicate){
        Soutenance e=soutenances.stream().filter(predicate).findAny().orElse(null);
        return soutenances.indexOf(e);
    }

    public void executeSQLUpdate(String querry) throws Exception{
        stmt.executeUpdate(querry);
    }
    public void updateEnseignant(Enseignant e) throws Exception{
        Array arr=c.createOracleArray("INTTABLE",e.getgEncadrer().toArray());
        pstm=c.prepareStatement("update enseignant set encadre=? where cin='"+e.getCIN()+"'");
        pstm.setArray(1,arr);
        pstm.executeUpdate();
    }
    public void updateSoutenance(String querry,Date d) throws Exception{
        pstm=c.prepareStatement(querry);
        pstm.setDate(1,d);
        pstm.executeUpdate();
    }

    String[][]getTable(String tableName){
        if(tableName.equalsIgnoreCase("etudiants")){
            String[][]x=new String[etudiants.size()][4];
            for(int i=0;i<etudiants.size();i++){
                Etudiant e=etudiants.get(i);
                x[i][0]=e.getCIN();
                x[i][1]=e.getFullName();
                x[i][2]= ((Integer) e.getAge()).toString();
                x[i][3]=e.getEd();
            }
            return x;
        }
        else if(tableName.equalsIgnoreCase("enseignants")){
            String[][]x=new String[enseignants.size()][5];
            for(int i=0;i<enseignants.size();i++){
                Enseignant e=enseignants.get(i);
                x[i][0]=e.getCIN();
                x[i][1]=e.getFullName();
                x[i][2]= ((Integer) e.getAge()).toString();
                x[i][3]=e.getSpecialite();
                x[i][4]= e.getgEncadrer()!=null?e.getgEncadrer().toString():"{}";
            }
            return x;
        }
        else if(tableName.equalsIgnoreCase(GROUPS)){
            String[][]x=new String[groups.size()][3];
            for (int i = 0; i < groups.size(); i++) {
                Group b = groups.get(i);
                x[i][0] = Integer.toString(b.getNb());
                x[i][1] = b.getEtdsName(etudiants)!=null? Arrays.toString(b.getEtdsName(etudiants)) :"{}";
                x[i][2] = b.getEncadreur();
            }
            return x;
        }
        else if(tableName.equalsIgnoreCase("pfes")){
            String[][]x=new String[pfes.size()][5];
            for(int i=0;i<pfes.size();i++){
                Pfe e=pfes.get(i);
                x[i][0]=e.getName();
                x[i][1]=((Integer) e.getGrp()).toString();
                x[i][2]= e.getEncadreur();
            }
            return x;
        }
        else if(tableName.equalsIgnoreCase("soutenances")){
            String[][]x=new String[soutenances.size()][11];
            for(int i=0;i<soutenances.size();i++){
                Soutenance e=soutenances.get(i);
                x[i][0]=formatDate(e.getDate().toString());
                x[i][1]=Integer.toString(e.getHeure());
                x[i][2]=e.getLocale();
                x[i][3]=e.getPresident();
                x[i][4]=e.getRapporteur();
                x[i][5]=e.getExaminateur();
                x[i][6]=e.getEncadreur()!=null?Arrays.toString(e.getEncadreur()):"{}";
                x[i][7]=Integer.toString(e.getGrp());
                x[i][8]=e.getPfeName();
                x[i][9]=e.getPassee();
                x[i][10]=Double.toString(e.getNote());
            }
            return x;
        }
        return null;
    }
    String formatDate(String date){
        String ch="";
        for(String i:date.split("-")){
            ch="/"+i+ch;
        }
        return ch.substring(1);
    }

}
