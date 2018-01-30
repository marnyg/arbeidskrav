package Oving9;

import java.util.Arrays;

public class Sitte extends Tribune{
    private int [] antOpptatt;  // tabellstørrelsoe: antall rader
    private  int radStorelse;


    public Sitte(String tribunenavn, int kapasitet, int pris, int rader) {
        super(tribunenavn, kapasitet, pris);
        antOpptatt = new int[rader];
        radStorelse=kapasitet/antOpptatt.length;
    }

    public int getRadStorelse() {
        return radStorelse;
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

    @Override
    public Billett[] kjopBillet(String[] navn) {
        boolean done = false;
        for (int j=0;j<antOpptatt.length;j++) {
            if(!done && radStorelse-antOpptatt[j]>=navn.length){
                antOpptatt[j] += navn.length;
                Billett[] billetts = new Billett[navn.length];
                for (int i = 0; i < navn.length; i++) {
                    SitteplassBillett temp = new SitteplassBillett(getTribunenavn(),getPris(),antOpptatt[j],i);
                    billetts[i]=temp;
                }
                return billetts;
            }

        }
        return null;
    }
    public Billett[] kjopBillet(int antBiletter) {
        boolean done = false;
        for (int i=0;i<antOpptatt.length;i++){
                if (!done && radStorelse - antOpptatt[i] >= antBiletter) {
                    antOpptatt[i] += antBiletter;
                    Billett[] billetts = new Billett[antBiletter];
                    for (int j = 0; j < antBiletter; j++) {
                        SitteplassBillett temp = new SitteplassBillett(getTribunenavn(), getPris(), antOpptatt[i], j);
                        billetts[j] = temp;

                    }
                    return billetts;
                }
            }
        return null;


    }

    @Override
    public String toString() {
        return super.toString()+"Sitte{" +
                "antOpptatt=" + Arrays.toString(antOpptatt) +
                ", radStorelse=" + radStorelse +
                '}';
    }
}

