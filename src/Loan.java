public class Loan {
    Book borrowedBook;
    Member borrower;
    int dayBorrowed;
    int dueDate; // New field to show when it should be back

    Loan(Book theBook, Member theMember, int day) {
        borrowedBook = theBook;
        borrower = theMember;
        dayBorrowed = day;
        dueDate = day + 7; // Books are due in 7 days
    }
}
