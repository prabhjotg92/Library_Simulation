public class  Member {
    String name;
    int finesOwing;
    int booksBorrowedCount; // Track how many books this person has taken total

    Member(String memberName) {
        name = memberName;
        finesOwing = 0;
        booksBorrowedCount = 0;
    }
}
