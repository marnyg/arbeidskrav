package Oving9;

import java.io.Serializable;
import java.util.Objects;

public abstract class Tribune implements Comparable<Tribune>, Serializable {
    private final String tribunenavn;
    private final int kapasitet;
    private final int pris;

    @Override
    public String toString() {
        return "Tribune{" +
                "tribunenavn='" + tribunenavn + '\'' +
                ", kapasitet=" + kapasitet +
                ", pris=" + pris +
                '}';
    }
    public Tribune(String tribunenavn, int kapasitet, int pris) {
        this.tribunenavn = tribunenavn;
        this.kapasitet = kapasitet;
        this.pris = pris;
    }
    public String getTribunenavn() {
        return tribunenavn;
    }
    public int getKapasitet() {
        return kapasitet;
    }
    public int getPris() {
        return pris;
    }
    public abstract int finnAntallSolgteBilletter();
    public abstract int finnInntekt();


    public abstract Billett[] kjopBillet(int antBiletter);
    public abstract Billett[] kjopBillet(String[] navn);

    @Override
    public int compareTo(Tribune ob) {
       // Tribune ob =(Tribune) o;
        return ob.finnInntekt()-finnInntekt();
    }
}
