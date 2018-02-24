package Oving16.dyrehage;

public class Fiskestim extends Dyregruppe {
    private int gjennomsnittligLengde;
    private boolean kanDeleAkvarium;

    public Fiskestim(String gruppenavn, int antindivider, String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse, int gjennomsnittligLengde, boolean kanDeleAkvarium) {
        super(gruppenavn, antindivider, norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.gjennomsnittligLengde = gjennomsnittligLengde;
        this.kanDeleAkvarium = kanDeleAkvarium;
    }

    @Override
    public String toString() {
        return super.toString()+"Fiskestim{" +
                "gjennomsnittligLengde=" + gjennomsnittligLengde +
                ", kanDeleAkvarium=" + kanDeleAkvarium +
                '}';
    }

    public int getGjennomsnittligLengde() {
        return gjennomsnittligLengde;
    }

    public boolean isKanDeleAkvarium() {
        return kanDeleAkvarium;
    }
}
