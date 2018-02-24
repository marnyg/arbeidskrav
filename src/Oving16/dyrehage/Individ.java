package Oving16.dyrehage;

import java.util.Date;

public  class Individ extends Dyr implements SkandinaviskRovdyr{
    private String navn;
    private int fDato;
    private  boolean hanndyr;
    private boolean farlig;



    public Individ(String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse, String navn, int fDato, boolean hanndyr, boolean farlig) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.navn = navn;
        this.fDato = fDato;
        this.hanndyr = hanndyr;
        this.farlig = farlig;
    }
    public void leggTilKull(int antall){}
    public void leggTilNyttKull(){}


    @Override
    public int getAntKull() {
        return 0;
    }

    @Override
    public String skrivUtInfo() {
        return toString();
    }

    @Override
    public int getAlder(int currentDate) {
        return currentDate -fDato;
    }

    @Override
    public void flytt(String nyAdresse) {
        super.setAdresse(nyAdresse);
    }

    @Override
    public String toString() {
        return super.toString()+"\nIndivid{" +
                "navn='" + navn + '\'' +
                ", fDato=" + fDato +
                ", hanndyr=" + hanndyr +
                ", farlig=" + farlig +
                '}';
    }

    public String getNavn() {
        return navn;
    }

    public int getFdato() {
        return fDato;
    }

    public boolean isHanndyr() {
        return hanndyr;
    }

    public boolean isFarlig() {
        return farlig;
    }
}
