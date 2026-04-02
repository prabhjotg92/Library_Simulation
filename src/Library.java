import java.util.ArrayList;
// The Library class holds all the lists and the current date
public class Library {
    Date today;
    Book[] bookCollection;
    Member[] memberList;
    
    // ArrayList for loans because it can grow forever as people borrow books
    ArrayList<Loan> activeLoans;

    Library() {
        today = new Date(0);
        activeLoans = new ArrayList<Loan>();

        // list of 10 books
        bookCollection = new Book[10];
        bookCollection[0] = new Book("1984", "George Orwell");
        bookCollection[1] = new Book("Lord of The Rings", "J.R.R. Tolkien");
        bookCollection[2] = new Book("HXH Volume 1", "Yoshihiro Togashi");
        bookCollection[3] = new Book("Art of War", "Sun Tzu");
        bookCollection[4] = new Book("48 Laws of Power", "Robert Greene");
        bookCollection[5] = new Book("Fahrenheit 451", "Ray Bradbury");
        bookCollection[6] = new Book("To Kill a Mockingbird", "Harper Lee");
        bookCollection[7] = new Book("Harry Potter", "J.K. Rowling");
        bookCollection[8] = new Book("Diary of a Wimpy Kid", "Jeff Kinney");
        bookCollection[9] = new Book("Hunger Games", "Suzanne Collins");

        // list of 10 members
        memberList = new Member[10];
        memberList[0] = new Member("Eknoor Gill");
        memberList[1] = new Member("Prabhjot Gill");
        memberList[2] = new Member("Jayden Kerwal");
        memberList[3] = new Member("Arman Rai");
        memberList[4] = new Member("Marcus King");
        memberList[5] = new Member("Nick Reyes");
        memberList[6] = new Member("Hans Rivera");
        memberList[7] = new Member("Cole Zimmer");
        memberList[8] = new Member("Jarren De Guzman");
        memberList[9] = new Member("Gabriel Licup");
    }
}
