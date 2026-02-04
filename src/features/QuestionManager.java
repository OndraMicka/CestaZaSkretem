package features;

import com.google.gson.Gson;
import core.Game;
import core.GameData;
import core.ItemParser;
import items.Item;

import java.io.FileReader;
import java.io.Reader;
import java.text.Normalizer;
import java.util.LinkedList;
import java.util.Queue;

public class QuestionManager {
    private final Queue<Question> questions;

    public QuestionManager(Game game) {
        Gson gson = new Gson();
        try (Reader rd = new FileReader("resources/questions.json")) {
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

    public Item answer(String answer) {
        Question question = questions.poll();
        answer = Normalizer.normalize(answer, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .replaceAll("\\s+", "")
                .toLowerCase();
        if (question.getAnswers().contains(answer)){
            System.out.println("Kouzelník: Správně, zde je tvůj item.");
            System.out.println(question.getItem().getPrintInfo());
            return question.getItem();
        }
        System.out.println(question.getText());
        return null;
        //todo
    }
}
