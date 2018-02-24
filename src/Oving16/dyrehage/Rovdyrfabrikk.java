package Oving16.dyrehage;

public class Rovdyrfabrikk {
    public SkandinaviskRovdyr nyBinne(int annkomstDato, int fDato, String navn, int antKull){
        return new Hunnindivid("Bjorn","Ursus arctos","Ursidae",annkomstDato,"Lobby",navn,fDato, false,true,antKull);
    }
    public SkandinaviskRovdyr nyHannbjorn(int annkomstDato, int fDato, String navn){
        return new Hannindivid("Bjorn","Ursus arctos","Ursidae",annkomstDato,"Lobby",navn,fDato, true,true);

    }
    public SkandinaviskRovdyr nyUlvetipse(int annkomstDato, int fDato, String navn,int antKull){
        return new Hunnindivid("Ulv","Canis lupus","Canidae",annkomstDato,"Lobby",navn,fDato, false,true, antKull);

    }
    public SkandinaviskRovdyr nyUlvehann(int annkomstDato, int fDato, String navn){
        return new Hannindivid("Ulv","Canis lupus","Canidae",annkomstDato,"Lobby",navn,fDato, true,true);

    }
}
