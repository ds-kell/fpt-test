package dao;

import object.Video;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class VideoDAO extends DAO{
    public VideoDAO(){
        super();
    }
    public static boolean addVideo(Video video) throws SQLException, ClassNotFoundException {
        Connection con = DAO.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO tblVideos (name, serial, size, price) VALUES (?, ?, ?, ?)");
            ps.setString(1, video.getName());
            ps.setString(2,video.getSerial());
            ps.setFloat(3, video.getSize());
            ps.setFloat(4, video.getPrice());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }


    public static ArrayList<Video> getAllVideo() throws SQLException, ClassNotFoundException {
        ArrayList<Video> videos = new ArrayList<>();
        Connection con = DAO.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tblVideos");
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                Video video = new Video( rs.getString("name"), rs.getString("serial"), rs.getFloat("size"), rs.getFloat("price"));
                videos.add(video);
            }
        } catch (SQLException | ParseException e) {
            System.out.println(e);
        }
        return videos;
    }

    public static Video getVideoBySerial( String serial ) throws SQLException, ClassNotFoundException {
        Connection con = DAO.getConnection();
        String sql = "SELECT * FROM tblVideos WHERE serial = '" + serial + "'";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs  = ps.executeQuery();
            if(rs.next()){
                return new Video(rs.getString("name"), rs.getString("serial"),  rs.getFloat("size"), rs.getFloat("price"));
            }
        } catch (SQLException | ParseException e) {
            System.out.println(e);
        }
        return null;
    }

    public static boolean updateBySerial(String serial){
        return true;
    }
}
