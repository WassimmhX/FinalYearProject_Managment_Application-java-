import java.util.ArrayList;

public class Enseignant extends Personne{
    private ArrayList<Integer> gEncadrer;
    private String specialite;

    public Enseignant(String CIN, String fullName, int age, String specialite, ArrayList<Integer> gEncadrer) {
        super(fullName, CIN, age);
        this.gEncadrer = gEncadrer;
        this.specialite = specialite;
    }

    public ArrayList<Integer> getgEncadrer() {
        return gEncadrer;
    }

    public void setgEncadrer(ArrayList<Integer> gEncadrer) {
        this.gEncadrer = gEncadrer;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    void addGrp(int n){
        gEncadrer.add(n);
    }

    @Override
    public String toString() {
        return "Enseignant{" +super.toString()+
                "gEncadrer=" + gEncadrer +
                ", specialite='" + specialite + '\'' +
                '}';
    }
}
