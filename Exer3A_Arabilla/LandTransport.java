public class LandTransport extends Transportation {
    String brand;
    String engineNo;
    String engineType;
    String plateNo;

    public LandTransport(String name, int capacity, String color, String brand, String engineNo, String engineType, String plateNo) {
        super(name, capacity, color);
        this.brand = brand;
        this.engineNo = engineNo;
        this.engineType = engineType;
        this.plateNo = plateNo;
    }

    public LandTransport(String name, int capacity, String color) {
        super(name, capacity, color);
    }

    public void displayInfo() {
        super.displayInfo();
        if (brand != null) {
            System.out.println("Brand: " + brand + " | Engine No: " + engineNo + " | Engine Type: " + engineType + " | Plate No: " + plateNo);
        }
    }
}