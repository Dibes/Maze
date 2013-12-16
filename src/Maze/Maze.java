package Maze;

import Components.Board;
import Components.Tile;
import Components.TileGenerator;
import MazeCreation.DepthFirst;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jon
 * Date: 12/7/13
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Maze {

    public static final int MAPWIDTH = 600;
    public static final int MAPHEIGHT = 600;
    public static final int TILESIZE = 20;
    public static int WALLBUFFER = 5;
    private final int WIDTHBUFFER = 16;
    private final int HEIGHTBUFFER = 38;
    public static Tile startingTile;

    public static void main(String[] args) {
        new Maze();
    }

    public Maze() {
        // Create a jframe
        JFrame mazeFrame = new JFrame();
        mazeFrame.setTitle("Maze");
        // Add the board to the frame
        mazeFrame.add(new Board());
        mazeFrame.setBackground(Color.BLACK);
        mazeFrame.setSize(MAPWIDTH + WIDTHBUFFER, MAPHEIGHT + HEIGHTBUFFER);
        mazeFrame.setVisible(true);
        mazeFrame.setResizable(false);
        mazeFrame.setDefaultCloseOperation(mazeFrame.EXIT_ON_CLOSE);
        startingTile = TileGenerator.getTile(0, 0);
        // Test wall and tile color changes
        // Set the starting tile as visited
        DepthFirst depthFirst = new DepthFirst();



    }

}
