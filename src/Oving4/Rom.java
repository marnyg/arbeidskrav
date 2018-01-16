
package Oving4;
import java.util.ArrayList;

public class Rom {
    private ArrayList<Reservasjon> reservasjoner = new ArrayList<Reservasjon>();
    private String romNr;
    private int storrelse;

    public Rom(String romNr, int storrelse) {
        if (romNr.trim().equals("") || romNr == null || storrelse < 1) {
            throw new IllegalArgumentException("feil info i rom registrering");
        }
        this.romNr = romNr;
        this.storrelse = storrelse;
    }
    public int getStorrelse(){
        return storrelse;
    }

    public String getRomNr() {
        return romNr;
    }

    public boolean reserverRom(Reservasjon res) {
        for (Reservasjon reser:reservasjoner) {
            if (res.overlapp(reser.getFraTid(),reser.getTilTid())) {
                return false;
            }
        }
        reservasjoner.add(res);
        return true;
    }

    public String toString() {
        StringBuilder txt=new StringBuilder("Rom: ");
        txt.append(romNr+"\nRommet har plass til "+storrelse+"\n");
        for (Reservasjon res:reservasjoner) {
            txt.append(res.toString());
        }
        return txt.toString()+"\n";
    }

    public static void main(String args[]) {
        Rom rom = new Rom("101", 5);
        Reservasjon under = new Reservasjon(new Tidspunkt(200001011000L), new Tidspunkt(200001011030L), new Kunde("nr1", "123"));
        Reservasjon mid = new Reservasjon(new Tidspunkt(200001011100L), new Tidspunkt(200001011201L), new Kunde("nr1", "123"));
        Reservasjon over = new Reservasjon(new Tidspunkt(200001011200L), new Tidspunkt(200001011230L), new Kunde("nr1", "123"));
        if (rom.reserverRom(under)) System.out.println("under ok");
        if (rom.reserverRom(over)) System.out.println("over ok");
        if (rom.reserverRom(mid)) {
            System.out.println("mid ok");
        } else {
            System.out.println("mid not ok(riktig resultat)");
        }
    }

}
