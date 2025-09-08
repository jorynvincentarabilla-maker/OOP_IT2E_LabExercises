public class CarTester {

    public static void main(String[] args) {
        Car c1 = new Car("Black", "SAS123", "AR123",
                         "Toyota", "Vios", 
                         "Gasoline", "Automatic");

        Car c2 = new Car("White", "XYZ789", "CH456",
                         "Honda", "Civic", 
                         "Diesel", "Manual");

        Car c3 = new Car();

        c1.displayInfo();
        c2.displayInfo();
        c3.displayInfo();
    }
}
