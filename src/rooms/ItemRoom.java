package rooms;

public class ItemRoom extends Room {
    private boolean chestOpened;
    private boolean questionAsked;



    public boolean isChestOpened() {
        return chestOpened;
    }

    public boolean isQuestionAsked() {
        return questionAsked;
    }

    public void setQuestionAsked(boolean questionAsked) {
        this.questionAsked = questionAsked;
    }

    public void setChestOpened(boolean chestOpened) {
        this.chestOpened = chestOpened;
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
