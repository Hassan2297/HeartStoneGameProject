package exceptions;
/**
 *
 *  A subclass of HearthstoneException representing an exception that occurs when trying
 * to add a minion card to an already full field.
 *
 * **/
public class FullFieldException extends HearthstoneException {
    public FullFieldException() {
        super();
    }

    public FullFieldException(String s) {
        super(s);
    }
}
