package Oving9;

public class Staa extends Tribune {

    private int antSolgteBilletter;

    public Staa(String tribunenavn, int kapasitet, int pris, int antSolgteBilletter) {
        super(tribunenavn, kapasitet, pris);
        this.antSolgteBilletter = antSolgteBilletter;
    }

    public int getAntSolgteBilletter() {
        return antSolgteBilletter;
    }

    public void setAntSolgteBilletter(int antSolgteBilletter) {
        this.antSolgteBilletter = antSolgteBilletter;
    }

    @Override
    public int finnAntallSolgteBilletter() {
        return antSolgteBilletter;
    }

    @Override
    public int finnInntekt() {
        return getPris()*antSolgteBilletter;
    }

    @Override
    public String toString() {
        return super.toString()+"Staa{" +
                "antSolgteBilletter=" + antSolgteBilletter +
                '}';
    }
}
