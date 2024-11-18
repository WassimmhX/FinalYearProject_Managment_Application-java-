public class Personne implements DATA{
    private String fullName;
    private String CIN;
    private int age;

    public Personne(String fullName, String CIN, int age) {
        this.fullName = fullName;
        this.CIN = CIN;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "fullName='" + fullName + '\'' +
                ", CIN='" + CIN + '\'' +
                ", age=" + age;
    }
}
