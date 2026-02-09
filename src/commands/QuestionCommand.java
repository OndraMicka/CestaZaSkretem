package commands;

import core.Game;
import features.QuestionManager;
import items.Item;
import rooms.ItemRoom;

import java.util.Scanner;

/**
 * Command to ask question.
 */
public class QuestionCommand implements Command {

    private final Game game;
    private final QuestionManager questionManager;
    private Scanner scanner;

    public QuestionCommand(Game game) {
        questionManager = new QuestionManager(game);
        this.game = game;
        scanner = new Scanner(System.in);
    }

    /**
     * Checks whether the player is in the correct room and has not already asked a question.
     * Displays question for player.
     * Allows the player to answer.
     * If correct, returns item to player inventory.
     * {@link core.Inventory#addItemInteractive(Item)}.
     * @return reason why the question cannot be asked, or null if told
     */
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
                    game.getPlayer().getInventory().addItemInteractive(item);
                    room.setQuestionAsked(true);
                    return "";
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
