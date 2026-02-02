package features;

import core.GameData;
import items.Item;

import java.util.LinkedList;
import java.util.Queue;

public class ChestManager {
    private Queue<Item> queue1;
    private Queue<Item> queue2;
    private Queue<Item> queue3;

    public ChestManager(GameData gameData) {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        queue3 = new LinkedList<>();
        queue1.add(gameData.items.get(0));
        queue2.add(gameData.items.get(1));

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
        //todo
    }

    public Item pick(String num) {
        Item item;
        switch (num) {
            case "1" -> item = queue1.poll();
            case "2" -> item = queue2.poll();
            case "3" -> item = queue3.poll();
            default -> {
                return null;
            }
        }
        return item;
    }
}
