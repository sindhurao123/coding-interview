namespace Blackbaud.Interview.Cards;

/// <summary>
/// Possible values for a card suit.
/// </summary>
public enum Suit
{
    Spades,
    Hearts,
    Diamonds,
    Clubs,
}

/// <summary>
/// Extension methods for a Suit
/// </summary>
public static class SuitExtensions
{
    /// <summary>
    /// Returns an abbreviated string representation of the suit.
    /// </summary>
    /// <param name="suit"></param>
    /// <returns></returns>
    /// <exception cref="InvalidOperationException"></exception>
    public static string ToShortString(this Suit suit) => suit switch
    {
        Suit.Spades => "S",
        Suit.Hearts => "H",
        Suit.Clubs => "C",
        Suit.Diamonds => "D",
        _ => throw new InvalidOperationException(),
    };
}
