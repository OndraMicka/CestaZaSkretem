package core;

import commands.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.Scanner;

/**
 * Class control game loop, controls commands.
 */
public class Console {
    private Game game;
    private final Scanner sc;
    private final CommandManager commandManager;
    private final String SAVE_FILE = "savegame.txt";

    /**
     * Lets player chose name.
     * Prints out story.
     * Starts game loop.
     * From given string executes command.
     * Prints out end of the game.
     */
    public void start() {
        if (game.getPlayer().getName() == null || game.getPlayer().getName().isEmpty()) {
            System.out.print("Zadej jméno hráče:");
            game.getPlayer().setName(sc.nextLine());
            System.out.println("\n");
            printOutFile("introduction.txt");
        } else {
            System.out.println("\nVítej zpět, " + game.getPlayer().getName() + "!\n");
        }

        boolean exit = false;
        do {
            System.out.print(">>");
            if (!sc.hasNextLine()) break;
            String read = sc.nextLine();

            read = Normalizer.normalize(read, Normalizer.Form.NFD)
                    .replaceAll("\\p{M}", "")
                    .replaceAll("\\s+", "")
                    .toLowerCase();

            String result = commandManager.execute(read);
            exit = commandManager.exit(read);
            if (result == null) {
                System.out.println("Neznámý příkaz, napiš 'pomoc' pro vypsání příkazů.");
            } else {
                System.out.println(result);
            }
        } while (game.getCurrentRoom() != null & !exit);

        if (!exit) {
            printOutFile("end.txt");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            printOutFile("endPart2.txt");
        }
    }

    /**
     * adds commands to hashMap.
     */
    public Console() {
        this.sc = new Scanner(System.in);
        File saveFile = new File(SAVE_FILE);

        if (saveFile.exists()) {
            System.out.print("Nalezen uložený postup. Chceš v něm pokračovat? (ano/ne): ");
            String choice = sc.nextLine().toLowerCase();
            if (choice.contains("a") || choice.contains("ano")) {
                this.game = Game.load(SAVE_FILE);
            }
        }

        if (this.game == null) {
            this.game = new Game();
        }

        this.commandManager = new CommandManager();
        commandManager.register("hledatokolo", new LookAroundCommand(game));
        commandManager.register("pomoc", new HelpCommand());
        commandManager.register("jitdal", new MoveCommand(game));
        commandManager.register("konechry", new EndCommand());
        commandManager.register("inventar", new InventoryCommand(game.getPlayer()));
        commandManager.register("bojovat", new FightCommand(game));
        commandManager.register("truhla", new ChestCommand(game));
        commandManager.register("otazka", new QuestionCommand(game));

        commandManager.register("ulozit", new SaveCommand(game, SAVE_FILE));
    }

    /**
     * Method to read all text from provided file.
     *
     * @param fileName path to file
     */
    private void printOutFile(String fileName) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            InputStream stream = is;
            if (stream == null) {
                File localFile = new File("src/main/resources/" + fileName);
                if (localFile.exists()) {
                    stream = new FileInputStream(localFile);
                } else {
                    return;
                }
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Chyba při čtení textového souboru: " + e.getMessage());
        }
    }
}
