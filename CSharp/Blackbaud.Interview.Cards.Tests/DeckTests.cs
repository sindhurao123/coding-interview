using Xunit;

namespace Blackbaud.Interview.Cards.Tests;
public class DeckTests
{
    [Fact]
    public void CanCreateANewDeck()
    {
        var deck = Deck.NewDeck();
        Assert.Equal(52, deck.RemainingCards);
    }

}
