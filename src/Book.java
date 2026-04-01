public class Book {
    String title;
    String author;
    boolean isAvailable;

    // Constructor to set up the book
    Book(String bookTitle, String bookAuthor) {
        title = bookTitle;
        author = bookAuthor;
        isAvailable = true; // Books start on the shelf
    }
}
