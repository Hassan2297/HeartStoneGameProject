package exceptions;
/**
 *
 *  A subclass of HearthstoneException representing an exception that occurs when a hero
 * attempts to perform an action with insufficient mana, e.g. playing a card or using hero power.
 *
 * **/
public class NotEnoughManaException extends HearthstoneException {

    public NotEnoughManaException() {
        super();
    }

    public NotEnoughManaException(String s) {
        super(s);
    }
}
