package main;

public class ScoreHandler {
    private int score;

    public ScoreHandler() {
        this.score = 0;
    }

    public int incrementScore() {
        this.score += 1;
        return this.score;
    }

    public void resetScore() {
        this.score = 0;
    }
}
