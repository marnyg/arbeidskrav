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

            /*


CREATE TABLE borettslag(
  borettslag_id integer NOT NULL AUTO_INCREMENT,
  navn VARCHAR(30),
  adresse VARCHAR(30),
  antallHus INTEGER,
  blokkenheter INTEGER,
  etableringsAAr INTEGER,
  CONSTRAINT borettslag_pk PRIMARY KEY(borettslag_id)
);
CREATE TABLE bygninger(
  bygning_id INTEGER NOT NULL AUTO_INCREMENT,
  etasjer INTEGER,
  antLeiligheter INTEGER,
  CONSTRAINT bygninger_pk PRIMARY KEY (bygning_id)
);
CREATE TABLE andelseiere(
  navn VARCHAR(30)

);
CREATE TABLE leiligheter(
  leilighet_id INTEGER NOT NULL AUTO_INCREMENT,
  antRom INTEGER,
  kvadratMeter DECIMAL,
  CONSTRAINT leiligheter_pk PRIMARY KEY (leilighet_id)

)
*/


            setning.executeUpdate("DROP TABLE mariunyg.person");

            setning.executeUpdate("CREATE TABLE mariunyg.person(" +
                    "id INTEGER," +
                    "navn VARCHAR(30)" +
                    ");");


            setning.close();
            forbindelse.close();
        }
    }





