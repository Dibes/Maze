package Maze;

import Components.Board;
import Components.TileGenerator;

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
    public static final int TILESIZE = 40;
    public static int WALLBUFFER = 15;
    private final int WIDTHBUFFER = 16;
    private final int HEIGHTBUFFER = 38;

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
        
        // Test wall and tile color changes
        TileGenerator.setTileVisible(0, 0, 0);
        TileGenerator.setWallVisible(0, 0, 0, 3);
        TileGenerator.setWallVisible(0, 1, 0, 0);



    }

}
