package entity;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mole extends Entity {
    public boolean hidden = false;
    public Image currentImage;

    public Mole(Position pos) throws IOException {
        super(pos);
        this.currentImage = ImageIO.read(getClass().getResourceAsStream("/res/mole0.png")).getScaledInstance(50, 50, 0);
    }

    public void hide() {
        this.hidden = true;
    };
}