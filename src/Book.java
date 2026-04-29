public class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor to set up the book
    Book(String bookTitle, String bookAuthor) {
        title = bookTitle;
        author = bookAuthor;
        isAvailable = true; // Books start on the shelf
    }

    // Getter for the title
    public String getTitle() {
        return title;
    }

    // Check if book is available
    public boolean isAvailable() {
        return isAvailable;
    }

    // Change the availability status
    public void setAvailable(boolean status) {
        isAvailable = status;
    }
}
