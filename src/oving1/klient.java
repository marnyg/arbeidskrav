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


      try {
          int oppAr = Integer.parseInt(showInputDialog(null, "Oppstarts ar?"));
          int antBord = Integer.parseInt(showInputDialog(null, "antall bord?"));
          String navn = showInputDialog(null, "navnet?");
          rest = new Resturant(oppAr, navn, antBord);
      }catch (Exception e){System.out.print("det virker ikke");}

      do{
          System.out.println("asdasd");
          System.out.println("asdasd");
          //showInputDialog();

          valg =showOptionDialog(null, "hva vil du gjore","meny",YES_NO_CANCEL_OPTION,ERROR_MESSAGE,null,muligheter,null);
          switch (valg){
              case INFO:
                  showMessageDialog(null,rest);
                  break;
              case RESERVER:
                  if(rest.reserverBord(showInputDialog(null,"navn"),Integer.valueOf(showInputDialog(null, "hvilket bord")).intValue())){
                      showMessageDialog(null,"suksess");
                      break;
                  }
                  showMessageDialog(null,"nope");
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
                  if(rest.frigjorBord(showInputDialog(null,"hvem vill du frigjore"))){
                      showMessageDialog(null,"suksess");
                      break;
                  }
                  showMessageDialog(null,"nope");
                  break;
          }
      }while(valg!=AVSLUTT);
  }
}
