import java.util.Calendar;

public class Resturant {
    private int opprettingsAr;
    private String navn;
    private Bord bordene;

    public Resturant(int opprettingsAr, String navn, int antallBord){
        if(antallBord>=0) {
            bordene = new Bord(antallBord);
        }else{
            //throw NullPointerException("as");
        }
        this.navn =navn;
        this.opprettingsAr =opprettingsAr;
    }
    public int getOpprettingsAr() {
        return opprettingsAr;
    }
    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public int getAlde(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year-opprettingsAr;
    }
    public int getAntLedigeBord(){
        return bordene.finnAntallLedigeBord();
    }
    public int getAntOpptatBord(){
        return bordene.finnAntallOpptatBord();
    }
    public boolean reserverBord(String reserveringsNavn, int bord){
        if(bordene.ReserverBord(reserveringsNavn, bord)){
            return true;
        }
        return false;
    }
    public int[] finnReservertBord(String navn){
        return bordene.finnReservertBord(navn);
    }
    public boolean frigjorBord(String navn){

        bordene.frigjorBord(finnReservertBord(navn));
        return true;
    }


    public String toString() {
        String txt="Navn: ";
        txt+=getNavn()+"\nAlder: "+getAlde()+" år\nOppretta i: " +getOpprettingsAr();
        return txt;
    }
}

