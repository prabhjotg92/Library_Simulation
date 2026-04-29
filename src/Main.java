public class Main {
    // Keep track of daily stats as static variables for easy access in this class
    private static int booksBorrowedToday = 0;
    private static int booksReturnedToday = 0;
    private static int finesCollectedToday = 0;

    public static void main(String[] args) {
        Library lib = new Library();

        Input.waitForUserToPressEnter("Press Enter to start Day 1");

        while (true) {
            lib.today.dayNumber++;
            
            // Reset daily counters
            booksBorrowedToday = 0;
            booksReturnedToday = 0;
            finesCollectedToday = 0;

            System.out.println("DAY " + lib.today.dayNumber);
            System.out.println("------------------------------------");

            // Run 10 potential actions per day
            for (int i = 0; i < 10; i++) {
                int actionType = Rand.randomInt(0, 3);

                if (actionType == 0) {
                    processBorrow(lib);
                }
                else if (actionType == 1) {
                    processReturn(lib);
                }
                else {
                    processFine(lib);
                }
            }

            printDailySummary(lib);
            Input.waitForUserToPressEnter("\nEnd of Day " + lib.today.dayNumber + ". Press Enter for next day");
        }
    }

    // Method to handle borrowing logic
    private static void processBorrow(Library lib) {
        Member m = lib.memberList[Rand.randomInt(0, 10)];
        Book b = lib.bookCollection[Rand.randomInt(0, 10)];
        
        if (b.isAvailable()) {
            b.setAvailable(false);
            m.incrementBooksBorrowed();
            lib.activeLoans.add(new Loan(b, m, lib.today.dayNumber));
            booksBorrowedToday++;
            System.out.println("EVENT: " + m.getName() + " checked out " + b.getTitle());
        }
    }

    // Method to handle returning logic
    private static void processReturn(Library lib) {
        if (lib.activeLoans.size() > 0) {
            int randomIndex = Rand.randomInt(0, lib.activeLoans.size());
            Loan l = lib.activeLoans.get(randomIndex);

            if (lib.today.dayNumber >= l.getRandomReturnDay()) {
                lib.activeLoans.remove(randomIndex);
                l.getBorrowedBook().setAvailable(true);
                booksReturnedToday++;

                int daysKept = lib.today.dayNumber - l.getDayBorrowed();
                if (daysKept > 7) {
                    int penalty = (daysKept - 7) * 1;
                    l.getBorrower().addFine(penalty);
                    System.out.println("EVENT: " + l.getBorrower().getName() + " returned " + l.getBorrowedBook().getTitle() + " LATE. Fine added: $" + penalty);
                } else {
                    System.out.println("EVENT: " + l.getBorrower().getName() + " returned " + l.getBorrowedBook().getTitle() + " on time.");
                }
            }
        }
    }

    // Method to handle paying fines
    private static void processFine(Library lib) {
        Member m = lib.memberList[Rand.randomInt(0, 10)];
        if (m.getTotalFines() > 0) {
            finesCollectedToday += m.getTotalFines();
            System.out.println("EVENT: " + m.getName() + " paid a fine of $" + m.getTotalFines());
            m.payFines();
        }
    }

    // Method to print the end-of-day report
    private static void printDailySummary(Library lib) {
        System.out.println("\nDaily Report Summary:");
        System.out.println("Books Taken Out: " + booksBorrowedToday);
        System.out.println("Books Returned:  " + booksReturnedToday);
        System.out.println("Fines Collected: $" + finesCollectedToday);

        System.out.println("\nMember Ledger:");
        for (Member m : lib.memberList) {
            System.out.println(m.getName() + " | Unpaid Fines: $" + m.getTotalFines() + " | Total Borrowed: " + m.getTotalBooksBorrowed());
        }
    }
}
