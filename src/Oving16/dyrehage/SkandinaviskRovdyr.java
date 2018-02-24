package Oving16.dyrehage;

public interface SkandinaviskRovdyr {
    String getNavn();
    int getFdato();
    int getAlder(int currentDate);
    String getAdresse();
    void flytt(String nyAdresse);
    String skrivUtInfo();
    int getAntKull();
    void leggTilKull(int antall);
    void leggTilNyttKull();
}
