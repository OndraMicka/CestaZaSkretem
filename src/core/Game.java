package core;

import characters.Player;

import rooms.Room;


import java.util.Queue;

public class Game {
    private Queue<Room> rooms;
    private Room actualRoom;
    private GameData gameData;
    private Player player;
    private CommandMannager commandMannager;

}
