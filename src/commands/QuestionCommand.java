package commands;

import core.Game;

public class QuestionCommand implements Command {

    private Game game;

    public QuestionCommand(Game game) {
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
