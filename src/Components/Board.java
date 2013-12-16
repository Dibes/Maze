package Components;

import Maze.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Jon
 * Date: 12/7/13
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private final int MAPWIDTH = Maze.MAPWIDTH;
    private final int MAPHEIGHT = Maze.MAPHEIGHT;
    private final int TILESIZE = Maze.TILESIZE;
    private final int WALLBUFFER = Maze.WALLBUFFER;
    private TileGenerator tileGenerator = new TileGenerator();

    public Board() {
        timer = new Timer(15, this);
        timer.start();
    }

    // When the timer ticks an action is performed, thus it repaints the board.
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void paint(Graphics g) {
        for(int i = 0; i < getHorizAmount(MAPWIDTH, TILESIZE); i++) {
            for (int j = 0; j < getVertAmount(MAPHEIGHT, TILESIZE); j++) {
                Tile tile = tileGenerator.getTile(i, j);
                Wall[] walls = tileGenerator.getWalls(i, j);
                if (tile.getFilled() == 0 && tile.getCurrent() == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(tile.getxLoc() + WALLBUFFER, tile.getyLoc() + WALLBUFFER, TILESIZE - WALLBUFFER, TILESIZE - WALLBUFFER);
                    // Implement the walls here
                } else if (tile.getFilled() == 0 && tile.getCurrent() == 1) {
                    g.setColor(Color.RED);
                    g.fillRect(tile.getxLoc() + WALLBUFFER, tile.getyLoc() + WALLBUFFER, TILESIZE - WALLBUFFER, TILESIZE - WALLBUFFER);
                    // Implement the walls here
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(tile.getxLoc() + WALLBUFFER, tile.getyLoc() + WALLBUFFER, TILESIZE - WALLBUFFER, TILESIZE - WALLBUFFER);
                }

                // Fill the walls if they need to be
                if (walls[0].getFilled() == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(walls[0].getxLoc(), walls[0].getyLoc(), walls[0].getWidth(), WALLBUFFER);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(walls[0].getxLoc(), walls[0].getyLoc(), walls[0].getWidth(), WALLBUFFER);
                }

                if (walls[1].getFilled() == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(walls[1].getxLoc(), walls[1].getyLoc(), walls[1].getWidth(), WALLBUFFER);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(walls[1].getxLoc(), walls[1].getyLoc(), walls[1].getWidth(), WALLBUFFER);
                }

                if (walls[2].getFilled() == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(walls[2].getxLoc(), walls[2].getyLoc(), walls[2].getWidth(), TILESIZE - WALLBUFFER);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(walls[2].getxLoc(), walls[2].getyLoc(), walls[2].getWidth(), TILESIZE - WALLBUFFER);
                }

                if (walls[3].getFilled() == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(walls[3].getxLoc(), walls[3].getyLoc(), walls[3].getWidth(), TILESIZE - WALLBUFFER);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(walls[3].getxLoc(), walls[3].getyLoc(), walls[3].getWidth(), TILESIZE - WALLBUFFER);
                }
            }
        }

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
