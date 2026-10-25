package postclass06;

public final class Card {
    private final Rank aRank;
    private final Suit aSuit;

    private Card(Rank pRank, Suit pSuit) {
        aRank = pRank;
        aSuit = pSuit;
    }

    public static Card get(Rank pRank, Suit pSuit) {
        return new Card(pRank, pSuit);
    }

    public Rank getRank() { return aRank; }
    public Suit getSuit() { return aSuit; }
}