package main.handlers;

import java.awt.Graphics2D;
import java.io.IOException;

import entity.Mole;
import entity.Position;
import main.GamePanel;

public class MoleHandler {

    public Mole[] moles = new Mole[9];
    public GamePanel gamePanel;

    public MoleHandler(GamePanel gamePanel) throws IOException {
        this.gamePanel = gamePanel;
        setupMoles();
    };

    private void setupMoles() throws IOException {
        int endWidth = gamePanel.screenWidth - 20;
        int endHeight = gamePanel.screenHeight - 80;
        int widthOffset = (int) ((endWidth - 20) / 3) - 50;
        int heigthOffset = (int) ((endHeight - 40) / 3) - 50;
        int height = 20;
        int width = widthOffset;
        for (int i = 1; i <= 9; i++) {
            if (i % 3 == 1) {
                height += heigthOffset;
                width = widthOffset;
            } else {
                width += widthOffset;
            }
            this.moles[i - 1] = new Mole(
                new Position(
                    width,
                    height
                )
            );
            System.out.println(String.format("Mole %d pos: %s", i, this.moles[i - 1].position));
        }
    };

    public void paint(Graphics2D g2) {
        for (Mole mole : this.moles) {
            g2.drawImage(mole.currentImage, mole.position.xPos, mole.position.yPos, null);
        }
    };
}
