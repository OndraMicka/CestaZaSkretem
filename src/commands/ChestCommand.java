package commands;

import core.Game;
import features.ChestManager;
import items.Item;
import rooms.ItemRoom;

import java.util.Scanner;

/**
 * Command for opening chests and giving player items.
 */
public class ChestCommand implements Command {
    private Game game;
    private ChestManager chestManager;

    public ChestCommand(Game game) {
        this.game = game;
        chestManager = new ChestManager(game);
    }

    /**
     * Checks whether the player is in the correct room and has not already opened the chest.
     * Displays three items for the player to choose from.
     * Allows the player to select one item by index.
     * The selected item is added to the player's inventory using
     * {@link core.Inventory#addItemInteractive(Item)}.
     *
     * @return reason why the chest cannot be opened, or null if successful
     */
    @Override
    public String execute() {
        if (game.getCurrentRoom().getClass().equals(ItemRoom.class)) {
            ItemRoom room = (ItemRoom)game.getCurrentRoom();
            if (!room.isChestOpened()) {
                Scanner scanner = new Scanner(System.in);
                System.out.println(chestManager.getInfoItems());
                Item item;
                do {
                    System.out.print(">>");
                    String choice = scanner.nextLine();
                    item = chestManager.pick(choice);
                } while (item == null);
                room.setChestOpened(true);
                game.getPlayer().getInventory().addItemInteractive(item);

                return "";


            }else {
                return "*Už jsi truhlu otevřel.";
            }
        }else{
            return "*Kolem tebe žádná truhla není.";
        }
    }
    @Override
    public boolean exit() {
        return false;
    }
}
