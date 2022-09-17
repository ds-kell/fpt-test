import dao.BOT_DAO;
import dao.FurnitureDAO;
import dao.VideoDAO;
import object.BookOnTape;
import object.Furniture;
import object.Video;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
        int selection = -1;
        while(selection != 0){
            System.out.println("\n----------------------Menu-------------------\n1. Add product\n2. Show all information of furniture\n3. View information by serial \n0. Finish");
            System.out.print("Your selection: ");
            selection = Integer.parseInt(sc.nextLine());
            if(selection == 1){
                int tmp = -1; // type of product
                System.out.println("\nEnter type of things: \n1. Video \n2. Furniture \n3. Book on tape \n0. Back\n");
                System.out.print("Select: ");
                tmp = Integer.parseInt(sc.nextLine());

                if(tmp == 1){
                    addVideo();
                }
                else if(tmp == 2){
                    addFurniture();
                }
                else if(tmp == 3){
                    addBOT();
                }
                else if(tmp != 0)
                    System.out.println("Invalid value");
            }
            else if(selection == 2){
                showAllInfor();
            }
            else if(selection == 3){
                System.out.print("Enter serial of things: ");
                String serial = sc.nextLine();
                getInforBySerial(serial);
            }
        }
    }
    static Scanner sc = new Scanner(System.in);

    //    --------------Question 1: ---------------------------------

    public static void addVideo() throws SQLException, ClassNotFoundException, ParseException {
        String name = "",  serial = "";
        float size = 0, price = 0;
        String time = "";
        System.out.print("Name: "); name =  sc.nextLine();
        System.out.print("Serial: "); serial = sc.nextLine();
        System.out.print("Size (MB): "); size = Float.parseFloat(sc.nextLine());
        System.out.print("Price ($): "); price = Float.parseFloat(sc.nextLine());
        Video video = VideoDAO.getVideoBySerial(serial);
        if(video == null){
            video = new Video(name, serial, size, price);
            boolean check = VideoDAO.addVideo(video);
            if(check)
                System.out.println("add successfully");
        }
        else{
            System.out.println("Things already exists!");
        }
    }
    public static void addFurniture() throws SQLException, ClassNotFoundException {
        String name = "",  serial = "";
        float  price = 0;
        String type = "", color = "";
        System.out.print("Name: "); name =  sc.nextLine();
        System.out.print("Serial: "); serial = sc.nextLine();
        System.out.print("Type: "); type = sc.nextLine();
        System.out.print("Color: "); color = (sc.nextLine());
        System.out.print("Price ($): "); price = Float.parseFloat(sc.nextLine());
        Furniture furniture = FurnitureDAO.getFurnitureBySerial(serial);
        if(furniture == null){
            furniture = new Furniture(name, serial, type, color, price);
            boolean check = FurnitureDAO.addFurniture(furniture);
            if(check)
                System.out.println("add successfully");
        }
        else{
            System.out.println("Things already exists!");
        }

    }
    public static void addBOT() throws SQLException, ClassNotFoundException {
        String name = "",  serial = "";
        float  price = 0;
        String author = "", pub_company  = "";
        System.out.print("Name: "); name =  sc.nextLine();
        System.out.print("Author: "); author = sc.nextLine();
        System.out.print("Serial: "); serial = sc.nextLine();
        System.out.print("Publishing company: "); pub_company = (sc.nextLine());
        System.out.print("Price ($): "); price = Float.parseFloat(sc.nextLine());
        BookOnTape bot = BOT_DAO.getBookOnTapeBySerial(serial);
        if(bot == null)
        {
            bot = new BookOnTape(name, author, serial,  pub_company, price);
            boolean check = BOT_DAO.addBOT(bot);
            if(check)
                System.out.println("add successfully");
        }
        else{
            System.out.println("Things already exists!");
        }
    }
//    ---------------Question 2:---------------------------
    public static void showAllInfor() throws SQLException, ClassNotFoundException {
        ArrayList<Furniture>  furniture = FurnitureDAO.getAllFurniture();
        System.out.println("\n----------------Furniture------------------\n");
        int c = 1;
        for(Furniture fur : furniture){
            System.out.println(c + "\n" +fur.getDescription());
            c += 1;
        }

    }
    //    ----------------Question 3:--------------------
    public static void getInforBySerial(String serial) throws SQLException, ClassNotFoundException {
        Video video = VideoDAO.getVideoBySerial(serial);
        BookOnTape bot = BOT_DAO.getBookOnTapeBySerial(serial);
        Furniture furniture = FurnitureDAO.getFurnitureBySerial(serial);
        if(video != null){
            System.out.println("\n---------------------\nType of things: VIDEO");
            System.out.println(video.getDescription());
        }
        if(furniture != null){
            System.out.println("\n---------------------\nType of things: FURNITURE");
            System.out.println(furniture.getDescription());
        }if(bot != null){
            System.out.println("\n---------------------\nType of things: BOOK ON TAPE");
            System.out.println(bot.getDescription());
        }
    }

}
