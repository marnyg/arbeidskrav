import static javax.swing.JOptionPane.*;
public class klient {
  public static void main(String[] args){
      Resturant rest =null;
      String[] muligheter= {"Info","reserver bord","finn Bordnummer","frigjor bord","avslutt"};
      final int INFO=0;
      final int RESERVER=1;
      final int FINNBORD=2;
      final int FRIGJORBORD=3;
      final int AVSLUTT=4;
      int valg=0;


      boolean ok = false;
      while (!ok) {
          try {
              int oppAr = Integer.parseInt(showInputDialog(null, "Oppstarts ar?"));
              int antBord = Integer.parseInt(showInputDialog(null, "antall bord?"));
              String navn = showInputDialog(null, "navnet?");
              rest = new Resturant(oppAr, navn, antBord);
              ok =true;

          } catch (Exception e) {
              showMessageDialog(null,"noe gikk galt prov igjen");
          }
      }
      do{
          valg =showOptionDialog(null, "hva vil du gjore","meny",YES_NO_CANCEL_OPTION,ERROR_MESSAGE,null,muligheter,null);
          switch (valg){
              case INFO:
                  showMessageDialog(null,rest);
                  break;


              case RESERVER:

                  int bordnr =-1;
                  while (bordnr ==-1){
                  try{
                  bordnr =Integer.valueOf(showInputDialog(null, "hvilket bord")).intValue();
                  }catch (Exception e){
                      showMessageDialog(null,"noe gikk galt prov igjen");
                  }
                  }

                  while (!rest.reserverBord(showInputDialog(null,"navn"),bordnr)){
                      showMessageDialog(null,"noe gikk galt prov igjen");
                  }
                      showMessageDialog(null,"suksess");
                  break;


              case FINNBORD:
                  int[] bord=rest.finnReservertBord(showInputDialog(null,"navn?"));
                  String asd="";
                  for (int i=0;i<bord.length;i++){
                      if (bord[i]>0)
                      asd+=bord[i]+"-";
                  }
                  showMessageDialog(null,asd);
                  break;


              case FRIGJORBORD:
                  if(rest.frigjorBord(showInputDialog(null,"navnet til bord reservatoren"))){
                      showMessageDialog(null,"suksess");
                      break;
                  }
                  showMessageDialog(null,"nope, prov igjen");
                  break;


              default:
                  valg=AVSLUTT;
          }
      }while(valg!=AVSLUTT);
  }
}
