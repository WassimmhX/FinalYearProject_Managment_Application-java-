import java.util.ArrayList;
import java.util.Arrays;

public class Group implements DATA{
    private int nb;
    private String [] etds;
    private String Encadreur;
    public Group(int nb,String[]etds, String Encadreur){
        this.etds=etds;
        this.nb=nb;
        this.Encadreur=Encadreur;
    }

    public String[] getEtds() {
        return etds;
    }
    public String[] getEtdsName(ArrayList<Etudiant>etudiants){
        String[]ch=new String[etds.length];
        for(int i=0;i<etds.length;i++){
            int finalI = i;
            Etudiant et=etudiants.stream().filter((Etudiant e)->e.getCIN().equals(etds[finalI])).findAny().orElse(null);
            if (et==null)
                ch[i]="-";
            else
                ch[i]=et.getFullName();
        }
        return ch;
    }

    public void setEtds(String[] etds) {
        this.etds = etds;
    }

    public int getNb() {
        return nb;
    }

    public String getEncadreur() {
        return Encadreur;
    }

    @Override
    public String toString() {
        return "Group{" +
                "nb=" + nb +
                ", etds=" + Arrays.toString(etds) +
                ", Encadreur='" + Encadreur + '\'' +
                '}';
    }
}
