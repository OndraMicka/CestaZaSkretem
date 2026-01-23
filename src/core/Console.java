package core;


import commands.EndCommand;
import commands.InventoryCommand;
import commands.MoveCommand;

import java.util.Scanner;

/**
 * Class control game loop, controls commands.
 */
public class Console {
    private final Game game;
    private final Scanner sc;
    private final CommandManager commandManager;

    /**
     * Prints out story. TODO
     * Starts game loop.
     * Prints out end of the game. TODO
     */
    public void start() {
        do {
            System.out.print(">>");
            String read = sc.nextLine();
            read = read.toLowerCase().trim();
            String result = commandManager.execute(read);
            if (result == null) {
                System.out.println("Neznámý příkaz, napiš 'help' pro vypsání příkazů.");
            } else {
                System.out.println(result);
            }
        } while (game.getCurrentRoom() != null);
    }

    /**
     * adds commands to hashMap.
     */
    public Console() {
        game = new Game();
        sc = new Scanner(System.in);

        this.commandManager = new CommandManager();
        commandManager.register("nextroom", new MoveCommand(game));
        commandManager.register("endgame", new EndCommand());
        commandManager.register("inventory",new InventoryCommand(game.getPlayer()));
    }
}
