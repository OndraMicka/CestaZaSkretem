package features;

import core.Game;
import items.Item;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages item picking from chest.
 * Chest is divided into 3 queues.
 */
public class ChestManager {
    private Queue<Item> queue1;
    private Queue<Item> queue2;
    private Queue<Item> queue3;

    /**
     * Adds all items to queues from GameData.itemsInChest
     * queue 1 - first 5 items
     * queue 2 - next 5 items
     * queue 3 - only one item
     * @param game instance of Game, for loading data and itemParser
     */
    public ChestManager(Game game) {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        queue3 = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            Item item = game.getItemParser().getItem(game.getGameData().itemsInChest.get(i).getId()).copyOfItem();
            if (game.getGameData().itemsInChest.get(i).getDurability() != 0) {
                item.setDurability(game.getGameData().itemsInChest.get(i).getDurability());
            }
            queue1.add(item);
        }
        for (int i = 5; i < 10; i++) {
            Item item = game.getItemParser().getItem(game.getGameData().itemsInChest.get(i).getId()).copyOfItem();
            if (game.getGameData().itemsInChest.get(i).getDurability() != 0) {
                item.setDurability(game.getGameData().itemsInChest.get(i).getDurability());
            }
            queue2.add(item);
        }
        Item item = game.getItemParser().getItem(game.getGameData().itemsInChest.get(10).getId()).copyOfItem();
        if (game.getGameData().itemsInChest.get(10).getDurability() != 0) {
            item.setDurability(game.getGameData().itemsInChest.get(10).getDurability());
        }
        queue3.add(item);


    }

    /**
     * Prints out 3 available items from queues with method peek()
     * @return
     */
    public String getInfoItems() {
        String info1 = "xxx";
        String info2 = "xxx";
        String info3 = "xxx";
        if ((queue1.peek()) != null) {
            info1 = queue1.peek().getPrintInfo();
        }
        if ((queue2.peek()) != null) {
            info2 = queue2.peek().getPrintInfo();
        }
        if ((queue3.peek()) != null) {
            info3 = queue3.peek().getPrintInfo();
        }
        String info = "Vyber si z itemů(1,2,3): \n";
        info += "1. " + info1 + "\n";
        info += "2. " + info2 + "\n";
        info += "3. " + info3 + "\n";
        return info;
    }

    /**
     * Returns item and removes it from queue.
     * Not picked items rotates to the end of 3rd queue.
     * @param num String index of item("1","2","3").
     * @return Null if num does not mach any index otherwise returns item from queue.
     */
    public Item pick(String num) {
        Item item;
        switch (num) {
            case "1" -> {
                item = queue1.poll();
                queue3.offer(queue2.poll());
                queue3.offer(queue3.poll());
            }
            case "2" -> {
                item = queue2.poll();
                queue3.offer(queue1.poll());
                queue3.offer(queue3.poll());
            }
            case "3" -> {
                item = queue3.poll();
                queue3.offer(queue2.poll());
                queue3.offer(queue1.poll());
            }
            default -> {
                return null;
            }
        }
        return item;
    }

}
