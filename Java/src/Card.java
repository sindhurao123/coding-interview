public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        return String.format("%s of %s", rank, suit);
    }

    public String toShortString() {
        return String.format("%s%s", rank.toShortString(), suit.toShortString());
    }

    public boolean equals(Card other) {
        return rank == other.rank && suit == other.suit;
    }
}
