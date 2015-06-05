package carltron;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

/**
 * Grid.java
 * This class will (1) record the path of LightCycles
 * (2) detect collision between LightCycles and the paths.
 * June 1, 2015 - version 1
 */
public class Grid {
    //an arraylist of path
    private ArrayList<Rectangle> paths = new ArrayList<>();

    /**
     * The constructor for Grid. Takes no parameters and sets up nothing.
     * */
    public Grid() {
    }

    /**
     * addToGrid(Rectangle) adds a rectangle to into the arrayList, which
     * enables us to update the path the LightCycles leave behind them.
     *
     * @params path
     */
    public void addToGrid(Rectangle path) {
        if (path != null) {
            paths.add(path);
        }
    }

    /**
     * getGridList() returns the arraylist of path so we can draw.
     * This method is used for testing.
     *
     * @return ArrayList<Rectangle>
     */
    public ArrayList<Rectangle> getGridList() {
        return this.paths;
    }

    /**
     * collisionWithPath(LightCycle) detects collision of bike and path
     *
     * @param bike
     * @return true or false
     */
    public boolean collisionWithPath(LightCycle bike) {
        if (bike != null) {
            //if bike doesn't have protector
            if (!bike.hasShield()) {
                // loop over rectangles in path and check whether
                // layout is the same as the bike's layout.
                for (Rectangle path : paths) {
                    if ((bike.getLayoutX() == path.getLayoutX()) &&
                            (bike.getLayoutY() == path.getLayoutY())) {
                        return true;
                    }
                }
            }
            // return false if no collision
            return false;
        }
        return false;
    }

    public boolean detectpathcollision(LightCycle bike){

        if (bike != null) {
            //if bike doesn't have protector
            if (!bike.hasShield()) {
                // loop over rectangles in path and check whether
                // layout is the same as the bike's layout.
                for (Rectangle path : paths) {
                    if (((bike.getLayoutX() + 50) == path.getLayoutX()) &&
                            ((bike.getLayoutY() + 50) == path.getLayoutY())) {
                        return true;
                    }
                }
            }
            // return false if no collision
            return false;
        }
        return false;
    }
}



