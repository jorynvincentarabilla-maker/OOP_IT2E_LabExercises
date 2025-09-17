public class Kariton extends LandTransport {
    public Kariton(String name, int capacity, String color) {
        super(name, capacity, color);
    }

    public void displayInfo() {
        System.out.println("\n--- Kariton ---");
        super.displayInfo(); // no engine, brand, plate
    }
}