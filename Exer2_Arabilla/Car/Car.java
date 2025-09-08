public class Car {

    private String color;
    private String plateNo;
    private String chassisNo;
    private String brand;
    private String model;
    private String engineType;
    private String transmission;

    // no-argument constructor
    public Car() {
        this.color = "No Color";
        this.plateNo = "No Plate Number";
        this.chassisNo = "No Chassis No Yet";
        this.brand = "No Brand";
        this.model = "No Model";
        this.engineType = "No Engine Type";
        this.transmission = "No Transmission";
    }

    public Car(String color, String plateNo, String chassisNo, 
               String brand, String model, 
               String engineType, String transmission) {
        this.color = color;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
        this.brand = brand;
        this.model = model;
        this.engineType = engineType;
        this.transmission = transmission;
    }

    public String displayInfo() {
        String info = "";
        info += "Brand: " + this.brand;
        info += "\nModel: " + this.model;
        info += "\nColor: " + this.color;
        info += "\nPlate No: " + this.plateNo;
        info += "\nChassis No: " + this.chassisNo;
        info += "\nEngine Type: " + this.engineType;
        info += "\nTransmission: " + this.transmission;
        System.out.println(info + "\n");
        return info;
    }
}