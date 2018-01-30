package Oving9;

import java.util.Arrays;

public class VIP extends Sitte {
    private String[][] tilskuer; // tabellstørrelse: antall rader * antall plasser pr rad

    public VIP(String tribunenavn, int kapasitet, int pris,int rader){
        super(tribunenavn, kapasitet, pris,rader);
        this.tilskuer =new String[rader][getRadStorelse()];
    }

    public String[][] getTilskuer() {
        return tilskuer;
    }

    public void setTilskuer(String[][] tilskuer) {
        this.tilskuer = tilskuer;
    }

    @Override
    public Billett[] kjopBillet(String[] navna) {
        int[] a =getAntOpptatt();
        SitteplassBillett[] asd= new SitteplassBillett[navna.length];
        for (int i=0;i<navna.length;i++){
            if (getRadStorelse()-a[i]>navna.length){
                for (int j=0;j<navna.length;j++){
                    tilskuer[i][a[i]+j]=navna[j];
                    SitteplassBillett temp = new SitteplassBillett(getTribunenavn(),getPris(),i,a[i]+j);
                    asd[j]=temp;
                }
                super.kjopBillet(navna);
                return asd;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String txt =super.toString()+"VIP{" +"tilskuer=";
        for (int i =0 ;i<tilskuer.length;i++) {
            for (int j =0;j<tilskuer[0].length;j++) {
                if (tilskuer[i][j]!=null)
                txt+=i +"-"+ j+": "+ tilskuer[i][j]+" ";

            }
        }
        return txt +'}';
    }
}
