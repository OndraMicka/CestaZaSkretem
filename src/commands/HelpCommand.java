package commands;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Provides text with commands for player that he can use.
 */
public class HelpCommand implements Command {
    @Override
    public String execute() {
        StringBuilder text = new StringBuilder();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("helpMessage.txt")) {

            if (is == null) {
                throw new RuntimeException("Soubor helpMessage.txt nebyl nalezen v JARu!");
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    text.append(line).append("\n");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání nápovědy: " + e.getMessage());
        }
        return text.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
