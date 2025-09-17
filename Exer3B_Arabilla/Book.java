public class Book extends Item {
    public Book(String title, String author) {
        super(title, author);
    }

    public void displayInfo() {
        System.out.println("Book - " + title + " | Author: " + author);
    }
}