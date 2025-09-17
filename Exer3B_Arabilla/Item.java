public class Item {
    String title;
    String author;

    public Item(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Title: " + title + " | Author: " + author);
    }
}