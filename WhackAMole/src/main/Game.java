package main;

import java.io.IOException;

import entity.Hammer;
import entity.Position;

public class Game implements IUpdate, Runnable {

    public boolean gameRunning = true;

    public ScoreHandler scoreHandler;
    public GamePanel gamePanel;
    public MouseHandler mouseHandler;
    public Hammer hammer;
    public int FPS = 30;

    public Game()  {
        this.scoreHandler = new ScoreHandler();
        this.mouseHandler = new MouseHandler(this);
    };

    public void setupGamePanel(GamePanel panel) throws IOException {
        this.gamePanel = panel;
        this.hammer = new Hammer(new Position(this.gamePanel.screenWidth / 2, this.gamePanel.screenHeight / 2));
    }

    @Override
    public void run() {
    };

    public void startGame() {
        if (this.gamePanel == null) return;
        this.gamePanel.startGameThread();
    };

    public void update() {
        
    };

}
