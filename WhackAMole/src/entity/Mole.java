package entity;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mole extends Entity {
    public boolean hidden = false;
    public Image image;

    public Mole(Position pos) throws IOException {
        super(pos);
        this.image = ImageIO.read(getClass().getResourceAsStream("/res/mole.png")).getScaledInstance(50, 50, 0);
    }

    public void hide() {
        this.hidden = true;
    };
}