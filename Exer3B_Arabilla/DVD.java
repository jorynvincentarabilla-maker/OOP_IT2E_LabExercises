public class DVD extends Item {
    public DVD(String title, String author) {
        super(title, author);
    }

    public void displayInfo() {
        System.out.println("DVD - " + title + " | Director: " + author);
    }
}