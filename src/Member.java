public class Member {
    private String name;
    private int totalFines;
    private int totalBooksBorrowed; 

    Member(String memberName) {
        name = memberName;
        totalFines = 0;
        totalBooksBorrowed = 0;
    }

    // Getters to see member info
    public String getName() {
        return name;
    }

    public int getTotalFines() {
        return totalFines;
    }

    public int getTotalBooksBorrowed() {
        return totalBooksBorrowed;
    }

    // Methods to update member stats
    public void addFine(int amount) {
        totalFines += amount;
    }

    public void payFines() {
        totalFines = 0;
    }

    public void incrementBooksBorrowed() {
        totalBooksBorrowed++;
    }
}
