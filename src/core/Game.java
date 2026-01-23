package core;

import characters.Enemy;
import characters.Player;

import rooms.FightRoom;
import rooms.ItemRoom;
import rooms.Room;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Stores all rooms player can enter, player and game data.
 */
public class Game {
    private final Queue<Room> rooms;
    private final Player player;
    private final GameData gameData;

    /**
     * Loads game data from json,
     * adds all rooms to queue.
     */
    public Game() {
        gameData = GameData.loadGameDataFromResources("resources/gameData.json");
        player = gameData.player;

        ItemParser itemParser = new ItemParser(this);
        for (int i = 0; i < gameData.enemies.size(); i++) {
            Enemy enemy = gameData.enemies.get(i);
            for (String id : enemy.getItemsID()) {
                enemy.getInventory().addItem(itemParser.getItem(id));
            }
        }
        ArrayList<String> IDs = player.getItemsID();
        for (int i = 0; i < player.getItemsID().size(); i++) {
            player.getInventory().addItem(itemParser.getItem(IDs.get(i)));
        }

        EnemyParser enemyParser = new EnemyParser(this);
        for (FightRoom fightRoom:gameData.fightRooms) {
            fightRoom.setEnemy(enemyParser.getEnemy(fightRoom.getEnemyName()));
        }

        rooms = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            rooms.add(gameData.itemRooms.get(i));
            rooms.add(gameData.itemRooms.get(i+1));
            rooms.add(gameData.itemRooms.get(i+2));
            rooms.add(gameData.fightRooms.get(i));
        }
        rooms.add(gameData.fightRooms.get(3));


    }

    public Queue<Room> getRooms() {
        return rooms;
    }

    public Player getPlayer() {
        return player;
    }

    public GameData getGameData() {
        return gameData;
    }

    /**
     * moves player to the next room
     * @return if queue is empty, returns false, used for game loop to stop
     */
    public boolean goToNextRoom(){
        return rooms.poll() != null;
    }

    /**
     * returns actual room where player is.
     * @return FightRoom or ItemRoom
     */
    public Room getCurrentRoom(){
        return rooms.peek();
    }
}
