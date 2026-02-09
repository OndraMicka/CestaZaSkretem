package core;


import commands.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.Scanner;

/**
 * Class control game loop, controls commands.
 */
public class Console {
    private final Game game;
    private final Scanner sc;
    private final CommandManager commandManager;

    /**
     * Lets player chose name.
     * Prints out story.
     * Starts game loop.
     * From given string executes command.
     * Prints out end of the game.
     */
    public void start() {
        System.out.print("Zadej jméno hráče:");
        game.getPlayer().setName(sc.nextLine());
        System.out.println("\n");
        printOutFile("resources/introduction.txt");

        boolean exit = false;
        do {
            System.out.print(">>");
            String read = sc.nextLine();
            //Pouzito ChatGPT pro upravu inputu.
            //-----
            read = Normalizer.normalize(read, Normalizer.Form.NFD)
                    .replaceAll("\\p{M}", "")
                    .replaceAll("\\s+", "")
                    .toLowerCase();
            //-----
            String result = commandManager.execute(read);
            exit = commandManager.exit(read);
            if (result == null) {
                System.out.println("Neznámý příkaz, napiš 'pomoc' pro vypsání příkazů.");
            } else {
                System.out.println(result);
            }
        } while (game.getCurrentRoom() != null & !exit);

        if (!exit) {
            printOutFile("resources/end.txt");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            printOutFile("resources/endPart2.txt");
        }
    }

    /**
     * adds commands to hashMap.
     */
    public Console() {
        game = new Game();
        sc = new Scanner(System.in);

        this.commandManager = new CommandManager();
        commandManager.register("hledatokolo", new LookAroundCommand(game));
        commandManager.register("pomoc", new HelpCommand());
        commandManager.register("jitdal", new MoveCommand(game));
        commandManager.register("konechry", new EndCommand());
        commandManager.register("inventar", new InventoryCommand(game.getPlayer()));
        commandManager.register("bojovat", new FightCommand(game));
        commandManager.register("truhla", new ChestCommand(game));
        commandManager.register("otazka", new QuestionCommand(game));

    }

    /**
     * Method to read all text from provided file.
     * @param fileName path to file
     */
    private void printOutFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
