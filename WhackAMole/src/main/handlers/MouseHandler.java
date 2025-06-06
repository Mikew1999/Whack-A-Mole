package main.handlers;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

import main.Game;

public class MouseHandler implements MouseInputListener {
    public Game game;

    public MouseHandler(Game game) {
        this.game = game;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        game.hammer.position.xPos = e.getX() - 25;
        game.hammer.position.yPos = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        game.moleHandler.checkHitMole(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}