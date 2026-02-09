package commands;

import core.Game;

/**
 * Prints out text with info (what is around player)
 */
public class LookAroundCommand implements Command{
    private final Game game;
    @Override
    public String execute() {
        return game.getCurrentRoom().getInfo();
    }

    public LookAroundCommand(Game game){
        this.game = game;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
