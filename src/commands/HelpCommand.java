package commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class HelpCommand implements Command {
    @Override
    public String execute() {
        String text = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("/helpMessage.txt"));
            String line = "";
            while ((line = br.readLine())!= null){
                text += line + "\n";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return text;
    }
}
