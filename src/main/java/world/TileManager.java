package world;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

import static utils.Globals.*;

public class TileManager {
    GamePanel gp;
    Tile[] tiles;
    int[][] mapTile;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tiles = new Tile[10];
        mapTile = new int[SCREEN_COLS][SCREEN_ROWS];

        loadTileImage();
        loadMap();
    }

    public void loadTileImage() {
        try {
            tiles[0] = new Tile(ImageIO.read(new File("resources/tiles/Floor1.png")));
            tiles[1] = new Tile(ImageIO.read(new File("resources/tiles/Wall.png")));
            tiles[2] = new Tile(ImageIO.read(new File("resources/tiles/Water.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        try {
            InputStream inStream = new FileInputStream("resources/maps/map.txt");
            BufferedReader inReader = new BufferedReader(new InputStreamReader(inStream));

            for (int i = 0; i < SCREEN_ROWS; i++) {
                String line = inReader.readLine();
                String[] numbers = line.split(" ");
                for (int j = 0; j < SCREEN_COLS; j++) {
                    int num = Integer.parseInt(numbers[j]);
                    mapTile[j][i] = num;


                }
            }

            inStream.close();
            inReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        int col = 0;
        int row = 0;

        while (col < SCREEN_COLS && row < SCREEN_ROWS) {
            int tileNum = mapTile[col][row];

            g.drawImage(tiles[tileNum].getImage(), TILE_SIZE * col, TILE_SIZE * row, TILE_SIZE, TILE_SIZE, null);
            col++;

            if (col == SCREEN_COLS) {
                col = 0;
                row++;
            }
        }
    }

}
