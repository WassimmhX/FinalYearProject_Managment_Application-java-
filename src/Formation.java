abstract class Formation {
    public static Formation getFormation(String ch){
        if(ch.equalsIgnoreCase("master"))
            return new Master();
        else if (ch.equalsIgnoreCase("engineer"))
            return new Engineer();
        else
            return new Licence();
    }
    abstract String getType();

    @Override
    public String toString() {
        return getType();
    }
}
