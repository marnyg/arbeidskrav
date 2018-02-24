package Oving16.dyrehage;

public class Hunnindivid extends Individ {
    private int antKull;

    public Hunnindivid(String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse, String navn, int fDato, boolean hanndyr, boolean farlig, int antKull) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, navn, fDato, hanndyr, farlig);
        this.antKull = antKull;
    }

    public int getAntKull() {
        return antKull;
    }

    public void leggTilKull(int antKull) {
        this.antKull += antKull;
    }
    public  void leggTilNyttKull(){
        antKull++;
    }
}

