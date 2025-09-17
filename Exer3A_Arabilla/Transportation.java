public class Transportation {
    String name;
    int capacity;
    String color;

    public Transportation(String name, int capacity, String color) {
        this.name = name;
        this.capacity = capacity;
        this.color = color;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + " | Capacity: " + capacity + " | Color: " + color);
    }
}