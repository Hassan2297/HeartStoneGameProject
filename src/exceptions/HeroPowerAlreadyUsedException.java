package exceptions;
/**
 *
 *  A subclass of HearthstoneException representing an exception that occurs when a hero
 * attempts to use their hero power more than once per turn.
 *
 * **/
public class HeroPowerAlreadyUsedException extends HearthstoneException {

    public HeroPowerAlreadyUsedException() {
        super();
    }

    public HeroPowerAlreadyUsedException(String s) {
        super(s);
    }
}
