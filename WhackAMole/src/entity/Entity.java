package entity;

import main.IUpdate;

public class Entity implements IUpdate {
    public Position position;

    public Entity(Position pos) {
        this.position = pos;
    }

    public void update() {};
}
