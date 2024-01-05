package Objects;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Superclass for all actionable entities in the game.
 */
public abstract class Entity {
    private Point location;
    private int speed;

    // Entity animations
    protected BufferedImage[] up;
    protected BufferedImage[] down;
    protected BufferedImage[] left;
    protected BufferedImage[] right;

    protected int spriteCounter = 0;
    protected int spriteIndex = 0;

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
