public class Member {
    String name;
    int totalFines;
     int totalBooksBorrowed; // Track how many books this person has taken total

    Member(String memberName) {
        name = memberName;
        totalFines = 0;
        totalBooksBorrowed = 0;
    }
}
