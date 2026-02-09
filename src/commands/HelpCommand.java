package commands;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Provides text with commands for player that he can use.
 */
public class HelpCommand implements Command {
    @Override
    public String execute() {
        String text = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("resources/helpMessage.txt"));
            String line = "";
            while ((line = br.readLine())!= null){
                text += line + "\n";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return text;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
