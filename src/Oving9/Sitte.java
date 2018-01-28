package Oving9;

public class Sitte extends Tribune{
    private int [] antOpptatt;  // tabellstørrelse: antall rader

    public Sitte(String tribunenavn, int kapasitet, int pris, int[] antOpptatt) {
        super(tribunenavn, kapasitet, pris);
        this.antOpptatt = antOpptatt;
    }

    public int[] getAntOpptatt() {
        return antOpptatt;
    }

    public void setAntOpptatt(int[] antOpptatt) {
        this.antOpptatt = antOpptatt;
    }

    @Override
    public int finnAntallSolgteBilletter() {
        int sum=0;
        for (int i :
                antOpptatt) {
            sum+=i;
        }
        return sum;
    }

    @Override
    public int finnInntekt() {
        return getPris()*finnAntallSolgteBilletter();
    }
}
