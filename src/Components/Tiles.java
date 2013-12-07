package Components;

import Maze.Maze;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Jon
 * Date: 12/7/13
 * Time: 1:51 PM
 */

/*
 * In order to create an actual tile. I need to create a method to get a tile.
 * The tiles will be defined in a hash map with respective coordinates for each.
 * They will hold the following info in an array
 *  - X Coord
 *  - Y Coord
 *  - X loc
 *  - Y loc
 *  - Is filled
 *      - 0 is not filled
 *      - 1 is filled
 */
public class Tiles {

    private final int MAPWIDTH = Maze.MAPWIDTH;
    private final int MAPHEIGHT = Maze.MAPHEIGHT;
    private final int TILESIZE = Maze.TILESIZE;
    public static ArrayList<int[]> mapTiles = new ArrayList();

    public Tiles() {
        // Generation of the tiles goes in here!
        for(int i = 0; i < getHorizAmount(MAPWIDTH, TILESIZE); i++) {
            for (int j = 0; j < getVertAmount(MAPHEIGHT, TILESIZE); j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    this.addTile(i, j, TILESIZE * i, TILESIZE * j, 0);
                } else {
                    this.addTile(i, j, TILESIZE * i, TILESIZE * j, 1);
                }
            }
        }
    }

    public void addTile(int xCoord, int yCoord, int xLoc, int yLoc, int isFilled) {
        mapTiles.add(new int[]{xCoord, yCoord, xLoc, yLoc, isFilled});
    }

    public Tile getTile(int xCoord, int yCoord) {
        for (int[] tile : mapTiles) {
            if (tile[0] == xCoord && tile[1] == yCoord) {
                return new Tile(tile[0], tile[1], tile[2], tile[3], tile[4]);
            }
        }
        return null;
    }


    private int getVertAmount(int mapHeight, int tileSize) {
        return mapHeight / tileSize;
    }

    private int getHorizAmount(int mapWidth, int tileSize) {
        return mapWidth / tileSize;
    }

    private int getTileAmount(int mapWidth, int mapHeight, int tileSize) {
        return (mapWidth * mapHeight) / tileSize;
    }

}
