public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        Input.waitForUserToPressEnter("Press Enter to start Day 1");

        while (true) {
            lib.today.dayNumber++;

            // Daily summary counters
            int booksBorrowedToday = 0;
            int booksReturnedToday = 0;
            int finesCollectedToday = 0;

            System.out.println("DAY " + lib.today.dayNumber);
            System.out.println("------------------------------------");

            // Run 10 potential actions per day
            for (int i = 0; i < 10; i++) {
                int actionType = Rand.randomInt(0, 3);

                if (actionType == 0) {
                    // Action barrow
                    Member m = lib.memberList[Rand.randomInt(0, 10)];
                    Book b = lib.bookCollection[Rand.randomInt(0, 10)];
                    if (b.isAvailable) {
                        b.isAvailable = false;
                        m.totalBooksBorrowed++;
                        lib.activeLoans.add(new Loan(b, m, lib.today.dayNumber));
                        booksBorrowedToday++;
                        System.out.println("EVENT: " + m.name + " checked out " + b.title);
                    }
                }
                else if (actionType == 1) {
                    // Action return (Check if anyone is ready to return their book)
                    if (lib.activeLoans.size() > 0) {
                        int randomIndex = Rand.randomInt(0, lib.activeLoans.size());
                        Loan l = lib.activeLoans.get(randomIndex);

                        // Only return if today is the day they decided to bring it back
                        if (lib.today.dayNumber >= l.randomReturnDay) {
                            lib.activeLoans.remove(randomIndex);
                            l.borrowedBook.isAvailable = true;
                            booksReturnedToday++;

                            // Calculate fine, $1 per day if kept over 7 days
                            int daysKept = lib.today.dayNumber - l.dayBorrowed;
                            if (daysKept > 7) {
                                int penalty = (daysKept - 7) * 1;
                                l.borrower.totalFines += penalty;
                                System.out.println("EVENT: " + l.borrower.name + " returned " + l.borrowedBook.title + " LATE. Fine added: $" + penalty);
                            } else {
                                System.out.println("EVENT: " + l.borrower.name + " returned " + l.borrowedBook.title + " on time.");
                            }
                        }
                    }
                }
                else {
                    // Action fine
                    Member m = lib.memberList[Rand.randomInt(0, 10)];
                    if (m.totalFines > 0) {
                        finesCollectedToday += m.totalFines;
                        System.out.println("EVENT: " + m.name + " paid a fine of $" + m.totalFines);
                        m.totalFines = 0;
                    }
                }
            }

            // Daily summary
            System.out.println("\nDaily Report Summary:");
            System.out.println("Books Taken Out: " + booksBorrowedToday);
            System.out.println("Books Returned:  " + booksReturnedToday);
            System.out.println("Fines Collected: $" + finesCollectedToday);

            System.out.println("\nMember Ledger:");
            for (Member m : lib.memberList) {
                System.out.println(m.name + " | Unpaid Fines: $" + m.totalFines + " | Total Borrowed: " + m.totalBooksBorrowed);
            }

            Input.waitForUserToPressEnter("\nEnd of Day " + lib.today.dayNumber + ". Press Enter for next day");
        }
    }
}
