package main;

import utils.GameClock;
import utils.KeyHandler;

import javax.swing.*;
import java.awt.*;

import static utils.Globals.*;

public class GamePanel extends JPanel implements Runnable{

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();

    private int playerX = 100;
    private int playerY = 100;
    private int playerSpeed = 4;


    public GamePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(keyH);
        setFocusable(true);
    }

    /**
     * Creates a new instance of the Thread and starts it, which in turn executes run().
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Game loop for the main game panel.
     */
    @Override
    public void run() {

        GameClock gameClock = new GameClock();
        while (gameThread != null) {
            gameClock.tick(INTERVAL);

            if (gameClock.isAtFrame()) {
                update();

                repaint();
            }

            if (gameClock.oneSecondPassed()) {
                System.out.println(gameClock.getFps());
            }

        }

    }

    /**
     * Updates the game model each loop.
     */
    public void update() {
        if (keyH.upPressed) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed) {
            playerY += playerSpeed;
        } else if (keyH.leftPressed) {
            playerX -= playerSpeed;
        } else if (keyH.rightPressed) {
            playerX += playerSpeed;
        }
    }

    /**
     * Draws components in the game loop through the repaint() method.
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.WHITE);
        g2D.fillRect(playerX, playerY, TILE_SIZE, TILE_SIZE);
        g2D.dispose();

    }
}
