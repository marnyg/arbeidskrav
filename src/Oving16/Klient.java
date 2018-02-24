package Oving16;

import Oving16.dyrehage.Rovdyrfabrikk;
import Oving16.dyrehage.SkandinaviskRovdyr;

public class Klient {

    public static void main(String[] args) {
        Rovdyrfabrikk fabrikk =new Rovdyrfabrikk();
        SkandinaviskRovdyr fBjorn =fabrikk.nyBinne(10,8,"Anne-Bjorn",5);
        SkandinaviskRovdyr mBjorn =fabrikk.nyHannbjorn(11,7,"Knut-Bjorn");
//        SkandinaviskRovdyr fUlv =fabrikk.nyUlvetipse(11,8,"Anne-Ulv");
//        SkandinaviskRovdyr mUlv =fabrikk.nyUlvehann(10,9,"Knut-Ulv");
        System.out.println(fBjorn.skrivUtInfo()+"\n");
        System.out.println(fBjorn.getNavn());
        System.out.println(fBjorn.getFdato());
        System.out.println(fBjorn.getAlder(11));
        System.out.println(fBjorn.getAdresse());
        fBjorn.flytt("nyAdresse");
        System.out.println(fBjorn.getAdresse());
        System.out.println( );
        System.out.println(fBjorn.getAntKull());
        fBjorn.leggTilKull(3);
        System.out.println(fBjorn.getAntKull());
        fBjorn.leggTilNyttKull();
        System.out.println(fBjorn.getAntKull());
        System.out.println( );
        System.out.println(mBjorn.getAntKull());
        mBjorn.leggTilKull(3);
        System.out.println(mBjorn.getAntKull());
        mBjorn.leggTilNyttKull();
        System.out.println(mBjorn.getAntKull());
    }
}
