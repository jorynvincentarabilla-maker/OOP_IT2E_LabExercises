public class Magazine extends Item {
    public Magazine(String title, String author) {
        super(title, author);
    }

    public void displayInfo() {
        System.out.println("Magazine - " + title + " | Author: " + author);
    }
}