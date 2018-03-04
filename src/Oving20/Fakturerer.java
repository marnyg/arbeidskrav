package Oving20;

import Oving18.Opprydder;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Fakturerer {
    Connection connect;

    public  Fakturerer(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://mysql.stud.iie.ntnu.no:3306/mariunyg?autoRecommect=true&useSSl=false","mariunyg", "W0YmMTZh");
        }catch (Exception e){
        System.out.println("kunne ikke opprette kontakt med databasen");
        }
    }

    public void fakturer(int mande, String filnavn){
        String timeSetning="SELECT kunde,prosj_id,sum((timelønn * ant_timer)*prosjekt.timefaktor) FROM " +
                "(ansatt NATURAL JOIN prosjektarbeid) natural JOin prosjekt WHERE MONTH(dato)=? GROUP BY prosj_id";
        String vareSetning="SELECT prosj_id,tekst,kunde,beløp FROM prosjektkostnader NATURAL JOIN " +
                "prosjekt WHERE MONTH(dato) = ?";
        String updateFakturaTimer="UPDATE prosjektarbeid SET faktura_sendt = CURRENT_DATE WHERE MONTH(dato)=10";
        String updateFakturaVarer="UPDATE prosjektkostnader SET faktura_sendt = CURRENT_DATE WHERE MONTH(dato)=10";
        PreparedStatement timeQuerry=null;
        PreparedStatement vareQuerry=null;
        PreparedStatement setFakutra1=null;
        PreparedStatement setFaktura2=null;

        try {
            connect.setAutoCommit(false);
            timeQuerry= connect.prepareStatement(timeSetning);
            vareQuerry = connect.prepareStatement(vareSetning);
            setFaktura2=connect.prepareStatement(updateFakturaTimer);
            setFakutra1=connect.prepareStatement(updateFakturaVarer);

            vareQuerry.setInt(1,mande);
            timeQuerry.setInt(1,mande);

            ResultSet timer = timeQuerry.executeQuery();
            ResultSet varer = vareQuerry.executeQuery();
            while (timer.next()){
                writeToFile(timer.getInt(2)+"; timer; "+timer.getString(1)+";"+timer.getInt(3)+"\n",filnavn);
            }
            while (varer.next()){
                writeToFile(varer.getInt(1)+";"+varer.getString(2)+";"+varer.getString(3)+";"+varer.getInt(4)+"\n",filnavn);
            }
            setFaktura2.executeUpdate();
            setFakutra1.executeUpdate();
        }catch (Exception e){
            Oving18.Opprydder.rullTilbake(connect);
            Oving18.Opprydder.settAutoCommit(connect);
        }finally {
            Oving18.Opprydder.lukkSetning(timeQuerry);
            Oving18.Opprydder.lukkSetning(vareQuerry);
            Opprydder.lukkSetning(setFaktura2);
            Opprydder.lukkSetning(setFakutra1);
            Opprydder.settAutoCommit(connect);
        }
    }
    public void lukkConnection(){
        Opprydder.lukkForbindelse(connect);
    }


    public void writeToFile(String linje,String filnavn){
        try(FileWriter fw = new FileWriter(filnavn,true)) {
//        fw = new FileWriter(filnavn,true);
        fw.write(linje);
        }catch (Exception e){
            System.out.println("File is fucked"+e);
        }
    }

    public static void main(String[] args) {
        Fakturerer fak=new Fakturerer();
        fak.fakturer(10,"test.txt");
        fak.lukkConnection();
    }

}
