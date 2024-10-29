public enum Suit {
    SPADES("S"),
    HEARTS("H"),
    DIAMONDS("D"),
    CLUBS("C");

    private String shortString;

    Suit(String shortString) {
        this.shortString = shortString;
    }

    public String toShortString() {
        return shortString;
    }
}