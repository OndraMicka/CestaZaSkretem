package commands;

/**
 * Used for factory method.
 */
public interface Command {
    /**
     * Actions like move, help, end game
     * @return info to be printed out for player to know, if action was successful.
     */
    String execute();

}
