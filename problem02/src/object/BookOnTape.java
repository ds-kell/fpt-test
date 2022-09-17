package object;

import java.text.SimpleDateFormat;

public class BookOnTape extends Thing{
    private String author;
    private String pub_company;
    public BookOnTape(){}
    public BookOnTape(String name, String author, String serial, String pub_company, float price){
        super(name, serial, price);
        this.author = author;
        this.pub_company = pub_company;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPub_company() {
        return pub_company;
    }

    public void setPub_company(String pub_company) {
        this.pub_company = pub_company;
    }

    @Override
    public String getDescription(){
        String des = "";
        des = "Name: " + super.getName() + "\nAuthor " + this.author + "\nPublishing company: " + this.pub_company  + "\nSerial: " + super.getSerial() + "\nPrice: " + super.getPrice() + "$";
        return des;
    }
}
