package core;

import characters.Enemy;
import characters.Player;
import com.google.gson.Gson;
import items.Item;
import rooms.FightRoom;
import rooms.ItemRoom;

import java.io.*;
import java.util.ArrayList;

/**
 * Represents the game data loaded from a JSON file.
 * This class serves as a data container for all static game content, such as items, characters, locations, and quests.
 *
 */
public class GameData {

    public ArrayList<Item> items;
    public ArrayList<Enemy> enemies;
    public Player player;
    public ArrayList<FightRoom> fightRooms;
    public ArrayList<ItemRoom> itemRooms;

    /**
     * Loads game data from a JSON file.
     * @param resourcePath path to the resource file
     * @return a GameData object filled with the loaded data
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
        Gson gson = new Gson();
        try (Reader rd = new FileReader(resourcePath)) {
            return gson.fromJson(
                    rd,
                    GameData.class
            );
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }


}