package Components;

/**
 * Created with IntelliJ IDEA.
 * User: Jon
 * Date: 12/7/13
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tile {

    private int xCoord;
    private int yCoord;
    private int xLoc;
    private int yLoc;
    private int isFilled;

    public Tile (int xCoord, int yCoord, int xLoc, int yLoc, int isFilled) {
        setxCoord(xCoord);
        setyCoord(yCoord);
        setxLoc(xLoc);
        setyLoc(yLoc);
        setFilled(isFilled);
    }

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
