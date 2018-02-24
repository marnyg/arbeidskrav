package Oving16.dyrehage;

public class Fugleflokk extends Dyregruppe{
    private int gjennomsnittligVekt;
    private boolean svommer;

    @Override
    public String toString() {
        return super.toString()+"Fugleflokk{" +
                "gjennomsnittligVekt=" + gjennomsnittligVekt +
                ", svommer=" + svommer +
                '}';
    }

    public Fugleflokk(String gruppenavn, int antindivider, String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse, int gjennomsnittligVekt, boolean svommer) {
        super(gruppenavn, antindivider, norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.gjennomsnittligVekt = gjennomsnittligVekt;
        this.svommer = svommer;
    }

    public int getGjennomsnittligVekt() {
        return gjennomsnittligVekt;
    }

    public boolean isSvommer() {
        return svommer;
    }
}
