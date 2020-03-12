package exceptions;
/**
 *
 *  A subclass of HearthstoneException representing an exception that occurs when trying
 * to attack with a minion that is not yet summoned to the field (i.e. still in hand).
 *
 * **/
public class NotSummonedException extends HearthstoneException {

    public NotSummonedException() {
        super();
    }

    public NotSummonedException(String s) {
        super(s);
    }
}
