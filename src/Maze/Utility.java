package Maze;

import Components.TileGenerator;

import java.util.Random;

/**
 * Created by Jon on 12/16/13.
 */
public class Utility {

    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static int getHorizNext(int current, int min, int max) {

        int newRand = randInt(min, max);

        while (newRand + current > TileGenerator.getHorizAmount(Maze.MAPWIDTH, Maze.TILESIZE) || newRand + current < 0) {
            newRand = randInt(min, max);
        }

        return newRand;

    }

    public static int getVertNext(int current, int min, int max) {

        int newRand = randInt(min, max);

        while ((newRand + current) > TileGenerator.getVertAmount(Maze.MAPHEIGHT, Maze.TILESIZE) || (newRand + current) < 0) {
            newRand = randInt(min, max);
        }

        return newRand;

    }

}
