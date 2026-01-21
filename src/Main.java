import core.Game;
import core.GameData;

public class Main {
    public static void main(String[] args) {
        GameData gameData =  GameData.loadGameDataFromResources("resources/gameData.json");
        gameData.items.forEach(System.out::println);
        gameData.enemies.forEach(System.out::println);
        gameData.fightRooms.forEach(System.out::println);
        System.out.println(gameData.player);

    }
}