package dao;

import object.BookOnTape;
import object.Furniture;
import object.Video;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

public class BOT_DAO extends DAO{
    public BOT_DAO(){
        super();
    }
    public static boolean addBOT(BookOnTape bot) throws SQLException, ClassNotFoundException {
        Connection con = DAO.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO tblBookOnTape(name, author, serial, pub_company, price) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, bot.getName());
            ps.setString(2, bot.getAuthor());
            ps.setString(3, bot.getSerial());
            ps.setString(4, bot.getPub_company());
            ps.setFloat(5, bot.getPrice());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }


    public static ArrayList<BookOnTape> getAllBookOnTape() throws SQLException, ClassNotFoundException {
        ArrayList<BookOnTape> bookOnTapes = new ArrayList<>();
        Connection con = DAO.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tblBookOnTape");
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                BookOnTape bookOnTape = new BookOnTape(rs.getString("name"), rs.getString("author"), rs.getString("serial"), rs.getString("pub_company"), rs.getFloat("price"));
                bookOnTapes.add(bookOnTape);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return bookOnTapes;
    }

    public static BookOnTape getBookOnTapeBySerial( String serial ) throws SQLException, ClassNotFoundException {
        Connection con = DAO.getConnection();
        String sql = "SELECT * FROM tblBookOnTape WHERE serial = '" + serial + "'";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs  = ps.executeQuery();
            if(rs.next()){
                return new BookOnTape(rs.getString("name"), rs.getString("author"), rs.getString("serial"), rs.getString("pub_company"), rs.getFloat("price"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
