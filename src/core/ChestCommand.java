package core;

import commands.Command;

public class ChestCommand implements Command {
    private Game game;

    public ChestCommand(Game game) {
        this.game = game;
    }
    @Override
    public String execute() {
        //todo
        return "neni hotovo";
    }
}
