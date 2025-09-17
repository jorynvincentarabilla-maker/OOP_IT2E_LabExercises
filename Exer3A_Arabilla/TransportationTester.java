public class TransportationTester {
    public static void main(String[] args) {

        Airplane airplane = new Airplane("Airbus A320", 180, "White", "Airbus", "ENG12345", "Jet Engine", "PAL-123");
        Helicopter helicopter = new Helicopter("Rescue Chopper", 6, "Red", "Bell", "ENG67890", "Turboshaft", "HEL-456");

        Truck truck = new Truck("Isuzu Truck", 3, "Blue", "Isuzu", "ENG111", "Diesel", "TRK-789");
        SUV suv = new SUV("Toyota Fortuner", 7, "Black", "Toyota", "ENG222", "Gasoline", "SUV-321");
        Tricycle tricycle = new Tricycle("Bajaj Tricycle", 4, "Yellow", "Bajaj", "ENG333", "Gasoline", "TRI-654");
        Motorcycle motorcycle = new Motorcycle("Honda CBR", 2, "Red", "Honda", "ENG444", "Gasoline", "MTR-987");
        Kariton kariton = new Kariton("Wooden Kariton", 1, "Brown");

        Boat boat = new Boat("Fishing Boat", 10, "White", "Yamaha", "ENG555", "Diesel", "BOT-246");
        Ship ship = new Ship("Passenger Ship", 500, "Gray", "Mitsubishi", "ENG666", "Diesel", "SHP-135");

        airplane.displayInfo();
        helicopter.displayInfo();
        truck.displayInfo();
        suv.displayInfo();
        tricycle.displayInfo();
        motorcycle.displayInfo();
        kariton.displayInfo();
        boat.displayInfo();
        ship.displayInfo();
    }
}