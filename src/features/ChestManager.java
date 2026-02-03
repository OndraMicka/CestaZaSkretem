package features;

import core.Game;
import items.Item;

import java.util.LinkedList;
import java.util.Queue;

public class ChestManager {
    private Queue<Item> queue1;
    private Queue<Item> queue2;
    private Queue<Item> queue3;

    public ChestManager(Game game) {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        queue3 = new LinkedList<>();
        //TODO add items to queue

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
