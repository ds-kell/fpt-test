package dao;

import object.Furniture;
import object.Video;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

public class FurnitureDAO extends DAO{
    public FurnitureDAO(){
        super();
    }
    public static boolean addFurniture(Furniture furniture) throws SQLException, ClassNotFoundException {
        Connection con = DAO.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO tblFurniture (name, serial, type, color,  price) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, furniture.getName());
            ps.setString(2,furniture.getSerial());
            ps.setString(3, furniture.getType());
            ps.setString(4, furniture.getColor());
            ps.setFloat(5, furniture.getPrice());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }


    public static ArrayList<Furniture> getAllFurniture() throws SQLException, ClassNotFoundException {
        ArrayList<Furniture> furniture = new ArrayList<>();
        Connection con = DAO.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tblfurniture");
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                Furniture fur = new Furniture( rs.getString("name"),rs.getString("serial"), rs.getString("type"), rs.getString("color"), rs.getFloat("price"));
                furniture.add(fur);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return furniture;
    }

    public static Furniture getFurnitureBySerial( String serial ) throws SQLException, ClassNotFoundException {
        Connection con = DAO.getConnection();
        String sql = "SELECT * FROM tblfurniture WHERE serial = '" + serial + "'";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs  = ps.executeQuery();
            if(rs.next()){
                return new Furniture( rs.getString("name"), rs.getString("serial"), rs.getString("type"), rs.getString("color"), rs.getFloat("price"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
