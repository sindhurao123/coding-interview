# Blackbaud C# interview question

This readme contains [instructions for setting up](#instructions) the code for the interview.
It also contains the [first question](#question).

Completing this problem before your scheduled interview is **optional**.

---

# <a name="instructions"></a>Solution setup

The `Blackbaud.Interview` directory contains starter code for your upcoming coding interview.
Prior to your interview, please take some time to ensure you can edit the files and compile the
application.

During the coding interview you will edit the attached solution files in an IDE while sharing your
screen.

Visual Studio, VS Code, or Rider are all acceptable IDEs. The code targets .NET 6.0.

If you are unable to use an IDE during the interview, a browser-based option is available using
[https://vscode.dev](https://vscode.dev). Using vscode.dev requires signing in with either a GitHub
or Microsoft account.

## Helpful links

-   [Visual Studio 2022 Community Edition](https://visualstudio.microsoft.com/downloads/)
-   [VS Code](https://code.visualstudio.com/) with the
    [C# extension](https://marketplace.visualstudio.com/items?itemName=ms-dotnettools.csharp)
-   [.NET 6.0 SDK](https://dotnet.microsoft.com/en-us/download)

---

# <a name="question"></a>Deck of cards interview question

## The Deck of cards

You have been given an object model (in Blackbaud.Interview.Cards) for a
standard deck of 52 playing cards.

-   52 cards. The value of each card is the combined rank and suit.
-   13 ranks: Numbers 2-10, Jack, Queen, King, and Ace
-   4 suits: Spades, Hearts, Diamonds, and Clubs

A new deck always has the same order for the cards.

The code in Program.cs deals all the cards
and displays the value (rank & suit) of each.

## Part 1 - Shuffling

Requirement: The deck of cards needs to be shuffled a given number of times.

After shuffling, deal all the cards and display the value (rank & suit) of each.
