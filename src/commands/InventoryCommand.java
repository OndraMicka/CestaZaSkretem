package commands;

import characters.Player;
import core.Game;

public class InventoryCommand implements Command{
    private Player player;

    public InventoryCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        return player.getInventory().toString();
    }
}
