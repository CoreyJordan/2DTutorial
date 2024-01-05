package utils;

public class GameClock {
    private final int fps = 60;
    private final int oneSecond = 1_000_000_000; // nanoseconds
    private final double interval = (double)oneSecond / fps;
    private double delta;
    private long startTime;
    private int frames;
    private long timer;


    public GameClock() {
        delta = 0;
        startTime = System.nanoTime();
        timer = 0;
        frames = 0;
    }

    /**
     * Determines the amount of time passed in a loop and scales it to the game's FPS.
     *
     */
    public void tick() {
        long currentTime = System.nanoTime();
        delta += (currentTime - startTime) / interval;
        timer += currentTime - startTime;
        startTime = currentTime;
    }

    /**
     * Determines if enough time has passed to count one game frame. Decrements delta if true;
     *
     * @return
     */
    public boolean isAtFrame() {
        if (delta < 1) {
            return false;
        }

        delta--;
        frames++;
        return true;
    }

    /**
     * Determines if 1 second of real time has passed.
     * @return true if greater than 1 billion nanoseconds
     */
    public boolean oneSecondPassed() {
        if (timer < oneSecond) {
            return false;
        }
        return true;

    }

    /**
     * Returns the number of accumulated frames. Resets both the timer and frame count to 0. Mainly used for
     * development and debugging purposes.
     * @return Accumulated frames.
     */
    public int getFps() {
        int fps = frames;
        frames = 0;
        timer = 0;
        return fps;
    }
}
