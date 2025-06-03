package main;

import javax.swing.JPanel;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable, IUpdate {

    public Game game;
    public int tileSize = 40;
    public int maxScreenCol = 15;
    public int maxScreenRow = 15;
    public int screenWidth = tileSize * maxScreenCol;
    public int screenHeight = tileSize * maxScreenRow;

    private Thread gameThread;

    public GamePanel(Game game) {
        this.game = game;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.LIGHT_GRAY);
        this.setDoubleBuffered(true);
        this.addMouseMotionListener(game.mouseHandler);
        this.addMouseListener(game.mouseHandler);
        // this.addKeyListener();
        this.setFocusable(true);
    };

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    };

    @Override
    public void run() {
        double drawInterval = 1000000000/game.FPS;  // 1 second / 60
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (game.gameRunning) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        };
    }

    @Override
    public void update() {
        game.moleHandler.update();
    };

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawString("Score: " + game.scoreHandler.getScore(), screenWidth - 60, 20);
        this.game.moleHandler.paint(g2);
        this.game.hammer.paint(g2);
        g2.dispose();
    }
}