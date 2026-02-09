package commands;

import characters.Player;
import core.Game;

/**
 * Command that shows inventory of player
 */
public class InventoryCommand implements Command{
    private Player player;

    public InventoryCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        return player.getInventory().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
