public class Loan {
    Book borrowedBook;
    Member borrower;
    int dayBorrowed;
    int randomReturnDay; // The day this specific person decides to return it

    Loan(Book b, Member m, int day) {
        borrowedBook = b;
        borrower = m;
        dayBorrowed = day;
        // Members might keep a book anywhere from 1 to 10 days
        randomReturnDay = day + Rand.randomInt(1, 11);
    }
}
