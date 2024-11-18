import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class Soutenance implements DATA{
    private Date date;
    private int heure;
    private String locale;
    private String president,rapporteur,examinateur;
    private String[] encadreur;
    private int grp;
    private String passee,pfeName;
    private double note;

    public Soutenance(Date date, int heure, String locale, String president, String rapporteur,String examinateur, String[] encadreur,int grp,String pfeName, String passee, double note) {
        this.date = date;
        this.heure = heure;
        this.locale = locale;
        this.president = president;
        this.rapporteur = rapporteur;
        this.encadreur = encadreur;
        this.passee = passee;
        this.note = note;
        this.pfeName=pfeName;
        this.grp=grp;
        this.examinateur=examinateur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPfeName() {
        return pfeName;
    }

    public int getHeure() {
        return heure;
    }

    public String getExaminateur() {
        return examinateur;
    }

    public int getGrp() {
        return grp;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getRapporteur() {
        return rapporteur;
    }

    public void setRapporteur(String rapporteur) {
        this.rapporteur = rapporteur;
    }

    public String[] getEncadreur() {
        return encadreur;
    }
    public String[] getEncadreursNames(ArrayList<Enseignant>enseignants){
        String[] ch=new String[encadreur.length];
        for(int i=0;i<encadreur.length;i++){
            int finalI = i;
            ch[i]=enseignants.stream().filter((Enseignant e)->e.getCIN().equals(encadreur[finalI])).findAny().orElse(null).getFullName();
        }
        return ch;
    }

    public void setEncadreur(String[] encadreur) {
        this.encadreur = encadreur;
    }

    public String getPassee() {
        return passee;
    }

    public void setPassee(String passee) {
        this.passee = passee;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Soutenance{" +
                "date=" + date +
                ", heure=" + heure +
                ", locale='" + locale + '\'' +
                ", president='" + president + '\'' +
                ", rapporteur='" + rapporteur + '\'' +
                ", encadreur=" + Arrays.toString(encadreur) +
                ", passee='" + passee + '\'' +
                ", pfeName='" + pfeName + '\'' +
                ", note=" + note +
                '}';
    }
}
