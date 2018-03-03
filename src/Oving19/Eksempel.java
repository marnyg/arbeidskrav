package Oving19;

import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;

class Eksempel extends JFrame {
    private static final double KURS = 81.15;
    private JTextField fraBeløp = new JTextField(12);
    private JLabel resultat = new JLabel("Resultatet av omregningen kommer her.");

    public Eksempel(String tittel) {
        super(tittel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500, 500);

        setLayout(new BorderLayout(5, 5)); // 5 piksler avstand mellom komponentene
        add(new NordrePanel(), BorderLayout.NORTH);
        pack();
        add(resultat, BorderLayout.CENTER);
        pack();
        add(new SondrePanel(), BorderLayout.SOUTH);
        pack();
    }

    private class NordrePanel extends JPanel {
        public NordrePanel() {
            setLayout(new GridLayout(1, 2));
            JLabel ledetekst = new JLabel("Beløp: ", JLabel.RIGHT);
            add(ledetekst);
            add(fraBeløp);
        }
    }

    private class SondrePanel extends JPanel {
        public SondrePanel() {
            setLayout(new GridLayout(1, 2));
            JButton knappS = new JButton("Til svensk.");
            add(knappS);
            JButton knappN = new JButton("Til norsk.");
            add(knappN);
            Knappelytter knappelytteren = new Knappelytter();
            knappS.addActionListener(knappelytteren);
            knappN.addActionListener(knappelytteren);
        }
    }

    private class Knappelytter implements ActionListener {
        public void actionPerformed(ActionEvent hendelse) {
            String regneVei = hendelse.getActionCommand();
            double beløp = 0.0;
            try {
                beløp = Double.parseDouble(fraBeløp.getText());
            } catch (NumberFormatException e) {
            }  // lar beløp være 0 hvis ugyldig tall skrevet inn
            if (regneVei.equals("Til svensk.")) {
                double svensk = 100.0 * beløp / KURS;
                resultat.setText("Regnet om til svenske kroner: " + formaterBeløp(svensk) + " SEK.");
            } else {
                double norsk = KURS * beløp / 100.0;
                resultat.setText("Regnet om til norske kroner: " + formaterBeløp(norsk) + " NOK.");
            }
        }

        private String formaterBeløp(double beløp) {  // hjelpemetode
            java.util.Formatter f = new java.util.Formatter();
            f.format("%.2f", beløp);
            return f.toString();
        }
    }
}

class TestValutaVindu {
    public static void main(String[] args) {
        Eksempel etVindu = new Eksempel("Valutakalkulator");
        etVindu.setVisible(true);
    }
}
