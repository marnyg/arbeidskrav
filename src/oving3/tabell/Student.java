public class Student {
    private final String navn;
    private int antOppg;

    Student(String navn){
        this.navn=navn;
    }

    String getNavn() {
        return navn;
    }

    int getAntOppg() {
        return antOppg;
    }

    void setAntOppg(int antOppg) {
        if (antOppg<0){
            throw new IllegalArgumentException("argumentet i setAntOppg() kan ikke vere negativt");
        }
        this.antOppg = antOppg;
    }

    public String toString() {
        return "Navn: "+navn+"\nAnt oppg: "+ antOppg;
    }
}
