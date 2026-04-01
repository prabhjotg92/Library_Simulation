public class Loan {
    Book borrowedBook;
    Member borrower;
    int dayBorrowed;

    Loan(Book b, Member m, int day) {
        borrowedBook = b;
        borrower = m;
        dayBorrowed = day;
    }
}
