public class SmartphoneTester {

    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("Apple", "iPhone 14 Pro", "Black",
                                       "256GB", "6GB", "3200mAh", "iOS");

        Smartphone s2 = new Smartphone("Samsung", "Galaxy S23", "White",
                                       "512GB", "12GB", "5000mAh", "Android");

        Smartphone s3 = new Smartphone();

        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();
    }
}