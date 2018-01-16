
package Oving4;
import java.util.ArrayList;

public class Konferansesenter {
    private ArrayList<Rom> rommene = new ArrayList<Rom>();

    public boolean reserverRom(Tidspunkt fra, Tidspunkt til, int antPers, Kunde kunde) {
        for (Rom rom:rommene) {
            if (rom.getStorrelse()>=antPers && rom.reserverRom(new Reservasjon(fra, til, kunde))) {
                return true;
            }
        }
        return false;
    }
    public boolean registrerNyttRom(String romNr,int storrelse){
        if (romNr!=null && romNr.trim()!="" && storrelse>0 && !romEksisterer(romNr)) {
            rommene.add(new Rom(romNr, storrelse));
            return true;
        }
        return false;
    }
    public int getAntalRom(){
        return rommene.size();
    }
    public Rom finnRom(String romNr) {
        for (Rom rom : rommene) {
            if (romNr.trim().equals(rom.getRomNr().trim())) {
                return rom;
            }
        }
        return null;
    }
    public Rom finnRom(int index){
        if(index<rommene.size()&&index>=0) {
            return rommene.get(index);
        }
        return null;
    }

    private boolean romEksisterer(String romNr){
        for (Rom rom:rommene) {
            if (romNr.trim().equals(rom.getRomNr().trim())){
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder txt =new StringBuilder();
        for (Rom rom :
                rommene) {
            txt.append(rom);
        }
        return txt.toString();
    }
}

