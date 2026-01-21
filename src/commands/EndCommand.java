package commands;

import core.Game;

/**
 * implements Command, execute method to end program
 */
public class EndCommand implements Command {
    @Override
    public String execute() {
        System.exit(0);
        return "";
    }
}
