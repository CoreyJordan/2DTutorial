package main;

import utils.Globals;

import javax.swing.*;
import java.awt.*;

import static utils.Globals.*;

public class GamePanel extends JPanel implements Runnable{

    Thread gameThread;

    public GamePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
    }

    /**
     * Creates a new instance of the Thread and starts it, which in turn executes run().
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

    }
}
