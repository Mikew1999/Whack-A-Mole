package main;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.Point;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting game...");
        JFrame window = new JFrame();
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        // Create a new blank cursor.
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
            cursorImg, new Point(0, 0), "blank cursor"
        );
        // Set the blank cursor to the JFrame.
        window.getContentPane().setCursor(blankCursor);
        window.setCursor(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Whack a mole");
        Game game = new Game();
        GamePanel gamePanel = new GamePanel(game);
        game.setupGamePanel(gamePanel);
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
