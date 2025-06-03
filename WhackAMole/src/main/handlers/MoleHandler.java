package main.handlers;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.stream.IntStream;

import javax.imageio.ImageIO;

import entity.Mole;
import entity.Position;
import main.GamePanel;
import main.IUpdate;

public class MoleHandler implements IUpdate {

    public Mole[] moles = new Mole[9];
    public GamePanel gamePanel;
    public int[] hittableMoles = new int[2];
    public int hitMole = -1;
    public Image[] images = new Image[3];

    public MoleHandler(GamePanel gamePanel) throws IOException {
        this.gamePanel = gamePanel;
        setupImages();
        setupMoles();
    };

    private void setupImages() throws IOException {
        this.images[0] = ImageIO.read(getClass().getResourceAsStream("/res/mole0.png")).getScaledInstance(50, 50, 0);
        this.images[1] = ImageIO.read(getClass().getResourceAsStream("/res/mole50.png")).getScaledInstance(50, 50, 0);
        this.images[2] = ImageIO.read(getClass().getResourceAsStream("/res/mole100.png")).getScaledInstance(50, 50, 0);
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
                ),
                this.images
            );
        };
        hittableMoles[0] = pickRandom(-1);
        hittableMoles[1] = pickRandom(hittableMoles[0]);
    };

    private int pickRandom(int not) {
        int randomPick = (int) (Math.random() * 9);
        if (randomPick == not) return pickRandom(not);
        return randomPick;
    };

    @Override
    public void update() {
        try {
            // check for hit moles
            if (hitMole != -1) {
                gamePanel.game.scoreHandler.incrementScore();
                moles[hitMole].changeVisibility(0);
                if (hittableMoles[0] == hitMole) hittableMoles[0] = pickRandom(hitMole);
                if (hittableMoles[1] == hitMole) hittableMoles[1] = pickRandom(hitMole);
                hitMole = -1;
            }

            for (int i = 0; i < 9; i++) {
                final int index = i;
                if (IntStream.of(hittableMoles).anyMatch(x -> x == index)) {
                    moles[i].changeVisibility(100);
                } else {
                    moles[i].changeVisibility(0);
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    };

    public void checkHitMole(int xPos, int yPos) {
        int moleHit = -1;
        for (int index : hittableMoles) {
            Position molePosition = moles[index].position;
            if (index == -1) continue;
            int leftPos = molePosition.xPos - 35;
            int rightPos = molePosition.xPos + 35;
            int topPos = molePosition.yPos - 35;
            int bottomPos = molePosition.yPos + 35;

            if (
                xPos >= leftPos &&
                xPos <= rightPos &&
                yPos >= topPos &&
                yPos <= bottomPos
            ) {
                moleHit = index;
                break;
            }
        }

        if (moleHit == -1) return;

        hitMole = moleHit;
    };

    public void paint(Graphics2D g2) {
        for (Mole mole : this.moles) {
            g2.drawImage(mole.currentImage, mole.position.xPos, mole.position.yPos, null);
        }
    }
}