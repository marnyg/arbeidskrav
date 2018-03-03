package Oving19;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{
    private Valuta[] valut = {
            new Valuta("Euro", 8.10, 1), new Valuta("US Dollar", 6.23, 1),
            new Valuta("Britiske pund", 12.27, 1), new Valuta("Svenske kroner", 88.96, 100),
            new Valuta("Danske kroner", 108.75, 100), new Valuta("Yen", 5.14, 100),
            new Valuta("Islandske kroner", 9.16, 100), new Valuta("Norske kroner", 100, 100)
    };
    private JTextField fraVerdi = new JTextField("10",1);
    private JTextField tilVerdi = new JTextField("???",1);
    private Valuta ventre;
    private Valuta hogre;

    public Window(){
        super("Valutaberegner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500, 500);

        setLayout(new BorderLayout(5, 5)); // 5 piksler avstand mellom komponentene
        add(new TopPanel(), BorderLayout.NORTH);
        add(new MidPanel(), BorderLayout.CENTER);
        add(new SondrePanel(), BorderLayout.SOUTH);
        pack();
    }

    public void regnUt(String asd){
        try{
            double venstrelestBlop=Double.parseDouble(fraVerdi.getText());
            double frabelop = venstrelestBlop * ventre.getKursMotNorsk() / ventre.getEnhet();
            double tilBelop = frabelop/(hogre.getKursMotNorsk()/hogre.getEnhet());
            tilVerdi.setText(String.valueOf(tilBelop));


        }catch (Exception e){
            System.out.println("fuk");
        }

    }


    private class TopPanel extends JPanel {
        public TopPanel() {
            setLayout(new GridLayout(2, 2));
            JLabel ledetekst = new JLabel("Velg fravaluta og tilvaluta fra listene:",JLabel.CENTER);
            JLabel fraTekst = new JLabel("Fra valuta:");
            JLabel tilTekst = new JLabel("Til valuta:");
            add(ledetekst);
            add(new JLabel());
            add(fraTekst);
            add(tilTekst);
        }
    }
    private class MidPanel extends JPanel {
        public MidPanel() {
            setLayout(new GridLayout(1,2));


            JList<Valuta> valuta1 = new JList<Valuta>(valut);
            JList<Valuta> valuta2 = new JList<Valuta>(valut);
            JScrollPane listeBox1 = new JScrollPane(valuta1);
            JScrollPane listeBox2 = new JScrollPane(valuta2);
            LyttBoxVenstre asd =new LyttBoxVenstre();
            LyttBoxHogre asda =new LyttBoxHogre();
            valuta1.addListSelectionListener(asd);
            valuta2.addListSelectionListener(asda);

            add(listeBox1);
            add(listeBox2);
            pack();
        }
    }
    class LyttBoxVenstre implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {

            JList lstener= (JList)e.getSource();
            ventre=(Valuta)lstener.getSelectedValue();
            regnUt(fraVerdi.getText());
        }
    }
    class LyttBoxHogre implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            JList lstener = (JList) e.getSource();
            hogre = (Valuta) lstener.getSelectedValue();
            regnUt(fraVerdi.getText());
        }
    }

    private class SondrePanel extends JPanel {
        public SondrePanel() {
            setLayout(new GridLayout(2, 2));
            JLabel fraTxt=new JLabel("Antall fra:");
            JLabel tiltxt=new JLabel("Blir til:");

            add(fraTxt);
            add(tiltxt);
            add(fraVerdi);
            add(tilVerdi);
        }
    }

    public static void main(String[] args) {
        Window etVindu = new Window();
        etVindu.setVisible(true);
    }

}


