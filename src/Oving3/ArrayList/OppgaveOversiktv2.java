import java.util.ArrayList;

public class OppgaveOversiktv2 {
    private ArrayList<Student> studenter = new ArrayList<Student>();
    private int antStud = 0;


    public boolean regNyStudent(String navn){
        if (!eksisterer(navn)) {
//           if (antStud==studenter.size()){
//               utivdTab();
//           }
           studenter.add(new Student(navn));
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
        return studenter.get(finnStudent(navn)).getAntOppg();
    }

    public boolean økAntOppg(String navn, int ant){
        if(finnStudent(navn)==-1){
            return false;
        }
        int antOppg = studenter.get(finnStudent(navn)).getAntOppg() + ant;
        studenter.get(finnStudent(navn)).setAntOppg(antOppg);
        return true;
    }
    public String[] finnAlleNavn(){
        String[] navn = new String[antStud];
        for (int i = 0; i < studenter.size(); i++) {
            if(studenter.get(i)!=null){
                navn[i]= studenter.get(i).getNavn();
            }
        }
        return navn;
    }

    private int finnStudent(String navn){
        for (int i = 0; i < studenter.size(); i++) {
            if (studenter.get(i).getNavn().equals(navn)){
                return i;
            }
        }
        return -1;
    }
//    private void utivdTab(){
//        Student[] nyTab = new Student[studenter.size()+5];
//        for (int i = 0; i < studenter.size() ; i++) {
//            nyTab[i]=studenter[i];
//        }
//        studenter=nyTab;
//    }
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
        for (int i = 0; i < studenter.size(); i++) {
            if(studenter.get(i)!=null){
                txt+= studenter.get(i)+"\n\n";
            }

        }
        return txt;
    }
}
