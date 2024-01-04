package Objects;

import java.awt.*;

/**
 * Superclass for all actionable entities in the game.
 */
public abstract class Entity {
    private Point location;
    private int speed;

    public Entity(Point location, int speed) {
        this.location = location;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public Point getLocation() {
        return location;
    }

    public int getX() {
        return location.x;
    }

    public int getY() {
        return location.y;
    }

    public void move(int dx, int dy) {
        location.x += dx;
        location.y += dy;
    }
}
