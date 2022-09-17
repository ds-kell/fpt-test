package dao;
import java.sql.*;

public class DAO {
    public static Connection con = null;
    private final static String username = "kell";
    private final static String password = "dskell0502";
    private final static String url = "jdbc:mysql://localhost:3306/RRS?zeroDateTimeBehavior=CONVERT_TO_NULL";
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getConnection());
    }
//    public DAO(){
//        if(con == null){
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                con = DriverManager.getConnection(url);
//            }catch(ClassNotFoundException | SQLException e){
//                System.out.println(e);
//            }
//        }
//    }
}