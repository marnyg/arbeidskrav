package Oving8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Medlemsarkiv {
    ArrayList<BonusMedlem> medlem = new ArrayList<>();


    int finnPoeng(int mdlNr,String pwd){
        for (BonusMedlem mdl:medlem) {
            if(mdl.okPassord(pwd)&&mdl.getMedlNr()==mdlNr){
                return mdl.getPoeng();
            }
        }
        return -1;


    }
    Boolean registrerPoeng(int mdlNr,int poeng){
        for (BonusMedlem mdl:medlem) {
            if(mdl.getMedlNr()==mdlNr){
                mdl.registrerPoeng(poeng);
                return true;
            }
        }
        return false;

    }
    public int nyMedlem(Personalia pers, LocalDate innmeldt){
        int mdlNr=finnLedigNr();
        BasicMedlem mdl =new BasicMedlem(mdlNr, pers,innmeldt);
        medlem.add(mdl);
        return mdlNr;

    }
    private int finnLedigNr(){
        Random num = new Random();
        boolean eksisterer =false;
        int muligtall;
        do {
            muligtall=num.nextInt();

            for (BonusMedlem mdl : medlem) {
                if (muligtall== mdl.getMedlNr()) {
                    eksisterer=true;
                }
            }
        }while (eksisterer==true);
        return muligtall;

    }
    public void sjekkMedlemmer(){
        for (BonusMedlem mdl :
                medlem) {
            if (mdl.getPoeng() > 75000&& !(mdl instanceof GullMedlem)) {
                    GullMedlem tmp = new GullMedlem(mdl.getMedlNr(),mdl.getPers(),mdl.getInnmeldtDato(),mdl.getPoeng());
                medlem.set(medlem.indexOf(mdl),tmp);
            }else if(mdl.getPoeng()>25000&& !(mdl instanceof SoelvMedlem)){
                SoelvMedlem tmp = new SoelvMedlem(mdl.getMedlNr(),mdl.getPers(),mdl.getInnmeldtDato(),mdl.getPoeng());
                medlem.set(medlem.indexOf(mdl),tmp);

            }
            }
    }


}
