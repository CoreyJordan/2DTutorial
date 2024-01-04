package utils;

public class Globals {

    // TILE SETTINGS
    public static final int SOURCE_TILE = 16;
    public static final int WORLD_SCALE = 3;
    public static final int TILE_SIZE = SOURCE_TILE * WORLD_SCALE;

    // SCREEN CHARACTERISTICS
    public static final int SCREEN_COLS = 16;
    public static final int SCREEN_ROWS = 12;
    public static final int SCREEN_WIDTH = TILE_SIZE * SCREEN_COLS;
    public static final int SCREEN_HEIGHT = TILE_SIZE * SCREEN_ROWS;

    // GAME SPEED
    public static final int FPS = 60;
    public static final double INTERVAL = 1_000_000_000.0 / FPS;


}
