package Components;

/**
 * Created with IntelliJ IDEA.
 * User: Jon
 * Date: 12/7/13
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Wall {

    private int xCoord;
    private int yCoord;
    private int xLoc;
    private int yLoc;
    private int width;
    private int isFilled;
    private int position;

    public Wall(int xCoord, int yCoord, int xLoc, int yLoc, int isFilled, int width, int position) {
        setxCoord(xCoord);
        setyCoord(yCoord);
        setxLoc(xLoc);
        setyLoc(yLoc);
        setFilled(isFilled);
        setWidth(width);
        setPosition(position);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getFilled() {
        return isFilled;
    }

    public void setFilled(int filled) {
        isFilled = filled;
    }



}
