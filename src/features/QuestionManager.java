package features;

import com.google.gson.Gson;
import core.Game;
import items.Item;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.Queue;

/**
 * Manages questions for player.
 */
public class QuestionManager {
    private final Queue<Question> questions;

    /**
     * Adds all questions from json.
     * Parses all items in questions from itemID.
     *
     * @param game Instance of game for itemParser
     */
    public QuestionManager(Game game) {
        Gson gson = new Gson();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("questions.json");
             Reader rd = new InputStreamReader(is, StandardCharsets.UTF_8)) {

            if (is == null) {
                throw new RuntimeException("Soubor questions.json nebyl nalezen v resources!");
            }
            questions = gson.fromJson(rd, QuestionManager.class).questions;

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }

        for (Question q : questions) {
            q.setItem(game.getItemParser().getItem(q.getItemId().getId()));
            if (q.getItemId().getDurability() != 0) {
                q.getItem().setDurability(q.getItemId().getDurability());
            }
        }
    }

    public String getQuestion() {
        return questions.peek().getQuestion();
    }

    /**
     * Controls if given answer matches any of possible answers.
     *
     * @param answer String answer from player.
     * @return Item if right, null if wrong
     */
    public Item answer(String answer) {
        Question question = questions.poll();
        answer = Normalizer.normalize(answer, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .replaceAll("\\s+", "")
                .toLowerCase();
        if (question.getAnswers().contains(answer)) {
            System.out.println("Kouzelník: Správně, zde je tvůj item.");
            System.out.println(question.getItem().getPrintInfo());
            return question.getItem();
        }
        System.out.println(question.getText());
        return null;
        //todo
    }

}
