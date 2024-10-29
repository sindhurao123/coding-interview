namespace Blackbaud.Interview.Cards;

/// <summary>
/// Possible values for a card rank.
/// </summary>
public enum Rank
{
    Ace = 1,
    Two = 2,
    Three = 3,
    Four = 4,
    Five = 5,
    Six = 6,
    Seven = 7,
    Eight = 8,
    Nine = 9,
    Ten = 10,
    Jack = 11,
    Queen = 12,
    King = 13,
}

/// <summary>
/// Extension methods for a Rank
/// </summary>
public static class RankExtensions
{
    /// <summary>
    /// Returns an abbreviated string representation of the rank.
    /// 1-10 for numbers. J, Q, K, A for face cards.
    /// </summary>
    /// <param name="rank"></param>
    /// <returns></returns>
    /// <exception cref="InvalidOperationException"></exception>
    public static string ToShortString(this Rank rank) => rank switch
    {
        Rank.Ace => "A",
        Rank.Two => "2",
        Rank.Three => "3",
        Rank.Four => "4",
        Rank.Five => "5",
        Rank.Six => "6",
        Rank.Seven => "7",
        Rank.Eight => "8",
        Rank.Nine => "9",
        Rank.Ten => "10",
        Rank.Jack => "J",
        Rank.Queen => "Q",
        Rank.King => "K",
        _ => throw new InvalidOperationException(),
    };
}
