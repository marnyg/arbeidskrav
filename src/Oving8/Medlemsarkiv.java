package Oving8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Medlemsarkiv {
    private ArrayList<BonusMedlem> medlem = new ArrayList<>();


    Boolean registrerPoeng(int mdlNr,int poeng,LocalDate dato){
        for (BonusMedlem mdl:medlem) {
            if(mdl.getMedlNr()==mdlNr){

                mdl.registrerPoeng(poeng);
                return true;
            }
        }
        return false;

    }
    int finnPoeng(int mdlNr,String pwd){
        for (BonusMedlem mdl:medlem) {
            if(mdl.okPassord(pwd)&&mdl.getMedlNr()==mdlNr){
                return mdl.getPoeng();
            }
        }
        return -1;

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
            muligtall=num.nextInt(100);

            for (BonusMedlem mdl : medlem) {
                if (muligtall== mdl.getMedlNr()) {
                    eksisterer=true;
                }
            }

        }while (eksisterer);
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
    public String toString(){
        String txt="";
        String type="";
        for (BonusMedlem mdl :
                medlem) {
            if(mdl instanceof GullMedlem){
                type="gull";
            }
            else if(mdl instanceof  SoelvMedlem){
                type="soelv";
            }
            else if(mdl instanceof BasicMedlem){
                type="basic";
            }
            txt += mdl.toString()+" type: " +type +"\n";
        }
        return txt;
    }

    public static void main(String[] args){
        Medlemsarkiv arkiv =new Medlemsarkiv();
        arkiv.nyMedlem(new Personalia("asd","dsa","asd@asd", "123"),LocalDate.of(2000,1,1));
        Personalia ole = new Personalia("Olsen", "Ole", "ole.olsen@dot.com", "ole");
        Personalia tove = new Personalia("Hansen", "Tove", "tove.hansen@dot.com", "tove");
        arkiv.medlem.add( new BasicMedlem(100, ole, LocalDate.of(2006, 2, 15)));
        arkiv.medlem.add(new BasicMedlem(10, tove, LocalDate.of(2007, 3, 5)));
        System.out.println(arkiv);
        LocalDate test =LocalDate.of(2006,3,1);
        arkiv.registrerPoeng(10,30000,test);
        arkiv.registrerPoeng(100, 100000,test);
        System.out.println(arkiv);
        arkiv.sjekkMedlemmer();
        arkiv.registrerPoeng(100, 30000, test );
        arkiv.registrerPoeng(10, 30000, test );

        System.out.println(arkiv);


    }

}
