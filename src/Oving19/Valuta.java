package Oving19;

public class Valuta {
    private String valutaNavn;
    private double kursMotNorsk;
    private int enhet;

    public Valuta(String valutaNavn, double kursMotNorsk, int enhet) {
        this.valutaNavn = valutaNavn;
        this.kursMotNorsk = kursMotNorsk;
        this.enhet = enhet;
    }

    public String getValutaNavn() {
        return valutaNavn;
    }

    public double getKursMotNorsk() {
        return kursMotNorsk;
    }

    public int getEnhet() {
        return enhet;
    }

    @Override
    public String toString() {
        return valutaNavn ;
    }
}
