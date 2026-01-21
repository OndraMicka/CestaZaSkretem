package core;

import commands.Command;

import java.util.HashMap;

public class CommandManager {
    private final HashMap<String, Command> commands;

    public CommandManager() {
        this.commands = new HashMap<>();
    }

    /**
     * Adds new command to HashMap commands.
     *
     * @param commandName key to the command like: help, endGame, fight
     * @param command     command class with execute method which will be called
     */
    public void register(String commandName, Command command) {
        commands.put(commandName, command);
    }

    /**
     * Calls command from given key.
     *
     * @param commandName key to the command like: help, endGame, fight
     * @return returns class command or null if command name is not found
     */
    public String execute(String commandName) {
        Command command = commands.get(commandName);
        if (command == null) {
            return null;
        }
        return command.execute();
    }

}