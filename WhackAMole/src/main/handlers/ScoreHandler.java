package main.handlers;

public class ScoreHandler {
    private int score;

    public ScoreHandler() {
        this.score = 0;
    }

    public int incrementScore() {
        this.score += 1;
        System.out.println(String.format("The score is now: %d", this.score));
        return this.score;
    }

    public int getScore() {
        return this.score;
    }

    public void resetScore() {
        this.score = 0;
    }
}
