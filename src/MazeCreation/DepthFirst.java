package MazeCreation;

import Components.Tile;
import Components.TileGenerator;
import Maze.*;

import java.util.ArrayList;
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

        // Set the starting tile as visited and current
        TileGenerator.setTileVisible(Maze.startingTile.getxCoord(), Maze.startingTile.getyCoord(), 0);
        TileGenerator.setTileCurrent(Maze.startingTile.getxCoord(), Maze.startingTile.getyCoord(), 1);
        // Grab the next random tile
        Tile lastTile = Maze.startingTile;
        Tile newTile = getNextTile(lastTile);

        setTileActive(newTile, lastTile);

        while(!TileGenerator.isTilesVisited()) {

            // Grab new tiles
            lastTile = newTile;

            /* Create a method that grabs a new tile based on the surrunding tiles available.
             *  This will be done by grabbing the surrounding tiles then assessing them on the following criteria
             *      - Is not visited yet
             *      - Is on the board
             *
             *  Once the tiles are grabbed and put into an array; choose one at random.
             */

            newTile = getNextTile(lastTile);
            setTileActive(newTile, lastTile);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void setTileActive(Tile newTile, Tile lastTile) {
        TileGenerator.setTileVisible(newTile.getxCoord(), newTile.getyCoord(), 0);
        TileGenerator.setTileCurrent(lastTile.getxCoord(), lastTile.getyCoord(), 0);
        TileGenerator.setTileCurrent(newTile.getxCoord(), newTile.getyCoord(), 1);

        if (newTile.getyCoord() > lastTile.getyCoord()) {
            TileGenerator.setWallVisible(newTile.getxCoord(), newTile.getyCoord(), 0, 0);
            TileGenerator.setWallVisible(lastTile.getxCoord(), lastTile.getyCoord(), 0, 1);
        } else if (newTile.getyCoord() < lastTile.getyCoord()) {
            TileGenerator.setWallVisible(newTile.getxCoord(), newTile.getyCoord(), 0, 1);
            TileGenerator.setWallVisible(lastTile.getxCoord(), lastTile.getyCoord(), 0, 0);
        }

        if (newTile.getxCoord() > lastTile.getxCoord()) {
            TileGenerator.setWallVisible(newTile.getxCoord(), newTile.getyCoord(), 0, 2);
            TileGenerator.setWallVisible(lastTile.getxCoord(), lastTile.getyCoord(), 0, 3);
        } else if (newTile.getxCoord() < lastTile.getxCoord()) {
            TileGenerator.setWallVisible(newTile.getxCoord(), newTile.getyCoord(), 0, 3);
            TileGenerator.setWallVisible(lastTile.getxCoord(), lastTile.getyCoord(), 0, 2);
        }

    }

    public Tile getNextTile(Tile lastTile) {

        Tile upperTile = TileGenerator.getTile(lastTile.getxCoord(), lastTile.getyCoord() - 1);
        Tile rightTile = TileGenerator.getTile(lastTile.getxCoord() + 1, lastTile.getyCoord());
        Tile leftTile = TileGenerator.getTile(lastTile.getxCoord() - 1, lastTile.getyCoord());
        Tile lowerTile = TileGenerator.getTile(lastTile.getxCoord(), lastTile.getyCoord() + 1);
        ArrayList<Tile> tiles = new ArrayList<Tile>();

        if (upperTile != null && upperTile.getyCoord() >= 0 && upperTile.getxCoord() >= 0 && Utility.isOnBoard(upperTile) && upperTile.getVisited() == 0) {
            tiles.add(upperTile);
        }

        if (rightTile != null && rightTile.getyCoord() >= 0 && rightTile.getxCoord() >= 0 && Utility.isOnBoard(rightTile) && rightTile.getVisited() == 0) {
            tiles.add(rightTile);
        }

        if (leftTile != null && leftTile.getyCoord() >= 0 && leftTile.getxCoord() >= 0 && Utility.isOnBoard(leftTile) && leftTile.getVisited() == 0) {
            tiles.add(leftTile);
        }

        if (lowerTile != null && lowerTile.getyCoord() >= 0 && lowerTile.getxCoord() >= 0 && Utility.isOnBoard(lowerTile) && lowerTile.getVisited() == 0) {
            tiles.add(lowerTile);
        }

        return tiles.get(Utility.randInt(0, tiles.size() - 1));
    }

}
