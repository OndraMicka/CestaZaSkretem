package core;

import commands.Command;

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
}
