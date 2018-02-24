package Oving16.dyrehage;

public abstract class Dyregruppe extends Dyr{
    private String gruppenavn;
    private  int antindivider;

    public Dyregruppe(String gruppenavn,int antindivider,String norskNavn, String latNavn, String latFamilie,
               int ankommetDato, String adresse){
        super(norskNavn,latNavn,latFamilie,ankommetDato,adresse);
        this.antindivider=antindivider;
        this.gruppenavn=gruppenavn;
    }

    public int getAntindivider() {
        return antindivider;
    }
    public String getNorskNavn(){
        return "gruppe av "+getNorskNavn();
    }

    public String getGruppenavn() {
        return gruppenavn;
    }

    public void setAntindivider(int antindivider) {
        this.antindivider = antindivider;
    }

    @Override
    public String toString() {
        return super.toString()+"Dyregruppe{" +
                "gruppenavn='" + gruppenavn + '\'' +
                ", antindivider=" + antindivider +
                '}';
    }
}
