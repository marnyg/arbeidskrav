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




