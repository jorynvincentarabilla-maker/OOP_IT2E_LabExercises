public class ProjectTester {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", "James Gosling");
        Magazine magazine = new Magazine("Tech Monthly", "Various Authors");
        DVD dvd = new DVD("Inception", "Christopher Nolan");

        book.displayInfo();
        magazine.displayInfo();
        dvd.displayInfo();
    }
}