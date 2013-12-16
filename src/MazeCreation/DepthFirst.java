package MazeCreation;

import Components.Tile;
import Components.TileGenerator;
import Maze.*;

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
        Tile newTile = TileGenerator.getTile(Utility.getHorizNext(lastTile.getxCoord(), -1, 1), Utility.getVertNext(lastTile.getyCoord(), -1, 1));
        while(!TileGenerator.isTilesVisited()) {
            // I want to pick a random tile around
            if (newTile.getxCoord() < 0 || newTile.getyCoord() < 0) {
                System.out.println(newTile.getxCoord() + " " + newTile.getyCoord());
            }

            TileGenerator.setTileVisible(newTile.getxCoord(), newTile.getyCoord(), 0);
            TileGenerator.setTileCurrent(lastTile.getxCoord(), lastTile.getyCoord(), 0);
            TileGenerator.setTileCurrent(newTile.getxCoord(), newTile.getyCoord(), 1);
            // Grab new tiles
            lastTile = newTile;
            newTile = TileGenerator.getTile(Utility.getHorizNext(lastTile.getxCoord(), -1, 1), Utility.getVertNext(lastTile.getyCoord(), -1, 1));

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("_____________________________________________________________");
        }

    }
}
