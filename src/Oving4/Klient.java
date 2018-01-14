import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.IOException;
import java.text.ParseException;

import static javax.swing.JOptionPane.*;
public class Klient {

    public static void main(String[] args) {
        Konferansesenter konf = new Konferansesenter();

        String[] muligheter = {"Reserver rom", "Skriv info", "Finn info om rom","Avslutt"};
        int valg = showConfirmDialog(null, "Registrer rom", "ASD", 0);;
        while(valg==0 || !(konf.getAntalRom()>0)){


            System.out.println(valg);
            String navn = showInputDialog("Rommets navn?");
            try{
                int storelse = Integer.parseInt(showInputDialog("Storrelse paa rom?",5));
                konf.registrerNyttRom(navn,storelse);
            }catch (Exception e){
                showMessageDialog(null,"noe gikk galt prov igjen");
            }
            valg = showConfirmDialog(null, "Registrer rom", "ASD", 0);
        }

        String valg2;
        do {
            valg2 = (String) showInputDialog(null, "Hva vil du?", "valg", 1, null, muligheter, muligheter[0]);
            if (valg2!=null) {

                switch (valg2) {
                    case "Reserver rom":
                        try {

                            Tidspunkt fra = new Tidspunkt(Long.valueOf(showInputDialog("Fra tidsponkt? (yyyymmddhhmm)")));
                            Tidspunkt til = new Tidspunkt(Long.valueOf(showInputDialog("Til tidsponkt? (yyyymmddhhmm)")));
                            int ant = Integer.parseInt(showInputDialog("Hvor mange personer"));
                            String navn = showInputDialog("Navn rommet skal registreres under");
                            String tlf = showInputDialog("tlf rommet skal registreres under");

                            if(!konf.reserverRom(fra, til, ant, new Kunde(navn, tlf))){
                                showMessageDialog(null,"noe gikk galt, prov igjen");
                                }
                        }catch (Exception e){showMessageDialog(null,"nope, prov igjen");}
                        System.out.println(valg2);
                        break;
                    case "Skriv info":

                        showMessageDialog(null,konf);
                        break;
                    case "Finn info om rom":
                        String rom = showInputDialog("Hvilket rom");
                        if (konf.finnRom(rom)==null){
                            showMessageDialog(null,"nope, prov igjen");
                        }
                        showMessageDialog(null,konf.finnRom(rom));
                        break;

                }
            }
        }while(!(valg2==null ||valg2.equals(muligheter[3])));



    }






}
