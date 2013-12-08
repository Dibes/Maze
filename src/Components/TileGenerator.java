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
public class TileGenerator {

    private final int MAPWIDTH = Maze.MAPWIDTH;
    private final int MAPHEIGHT = Maze.MAPHEIGHT;
    private final int TILESIZE = Maze.TILESIZE;
    public static ArrayList<int[]> mapTiles = new ArrayList();
    public static ArrayList<int[]> wallTiles = new ArrayList();

    /*
     * Need to create a way to put 4 walls around each tile, and then have access to them...
     */
    public TileGenerator() {
        // Generation of the tiles goes in here!
        for(int i = 0; i < getHorizAmount(MAPWIDTH, TILESIZE); i++) {
            for (int j = 0; j < getVertAmount(MAPHEIGHT, TILESIZE); j++) {
                // Create a blank template of tiles to work with.
                this.addTile(i, j, TILESIZE * i, TILESIZE * j, 2, 0);
            }
        }
    }

    public void addTile(int xCoord, int yCoord, int xLoc, int yLoc, int wallBuffer, int isFilled) {
        int wallWidth = TILESIZE - wallBuffer;

        mapTiles.add(new int[]{xCoord, yCoord, xLoc, yLoc, isFilled});

        /*
         * Wall Array Definitions
         *  - X Coordinate
         *  - Y Coordinate
         *  - X Location
         *  - Y Location
         *  - Width of wall
         *  - Position of wall
         *      - 0 = Top
         *      - 1 = Bottom
         *      - 2 = Left
         *      - 3 = Right
         */

        // Top Wall
        wallTiles.add(new int[]{xCoord, yCoord, xLoc + wallBuffer, yLoc, wallWidth, 0});
        // Bottom Wall
        wallTiles.add(new int[]{xCoord, yCoord, xLoc + wallBuffer, yLoc + (TILESIZE - wallBuffer), wallWidth, 1});
        // Left Wall
        wallTiles.add(new int[]{xCoord, yCoord, xLoc, yLoc + wallBuffer, wallBuffer, 2});
        // Right Wall
        wallTiles.add(new int[]{xCoord, yCoord, xLoc + (TILESIZE - wallBuffer), yLoc + wallBuffer, wallBuffer, 3});
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
