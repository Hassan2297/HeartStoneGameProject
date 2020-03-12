package exceptions;

import model.cards.Card;

/**
 *
 * A subclass of HearthstoneException representing an exception that occurs when trying
 * to add a card to an already full hand.
 *
 * **/
public class FullHandException extends HearthstoneException {
    private Card burned;

    public FullHandException(Card b) {
        this.burned = b;
    }

    public FullHandException(String s, Card b) {
        super(s);
        this.burned = b;
    }

    public Card getBurned() {
        return burned;
    }

    public void setBurned(Card burned) {
        this.burned = burned;
    }
}
