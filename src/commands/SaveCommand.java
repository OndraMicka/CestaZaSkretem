package commands;

import core.Game;

public class SaveCommand implements Command {
    private Game game;
    private String fileName;

    public SaveCommand(Game game, String fileName) {
        this.game = game;
        this.fileName = fileName;
    }

    @Override
    public String execute() {
        game.save(fileName);
        return "Hra byla úspěšně uložena.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
