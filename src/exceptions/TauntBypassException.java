package exceptions;
/**
 *
 *   A subclass of HearthstoneException representing an exception that occurs when a
 * minion is trying to attack a target while the opponent has a taunt minion(s) in their field.
 *
 * **/
public class TauntBypassException extends HearthstoneException {

    public TauntBypassException() {
        super();
    }

    public TauntBypassException(String s) {
        super(s);
    }
}
