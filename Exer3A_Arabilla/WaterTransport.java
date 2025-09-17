public class WaterTransport extends Transportation {
    String brand;
    String engineNo;
    String engineType;
    String plateNo;

    public WaterTransport(String name, int capacity, String color, String brand, String engineNo, String engineType, String plateNo) {
        super(name, capacity, color);
        this.brand = brand;
        this.engineNo = engineNo;
        this.engineType = engineType;
        this.plateNo = plateNo;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Brand: " + brand + " | Engine No: " + engineNo + " | Engine Type: " + engineType + " | Plate No: " + plateNo);
    }
}