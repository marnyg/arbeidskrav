package Oving8;

import java.time.LocalDate;

public class SoelvMedlem extends BonusMedlem {

     public SoelvMedlem(int mdlNr, Personalia pers , LocalDate date,int poeng){
          super(mdlNr,pers,date);
          this.setPoeng(poeng);
     }

     @Override
     public boolean registrerPoeng(int addPoeng) {
          return super.registrerPoeng(addPoeng*12/10);
     }
}
