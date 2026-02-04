package features;

import items.Item;
import items.ItemId;

import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> answers;
    private String text;
    private Item item;
    private ItemId itemId;

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public String getText() {
        return text;
    }

    public Item getItem() {
        return item;
    }

    public ItemId getItemId() {
        return itemId;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
