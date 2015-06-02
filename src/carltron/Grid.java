package carltron;
/**
 * Grid.java
 * This class will (1) record the path of lightcycle
 * (2) detect collision
 * June 1, 2015 - version 1
 */
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;


public class Grid {
    //an arraylist of path
    private ArrayList<Rectangle> paths = new ArrayList<Rectangle>();

    public Grid() {
    }

    /**
     * Add the new path into the arraylsit
     * @param path
     */
    public void addToGrid(Rectangle path) {
        if (path != null) {
            paths.add(path);
        }
    }

    /**
     * return the arraylist of path so we can draw
     * @return ArrayList<Rectangle>
     */
    public ArrayList<Rectangle> getGridList() {
        return this.paths;
    }

    /**
     * detect collision of bike and path
     * @param bike
     * @return true if collide
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
}



