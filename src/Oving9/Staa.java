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

    @Override
    public Billett[] kjopBillet(String[] navn) {
        Billett[] biletter = new Billett[navn.length];
        for (int i = 0; i < navn.length; i++) {
            StaaplassBillett temp = new StaaplassBillett(getTribunenavn(),getPris());
            biletter[i]=temp;
        }
        antSolgteBilletter+=navn.length;
        return biletter;
    }

    @Override
    public Billett[] kjopBillet(int antBiletter) {
        Billett[] biletter = new Billett[antBiletter];
        for (int i = 0; i <antBiletter; i++) {
            StaaplassBillett temp = new StaaplassBillett(getTribunenavn(),getPris());
            biletter[i]=temp;
        }
        antSolgteBilletter+=antBiletter;
        return biletter;
    }


}
