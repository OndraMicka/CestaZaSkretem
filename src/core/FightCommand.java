package core;

import commands.Command;

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


}
