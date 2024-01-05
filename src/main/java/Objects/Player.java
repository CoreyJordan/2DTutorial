package Objects;

import main.GamePanel;
import utils.Direction;
import utils.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import static utils.Direction.*;
import static utils.Globals.TILE_SIZE;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    Direction facing;

    public Player(GamePanel gamePanel, KeyHandler keyHandler, Point start) {
        super(start, 4);
        this.gp = gamePanel;
        this.keyH = keyHandler;

        facing = DOWN;
        getPlayerImage();
    }

    /**
     * Updates the current state of the player.
     */
    public void update () {
        updateMovement();
        cycleSprite();
    }

    private void cycleSprite() {
        if (!keyH.downPressed && !keyH.leftPressed && !keyH.upPressed && !keyH.rightPressed) {
            spriteIndex = 0;
            return;
        }

        spriteCounter++;
        if (spriteCounter > 7) {
            spriteIndex++;
            if (spriteIndex >= up.length) {
                spriteIndex = 0;
            }
            spriteCounter = 0;
        }

    }

    /**
     * Assembles the visual model to be rendered to the game screen.
     */
    public void draw(Graphics2D g) {

        BufferedImage image;
        switch (facing) {
            case UP:
                image = up[spriteIndex];
                break;
            case DOWN:
                image = down[spriteIndex];
                break;
            case LEFT:
                image = left[spriteIndex];
                break;
            default:
                image = right[spriteIndex];
                break;
        }

        g.drawImage(image, getX(), getY(), TILE_SIZE, TILE_SIZE, null);
    }

    private void updateMovement() {
        if (keyH.upPressed) {
            move(0, -getSpeed());
            facing = UP;
        } else if (keyH.downPressed) {
            move(0, getSpeed());
            facing = DOWN;
        } else if (keyH.leftPressed) {
            move(-getSpeed(), 0);
            facing = LEFT;
        } else if (keyH.rightPressed) {
            move(getSpeed(), 0);
            facing = RIGHT;
        }
    }

    public void getPlayerImage() {
        try {
            up = new BufferedImage[4];
            up[0] = ImageIO.read(new FileInputStream("resources/player/King_Up.png"));
            up[1] = ImageIO.read(new FileInputStream("resources/player/King_Up1.png"));
            up[2] = ImageIO.read(new FileInputStream("resources/player/King_Up.png"));
            up[3] = ImageIO.read(new FileInputStream("resources/player/King_Up2.png"));

            down = new BufferedImage[4];
            down[0] = ImageIO.read(new FileInputStream("resources/player/King_Idle.png"));
            down[1] = ImageIO.read(new FileInputStream("resources/player/King_Down2.png"));
            down[2] = ImageIO.read(new FileInputStream("resources/player/King_Idle.png"));
            down[3] = ImageIO.read(new FileInputStream("resources/player/King_Down1.png"));

            left = new BufferedImage[4];
            left[0] = ImageIO.read(new FileInputStream("resources/player/King_Left.png"));
            left[1] = ImageIO.read(new FileInputStream("resources/player/King_Left1.png"));
            left[2] = ImageIO.read(new FileInputStream("resources/player/King_Left.png"));
            left[3] = ImageIO.read(new FileInputStream("resources/player/King_Left2.png"));

            right = new BufferedImage[4];
            right[0] = ImageIO.read(new FileInputStream("resources/player/King_Right.png"));
            right[1] = ImageIO.read(new FileInputStream("resources/player/King_Right1.png"));
            right[2] = ImageIO.read(new FileInputStream("resources/player/King_Right.png"));
            right[3] = ImageIO.read(new FileInputStream("resources/player/King_Right2.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
