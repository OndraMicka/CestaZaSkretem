package rooms;

public class ItemRoom extends Room {
    private boolean chestOpened;
    private boolean questionAsked;

    public ItemRoom(String info, boolean chestOpened, boolean questionAsked) {
        super(info);
        this.chestOpened = chestOpened;
        this.questionAsked = questionAsked;
    }

    public boolean isChestOpened() {
        return chestOpened;
    }

    public boolean isQuestionAsked() {
        return questionAsked;
    }

    @Override
    public String toString() {
        return "ItemRoom{" +
                "chestOpened=" + chestOpened +
                ", questionAsked=" + questionAsked +
                ", info='" + info + '\'' +
                '}';
    }
}
