package core;

import commands.Command;
import features.ChestManager;
import items.Item;
import rooms.ItemRoom;
import rooms.Room;

import java.util.Scanner;

public class ChestCommand implements Command {
    private Game game;
    private ChestManager chestManager;

    public ChestCommand(Game game) {
        this.game = game;
        chestManager = new ChestManager(game.getGameData());
    }

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
                //TODO: add picked item to inventory
                game.getPlayer().getInventory().addItemInteractive(item);

                return "";


            }else {
                return "Už jsi truhlu otevřel.";
            }
        }else{
            return "Kolem tebe žádná truhla není.";
        }
    }
}
