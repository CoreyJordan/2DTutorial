package Objects;

import main.GamePanel;
import utils.KeyHandler;

import java.awt.*;

import static utils.Globals.TILE_SIZE;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gamePanel, KeyHandler keyHandler, Point start) {
        super(start, 4);
        this.gp = gamePanel;
        this.keyH = keyHandler;

    }

    /**
     * Updates the current state of the player.
     */
    public void update () {
        updateMovement();
    }



    /**
     * Assembles the visual model to be rendered to the game screen.
     */
    public void draw(Graphics2D g) {

        g.setColor(Color.WHITE);
        g.fillRect(this.getX(), this.getY(), TILE_SIZE, TILE_SIZE);

    }

    private void updateMovement() {
        if (keyH.upPressed) {
            move(0, -getSpeed());
        } else if (keyH.downPressed) {
            move(0, getSpeed());
        } else if (keyH.leftPressed) {
            move(-getSpeed(), 0);
        } else if (keyH.rightPressed) {
            move(getSpeed(), 0);
        }
    }
}
