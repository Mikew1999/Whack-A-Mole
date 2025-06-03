package entity;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hammer extends Entity {
    Image image;
    
    public Hammer(Position pos) throws IOException {
        super(pos);
        this.image = ImageIO.read(getClass().getResourceAsStream("/res/basicHammer.png")).getScaledInstance(100, 100, 0);
    };

    @Override
    public void update() {
        
    };

    public void paint(Graphics2D g2) {
        g2.drawImage(image, position.xPos, position.yPos, null);
    };
}