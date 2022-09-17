package object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Video extends Thing{
    private float size;
    public Video (){

    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public Video(String name, String serial,float size, float price) throws ParseException {
        super(name, serial, price);
        this.size = size;
    }

    @Override
    public String getDescription(){
        String des = "";
        des = "Name: " + super.getName() + "\nSerial: " + super.getSerial() + "\nSize: " + this.size + "MB\nPrice: " + super.getPrice() + "$";
        return des;
    }

}
