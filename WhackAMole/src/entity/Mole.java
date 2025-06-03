package entity;

import java.awt.Image;
import java.io.IOException;

public class Mole extends Entity {
    public Image currentImage;
    public long imageLastUpdated = System.nanoTime();
    public int visibility = 0;  // 0 / 50 / 100
    private Image[] images = new Image[3];
    

    public Mole(Position pos, Image[] images) {
        super(pos);
        this.images = images;
        this.currentImage = this.images[0];
    }

    public void changeVisibility(int visibility) throws IOException {
        if (visibility == 0) {
            this.currentImage = this.images[0];
        } else if (visibility == 50) {
            this.currentImage = this.images[1];
        } else if (visibility == 100) {
            this.currentImage = this.images[2];
        };
    };

    public void hide() throws IOException {
        this.currentImage = this.images[0];
    };
}