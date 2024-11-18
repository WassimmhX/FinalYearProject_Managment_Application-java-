public class Etudiant extends Personne{
    private Formation ed;

    public Etudiant(String CIN,String fullName,  int age, Formation ed) {
        super(fullName, CIN, age);
        this.ed = ed;
    }

    public String getEd() {
        return ed.getType();
    }

    public void setEd(Formation ed) {
        this.ed = ed;
    }

    @Override
    public String toString() {
        return super.toString()+"ed=" + ed;
    }
}
