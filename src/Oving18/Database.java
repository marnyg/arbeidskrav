package Oving18;
import java.sql.*;


import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private Connection connect;

    public Database(String bruker,String pass){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://mysql.stud.iie.ntnu.no:3306/mariunyg?autoRecommect=true&useSSl=false",bruker, pass);
        }catch (Exception e){
        System.out.println("kunne ikke opprette kontakt med databasen");
        }
    }
    public void lukkForbindelsa() {
        Opprydder.lukkForbindelse(connect);
    }

    public boolean regNyBok(Bok nyBok) {
        String regBok="INSERt INTO bok(isbn,Tittel,Forfatter) Values(?,?,?)";
        String regEksemplar="insert into eksemplar(isbn, ekemplar) values (?,?)";
        PreparedStatement stmt2=null;
        PreparedStatement stmt=null;
        boolean ok;
        try{
            connect.setAutoCommit(false);
            stmt2 = connect.prepareStatement(regEksemplar);
            stmt = connect.prepareStatement(regBok);

            stmt.setString(1,nyBok.getIsbn());
            stmt.setString(2,nyBok.getForfatter());
            stmt.setString(3,nyBok.getTittel());

            stmt2.setString(1,nyBok.getIsbn());
            stmt2.setInt(2,1);

            stmt.executeUpdate();
            stmt2.executeUpdate();
            connect.commit();
            ok=true;
        }catch (SQLException e){
            Opprydder.rullTilbake(connect);
            Opprydder.settAutoCommit(connect);
            ok=false;
        }finally {
            Opprydder.lukkSetning(stmt2);
            Opprydder.lukkSetning(stmt);
            Opprydder.settAutoCommit(connect);
        }
        return ok;
    }
    public int regNyttEksemplar(String isbn){

        String hentEksemplar="select max(ekemplar) from eksemplar where isbn=?";
        String insetString ="insert into eksemplar(isbn, ekemplar) values (?,?)";
        PreparedStatement stmt=null;
        PreparedStatement insertStatment=null;

        int higestEkemplar=-1;
        try {
            connect.setAutoCommit(false);
            stmt = connect.prepareStatement(hentEksemplar);
            stmt.setString(1,isbn);
            ResultSet rs = stmt.executeQuery();

            insertStatment = connect.prepareStatement(insetString);
            insertStatment.setString(1,isbn);

            if(rs.next())
                higestEkemplar=rs.getInt(1)+1;

            insertStatment.setInt(2,higestEkemplar);
            insertStatment.executeUpdate();

            connect.commit();
            return higestEkemplar;
        }catch (Exception e){
            Opprydder.rullTilbake(connect);
            Opprydder.settAutoCommit(connect);
        }finally {
            Opprydder.lukkSetning(insertStatment);
            Opprydder.lukkSetning(stmt);
            Opprydder.settAutoCommit(connect);
        }
        return higestEkemplar;
    }

    public boolean lanUtEksemplar(String isbn,String navn, int eksNr){
        String tningshjl="update eksemplar set laant_av = ? where isbn = ? and ekemplar = ?";
        PreparedStatement stmt=null;
        int res=0;
        try {
            connect.setAutoCommit(false);

            stmt= connect.prepareStatement(tningshjl);
            stmt.setString(1,navn);
            stmt.setString(2,isbn);
            stmt.setInt(3,eksNr);

            res=stmt.executeUpdate();
            connect.commit();
        }catch (Exception e){
            Opprydder.rullTilbake(connect);
            Opprydder.settAutoCommit(connect);
        }finally {
            Opprydder.lukkSetning(stmt);
            Opprydder.settAutoCommit(connect);
        }
        return res==1;
    }

    public static void main(String[] args){
        try {
            Database test = new Database("mariunyg", "W0YmMTZh");
            if(test.regNyBok(new Bok("332","titl","forf")))
                System.out.println("regNyBok returnerte true fordi det funka");
            if(!test.regNyBok(new Bok("332","titl","forf")))
                System.out.println("regNyBok returnerte false fordi det ikke funka");

            System.out.println(test.regNyttEksemplar("332"));
            System.out.println(test.regNyttEksemplar("332"));
            System.out.println(test.regNyttEksemplar("332"));
            System.out.println(test.regNyttEksemplar("332"));


            if(test.lanUtEksemplar("332","asds",1))
                System.out.println("laan metoden returnerte true fordi det funka");
            if(!test.lanUtEksemplar("2","asds",1))
                System.out.println("laan metoden returnerte false fordi det ikke funka");
        }catch (Exception e){
            System.out.println("feil");
        }
    }
}
