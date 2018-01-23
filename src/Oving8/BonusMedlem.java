package Oving8;

public class BonusMedlem {
    private final int medlNr;
    private final Personalia pers;
    private final LocalDate innmeldtDato;
    private int poeng = 0;

    public BonusMedlem(int medlNr,Personalia pers, LocalDate innmeldtDato, int poeng){

    }

    public int getMedlNr() {
        return medlNr;
    }

    public int getPoeng() {
        return poeng;
    }

    public LocalDate getInnmeldtDato() {
        return innmeldtDato;
    }

    public Personalia getPers() {
        return pers;

    }

    public int finnKvalPoeng(){
        //todo lag metoden  finnkvalpoeng()
        return -1;
    }
    public boolean okPassord(){
        //todo lag metoden ok passord()
        return true;
    }
    public boolean registrerPoeng(){
        //todo lag metoden registrer poeng()
        return true;
    }
}
