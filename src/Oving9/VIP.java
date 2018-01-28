package Oving9;

public class VIP extends Sitte {
    private String[][] tilskuer; // tabellstørrelse: antall rader * antall plasser pr rad

    public VIP(String tribunenavn, int kapasitet, int pris, int[] antOpptatt, String[][] tilskuer) {
        super(tribunenavn, kapasitet, pris, antOpptatt);
        this.tilskuer = tilskuer;
    }

    public String[][] getTilskuer() {
        return tilskuer;
    }

    public void setTilskuer(String[][] tilskuer) {
        this.tilskuer = tilskuer;
    }
}
