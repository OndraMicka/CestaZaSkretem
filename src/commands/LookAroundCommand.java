package commands;

import core.Game;

public class LookAroundCommand implements Command{
    private final Game game;
    @Override
    public String execute() {
        return game.getCurrentRoom().getInfo();
    }

    public LookAroundCommand(Game game){
        this.game = game;
    }
}
