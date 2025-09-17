public class Tricycle extends LandTransport {
    public Tricycle(String name, int capacity, String color, String brand, String engineNo, String engineType, String plateNo) {
        super(name, capacity, color, brand, engineNo, engineType, plateNo);
    }

    public void displayInfo() {
        System.out.println("\n--- Tricycle ---");
        super.displayInfo();
    }
}