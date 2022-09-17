package object;

public class Furniture extends Thing{

    private String type;
    private String color;
    public Furniture(){}
    public Furniture(String name, String serial, String type, String color, float price){
        super(name, serial, price);
        this.type = type;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription(){
        String des = "";
        des = "Name " + super.getName() + "\nType: " + this.type + "\nColor: " + this.color  + "\nSerial: " + super.getSerial() + "\nPrice: " + super.getPrice() +"$";
        return des;
    }
}
