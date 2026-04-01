public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        while (true) {
            myLibrary.currentDay = myLibrary.currentDay + 1;
            System.out.println("\n--- Day " + myLibrary.currentDay + " ---");

            // Pick a random event
            int eventChoice = Rand.randomInt(0, 4);

            switch (eventChoice) {
                case 0:
                    System.out.println("It was a slow day at the library.");
                    break;

                case 1:
                    // Logic for borrowing a book
                    int memberPos = Rand.randomInt(0, myLibrary.memberList.length);
                    int bookPos = Rand.randomInt(0, myLibrary.bookCollection.length);
                    
                    Member person = myLibrary.memberList[memberPos];
                    Book book = myLibrary.bookCollection[bookPos];

                    if (book.isAvailable) {
                        book.isAvailable = false;
                        person.booksBorrowedCount++;
                        myLibrary.activeLoans.add(new Loan(book, person, myLibrary.currentDay));
                        System.out.println(person.name + " checked out " + book.title);
                    } else {
                        System.out.println(person.name + " wanted " + book.title + " but it's out.");
                    }
                    break;

                case 2:
                    // Logic for a random fine
                    int fineIndex = Rand.randomInt(0, myLibrary.memberList.length);
                    Member penalized = myLibrary.memberList[fineIndex];
                    penalized.finesOwing += 2;
                    System.out.println(penalized.name + " was late returning a book. $2 fine.");
                    break;

                case 3:
                    System.out.println("A librarian organized the shelves.");
                    break;
            }

            // Display status of all books
            System.out.println("\n--- Library Inventory ---");
            for (int i = 0; i < myLibrary.bookCollection.length; i++) {
                String shelfStatus = myLibrary.bookCollection[i].isAvailable ? "[In]" : "[Out]";
                System.out.println(shelfStatus + " " + myLibrary.bookCollection[i].title);
            }

            // Display member stats
            System.out.println("\n--- Member Records ---");
            for (int i = 0; i < myLibrary.memberList.length; i++) {
                Member m = myLibrary.memberList[i];
                System.out.println(m.name + " | Total Borrowed: " + m.booksBorrowedCount + " | Fines: $" + m.finesOwing);
            }

            Input.waitForUserToPressEnter("\nPress Enter for Day " + (myLibrary.currentDay + 1));
        }
    }
}
