public class Studentv2 {
    private final String navn;
    private int antOppg;

    public Studentv2(String navn){
        this.navn=navn;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void setAntOppg(int antOppg) {
        if (antOppg<0){
            throw new IllegalArgumentException("argumentet i setAntOppg() kan ikke vere negativt");
        }
        this.antOppg = antOppg;
    }

    public String toString() {
        return "Navn: "+navn+"\nAnt oppg: "+ antOppg;
    }
}
