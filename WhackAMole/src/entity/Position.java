package entity;

public class Position {
    public int xPos;
    public int yPos;

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public String toString() {
        return String.format("X: %d Y: %d", xPos, yPos);
    }
}
