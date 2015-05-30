package carltron;

import java.util.*;
import javafx.scene.shape.Rectangle;

/**
 * Created by shangd on 5/27/15.
 */
public class Grid {
    private int width;
    private int height;
    private ArrayList<Rectangle> path = new ArrayList<>();

    public static final int DEFAULT_GRID_SIZE = 500;

    public Grid(){
        this.width = DEFAULT_GRID_SIZE;
        this.height = DEFAULT_GRID_SIZE;

    }

    public void addToGrid(Rectangle new_path) {
        path.add(new_path);
    }

    public boolean collisionWithPath(Rectangle bike) {
        double bikeX = bike.getLayoutX();
        double bikeY = bike.getLayoutY();
        // loop over rectangles in path and check whether layout is the same
        // as the bike's layout.
        for (Rectangle object : path) {
            double objectX = object.getLayoutX();
            double objectY = object.getLayoutY();

            if ((bikeX == objectX) && (bikeY == objectY)) {
                return true;
            }
        }
        // no collision? return false.
        return false;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    private void setWidth(int givenWidth){
        this.width = givenWidth;
    }

    private void setHeight(int givenHeight){
        this.height = givenHeight;
    }

}



