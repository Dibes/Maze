package MazeCreation;

import Components.Tile;
import Components.TileGenerator;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Jon
 * Date: 12/7/13
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class DepthFirst {

    Random random = new Random();

    public DepthFirst() {

        while(!TileGenerator.isTilesVisited()) {
            // I want to pick a random tile around
            for (int[] tile : TileGenerator.getTiles()) {
                if (TileGenerator.getTile(tile[Tile.XCOORD], tile[Tile.YCOORD]).getVisited() == 0) {
                    TileGenerator.setTileVisible(tile[Tile.XCOORD], tile[Tile.YCOORD], 0);
                    TileGenerator.setWallVisible(tile[Tile.XCOORD], tile[Tile.YCOORD], 0, random.nextInt(3));

                }
            }
        }

    }
}
