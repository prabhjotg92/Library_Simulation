public class Loan {
    private Book borrowedBook;
    private Member borrower;
    private int dayBorrowed;
    private int randomReturnDay; 

    Loan(Book b, Member m, int day) {
        borrowedBook = b;
        borrower = m;
        dayBorrowed = day;
        // Members keep a book for 1 to 10 days
        randomReturnDay = day + Rand.randomInt(1, 11);
    }

    // Getters for loan details
    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public Member getBorrower() {
        return borrower;
    }

    public int getDayBorrowed() {
        return dayBorrowed;
    }

    public int getRandomReturnDay() {
        return randomReturnDay;
    }
}
