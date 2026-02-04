package commands;

import core.Game;
import features.QuestionManager;
import items.Item;
import rooms.ItemRoom;

import java.util.Scanner;

public class QuestionCommand implements Command {

    private final Game game;
    private final QuestionManager questionManager;
    private Scanner scanner;

    public QuestionCommand(Game game) {
        questionManager = new QuestionManager(game);
        this.game = game;
        scanner = new Scanner(System.in);
    }

    @Override
    public String execute() {
        if (game.getCurrentRoom().getClass().equals(ItemRoom.class)) {
            ItemRoom room = (ItemRoom) game.getCurrentRoom();
            if (!room.isQuestionAsked()) {
                System.out.println(questionManager.getQuestion());
                System.out.print(">>");
                String answer = scanner.nextLine();
                Item item = questionManager.answer(answer);
                if (item != null) {
                    game.getPlayer().getInventory().addItem(item);
                    room.setQuestionAsked(true);
                    return item.getPrintInfo();
                }
                return "";
            } else {
                return "Kouzelník: 'To pro tentokrát stačilo, další otázku dostaneš až za chvilku.'";
            }
        } else {
            return "Kouzelník: 'Další otázku dostaneš až za chvilku.'";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
