public class Bord {
    private String[] borene;
    private int antallBord;

    public Bord(int antall){
        borene = new String[antall];
        antallBord=antall;
    }

    public int finnAntallLedigeBord(){
        int count =0;
        for (int i=0; i<borene.length;i++){
            if (borene[i]==null){
                count++;
            }
        }
        return count;
    }
    public int finnAntallOpptatBord(){
        return antallBord-finnAntallLedigeBord();

    }
    public boolean frigjorBord(int[] nr){
        if (nr.length> borene.length||sjekkBord(nr)){
            return false;
        }
        for (int i =0; i<nr.length;i++) {
            if(nr[i]!=-1) {
                borene[nr[i]] = null;
            }
        }
        return true;
    }

    public boolean ReserverBord(String navn, int bordnNR){
        if (erLedig(bordnNR)){
            borene[bordnNR]=navn;
            return true;
        }
        return false;
    }

    public int[] finnReservertBord(String navn){
        int [] lol=new int[borene.length];
        for (int i=0;i<lol.length;i++){
            lol[i]=-1;
        }
        int counter = 0;
        for (int i =0;i<borene.length;i++){
            if (borene[i]!=null&&borene[i].equals(navn)){
                lol[counter]=i;
                counter++;
            }
        }
        return lol;
    }
    private boolean erLedig(int nr){
        if (borene[nr]==null){
            return true;
        }
        return false;
    }
    private boolean sjekkBord(int[] nr){
        for (int i =0;i<nr.length;i++){
            if (nr[i]>borene.length){
                return true;
            }
        }
        return false;
    }


}
