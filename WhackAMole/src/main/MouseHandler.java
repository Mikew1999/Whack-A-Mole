package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseMotionListener {
    public Game game;

    public MouseHandler(Game game) {
        this.game = game;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        game.hammer.position.xPos = e.getX();
        game.hammer.position.yPos = e.getY();
        System.out.println(this.game.hammer.position);
        game.gamePanel.update();
        game.gamePanel.repaint();
    }
}