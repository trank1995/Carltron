package carltron;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

/**
 * Created by shangd on 5/27/15.
 */
public class Grid {
    //private int width;
    //private int height;
    private ArrayList<Rectangle> paths = new ArrayList<Rectangle>();

    public Grid() {
        // nothing
    }

    public void addToGrid(Rectangle path) {
        if (path != null) {
            paths.add(path);
        }
    }

    public ArrayList<Rectangle> getGridList() {
        return this.paths;
    }

    public boolean collisionWithPath(LightCycle bike) {
        // loop over rectangles in path and check whether layout is the same
        // as the bike's layout.
        if (bike != null) {
            if (!bike.hasShield()) {
                for (Rectangle path : paths) {
                    if ((bike.getLayoutX() == path.getLayoutX()) &&
                            (bike.getLayoutY() == path.getLayoutY())) {
                        return true;
                    }
                }
            }
            // no collision? return false.
            return false;
        }
        return false;
    }
}



