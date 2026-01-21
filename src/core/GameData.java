package core;

import characters.Enemy;
import characters.Player;
import com.google.gson.Gson;
import com.sun.tools.javac.Main;
import items.Item;
import rooms.FightRoom;

import java.io.*;
import java.nio.charset.StandardCharsets;
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

    /**
     * Loads game data from a JSON file.
     * @param resourcePath path to the resource file
     * @return a GameData object filled with the loaded data
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
//        Gson gson = new Gson();
//        try (InputStream in = new FileInputStream(resourcePath)) {
//                return gson.fromJson(
//                        in.toString(),
//                        GameData.class
//                );
//        } catch (Exception e) {
//            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
//        }

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