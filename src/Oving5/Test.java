package Oving5;
import static javax.swing.JOptionPane.*;
import javax.swing.*;
import java.sql.*;

public class Test {

        public static void main(String[] args) throws Exception {
            String brukernavn = "mariunyg";
            String passord = "W0YmMTZh";
            String databasedriver = "com.mysql.jdbc.Driver";
            Class.forName(databasedriver);  // laster inn driverklassen
            Connection forbindelse = DriverManager.getConnection("jdbc:mysql://mysql.stud.iie.ntnu.no:3306/",brukernavn,passord);

            Statement setning = forbindelse.createStatement();




            setning.executeUpdate("DROP TABLE mariunyg.person");

            setning.executeUpdate("CREATE TABLE mariunyg.person(" +
                    "id INTEGER," +
                    "navn VARCHAR(30)" +
                    ");");


            setning.close();
            forbindelse.close();
        }
    }


//        INSERT borettslag(navn, adresse, etableringsAAr) VALUES ('nr2', 'asd124', 2000);
//        INSERT borettslag (navn, adresse, etableringsAAr) VALUES ('nr3', 'asd125', 2001);
//
//        INSERT bygninger (bygning_id, etasjer, addresse, boresttslag) VALUES (DEFAULT, 3, 'dsa321', 1);
//        INSERT bygninger (bygning_id, etasjer, addresse, boresttslag) VALUES (DEFAULT, 4, 'dsa322', 2);
//        INSERT bygninger (bygning_id, etasjer, addresse, boresttslag) VALUES (DEFAULT, 5, 'dsa323', 2);
//
//        INSERT leiligheter (antRom, kvadratMeter, bygning) VALUES (2, 3, 1);
//        INSERT leiligheter (antRom, kvadratMeter, bygning) VALUES (3, 4, 1);
//        INSERT leiligheter (antRom, kvadratMeter, bygning) VALUES (3, 4, 2);
//        INSERT leiligheter (antRom, kvadratMeter, bygning) VALUES (2, 3, 2);
//        INSERT leiligheter (antRom, kvadratMeter, bygning) VALUES (5, 6, 2);
//
//        INSERT andelseiere (navn, leiligheter) VALUES ('asd1', NULL);
//        INSERT andelseiere (navn, leiligheter) VALUES ('asd2', 1) ;
//        INSERT andelseiere (navn, leiligheter) VALUES ('asd3', 2);
//
//        # INSERT leiligheter (antRom, kvadratMeter, bygning) VALUES (2, 3, 3);
//        # DELETE FROM borettslag WHERE borettslag_id=1
//

