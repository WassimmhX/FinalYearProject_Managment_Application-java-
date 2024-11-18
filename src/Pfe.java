public class Pfe implements DATA{
    private String name;
    private int grp;
    private String encadreur;

    public Pfe(String name, int grp, String encadreur) {
        this.name = name;
        this.grp = grp;
        this.encadreur = encadreur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrp() {
        return grp;
    }

    public void setGrp(int grp) {
        this.grp = grp;
    }

    public String getEncadreur() {
        return encadreur;
    }

    public void setEncadreur(String encadreur) {
        this.encadreur = encadreur;
    }
}
