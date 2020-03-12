package exceptions;
/**
 *
 *  Class representing a generic exception that can occur during the game play. These
 * exceptions arise from any invalid action that is performed. No instances of this exception can be
 * created.
 *
 * **/
public abstract class HearthstoneException extends Exception {

    public HearthstoneException() {
        super();
    }

    public HearthstoneException(String s) {
        super(s);
    }
}
