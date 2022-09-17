package object;

public abstract class Thing {
    private String name;
    private String serial;
    private float price;

    public Thing(){}
    public Thing(String name, String serial, float price){
        this.name = name;
        this.serial = serial;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    abstract public String getDescription();
}
