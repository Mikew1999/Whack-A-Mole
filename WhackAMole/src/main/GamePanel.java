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
        // this.addKeyListener();
        this.setFocusable(true);
    };

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    };

    @Override
    public void run() {
    }

    @Override
    public void update() {};

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("repainting");
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        this.game.hammer.paint(g2);
        g2.dispose();
    }
}