package Oving8;

import java.time.LocalDate;

public class GullMedlem extends BonusMedlem {

    public GullMedlem(int mdlNr, Personalia pers, LocalDate date, int poeng){
        super(mdlNr,pers,date);
        this.setPoeng(poeng);
    }

    @Override
    public boolean registrerPoeng(int addPoeng) {
        return super.registrerPoeng(addPoeng*15/10);
    }
}
