package Components;

/**
 * Created with IntelliJ IDEA.
 * User: Jon
 * Date: 12/7/13
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tile {

    // Tile Constants
    public static final int XCOORD = 0;
    public static final int YCOORD = 1;
    public static final int XLOC = 2;
    public static final int YLOC = 3;
    public static final int ISFILLED = 4;
    public static final int ISVISITED = 5;
    public static final int ISCURRENT = 6;


    private int xCoord;
    private int yCoord;
    private int xLoc;
    private int yLoc;
    private int wallBuffer;
    private int isFilled;
    private int isVisited;
    private int isCurrent;

    public Tile (int xCoord, int yCoord, int xLoc, int yLoc, int isFilled, int isVisited, int isCurrent) {
        setxCoord(xCoord);
        setyCoord(yCoord);
        setxLoc(xLoc);
        setyLoc(yLoc);
        setFilled(isFilled);
        setVisited(isVisited);
        setCurrent(isCurrent);
    }

    public int getCurrent() { return isCurrent; }

    public void setCurrent(int Current) { this.isCurrent = Current; }

    public int getVisited() { return isVisited; }

    public void setVisited(int Visited) { this.isVisited = Visited; }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public int getFilled() {
        return isFilled;
    }

    public void setFilled(int filled) {
        isFilled = filled;
    }
}
