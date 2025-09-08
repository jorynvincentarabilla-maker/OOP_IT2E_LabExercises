public class Smartphone {

    private String brand;
    private String model;
    private String color;
    private String storage;
    private String ram;
    private String battery;
    private String os;

    // no-argument constructor
    public Smartphone() {
        this.brand = "No Brand";
        this.model = "No Model";
        this.color = "No Color";
        this.storage = "No Storage";
        this.ram = "No RAM";
        this.battery = "No Battery Info";
        this.os = "No OS";
    }

    // argument constructor
    public Smartphone(String brand, String model, String color,
                      String storage, String ram, String battery, String os) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.storage = storage;
        this.ram = ram;
        this.battery = battery;
        this.os = os;
    }

    public String displayInfo() {
        String info = "";
        info += "Brand: " + this.brand;
        info += "\nModel: " + this.model;
        info += "\nColor: " + this.color;
        info += "\nStorage: " + this.storage;
        info += "\nRAM: " + this.ram;
        info += "\nBattery: " + this.battery;
        info += "\nOperating System: " + this.os;
        System.out.println(info + "\n");
        return info;
    }
}