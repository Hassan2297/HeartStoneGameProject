package exceptions;
/**
 *
 *  A subclass of HearthstoneException representing an exception that occurs when trying
 * to do an action with a wrong target.
 *
 * **/
public class InvalidTargetException extends HearthstoneException {

    public InvalidTargetException() {
        super();
    }

    public InvalidTargetException(String s) {
        super(s);
    }
}
