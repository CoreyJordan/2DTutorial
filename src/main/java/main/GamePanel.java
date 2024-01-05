package main;

import Objects.Player;
import utils.GameClock;
import utils.KeyHandler;

import javax.swing.*;
import java.awt.*;

import static utils.Globals.*;

public class GamePanel extends JPanel implements Runnable{

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    Point playerStart = new Point(100,100);
    Player player;


    public GamePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(keyH);
        setFocusable(true);
    }

    /**
     * Creates a new instance of the Player and Thread, then starts the thread, which in turn executes run().
     */
    public void startGameThread() {
        player = new Player(this, keyH, playerStart);

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
            gameClock.tick();

            if (gameClock.isAtFrame()) {
                update();

                repaint();
            }

        }

    }

    /**
     * Updates the game model each loop.
     */
    public void update() {
        player.update();
    }

    /**
     * Draws components in the game loop through the repaint() method.
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        player.draw(g2D);

        g2D.dispose();

    }
}
