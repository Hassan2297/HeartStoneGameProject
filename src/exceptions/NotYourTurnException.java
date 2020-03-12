package exceptions;
/**
 *
 *  A subclass of HearthstoneException representing an exception that occurs when a hero
 * attempts to perform an action outside their turn.
 *
 * **/
public class NotYourTurnException extends HearthstoneException {

    public NotYourTurnException() {
        super();
    }

    public NotYourTurnException(String s) {
        super(s);
    }
}
