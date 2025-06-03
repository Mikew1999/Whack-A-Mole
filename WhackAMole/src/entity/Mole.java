package entity;

import java.awt.Image;

public class Mole extends Entity {
    public Image currentImage;
    public long imageLastUpdated = System.nanoTime();
    public int visibility = 0;  // 0 / 50 / 100

    private Image[] images = new Image[3];
    

    public Mole(Position pos, Image[] images) {
        super(pos);
        this.images = images;
        this.currentImage = this.images[0];
        this.visibility = 0;
    }

    public void changeVisibility(int vis) {
        if (vis != this.visibility) this.imageLastUpdated = System.nanoTime();
        if (vis == 0) {
            this.currentImage = this.images[0];
        } else if (vis == 50) {
            this.currentImage = this.images[1];
        } else if (vis == 100) {
            this.currentImage = this.images[2];
        };
        this.visibility = vis;
        
    };
}