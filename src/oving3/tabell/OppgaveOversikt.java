public class OppgaveOversikt {
    private Student[] studenter = new Student[5];
    private int antStud = 0;


    public boolean regNyStudent(String navn){
        if (!eksisterer(navn)) {
           if (antStud==studenter.length){
               utivdTab();
           }
           studenter[antStud]=new Student(navn);
           antStud++;
           return true;
        }
        return false;
    }

    public int finnAntStud() {
        return antStud;
    }

    public int finnAntOppgaver(String navn){
        if (finnStudent(navn)==-1){
            return -1;
        }
        return studenter[finnStudent(navn)].getAntOppg();
    }

    public boolean økAntOppg(String navn, int ant){
        if(finnStudent(navn)==-1){
            return false;
        }
        int antOppg = studenter[finnStudent(navn)].getAntOppg() + ant;
        studenter[finnStudent(navn)].setAntOppg(antOppg);
        return true;
    }
    public String[] finnAlleNavn(){
        String[] navn = new String[antStud];
        for (int i = 0; i < studenter.length; i++) {
            if(studenter[i]!=null){
                navn[i]= studenter[i].getNavn();
            }
        }
        return navn;
    }

    private int finnStudent(String navn){
        for (int i = 0; i < studenter.length; i++) {
            if (studenter[i].getNavn().equals(navn)){
                return i;
            }
        }
        return -1;
    }
    private void utivdTab(){
        Student[] nyTab = new Student[studenter.length+5];
        for (int i = 0; i < studenter.length ; i++) {
            nyTab[i]=studenter[i];
        }
        studenter=nyTab;
    }
    private boolean eksisterer(String navn){
        for (Student stud:studenter) {
            if (stud!=null &&stud.getNavn().equals(navn)){
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String txt = "";
        for (int i = 0; i < studenter.length; i++) {
            if(studenter[i]!=null){
                txt+= studenter[i]+"\n\n";
            }

        }
        return txt;
    }
}
