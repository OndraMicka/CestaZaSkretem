package commands;

import core.Game;

public class FightCommand implements Command {
    private Game game;

    public FightCommand(Game game) {
        this.game = game;
    }

    @Override
    public String execute() {
        //todo
        return "neni hotovo";
    }
    @Override
    public boolean exit() {
        return false;
    }

}
