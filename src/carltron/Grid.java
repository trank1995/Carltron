package carltron;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * Created by shangd on 5/27/15.
 */
public class Grid {
    private int width;
    private int height;
    private ArrayList<Rectangle> path = new ArrayList<Rectangle>();

    public static final int DEFAULT_GRID_SIZE = 500;

    public Grid(){
        this.width = DEFAULT_GRID_SIZE;
        this.height = DEFAULT_GRID_SIZE;

    }

    public void addToGrid(Rectangle new_path) {
        path.add(new_path);
    }

    public boolean collisionWithPath(LightCycle bike) {
        double bikeX = bike.getLayoutX();
        double bikeY = bike.getLayoutY();
        // loop over rectangles in path and check whether layout is the same
        // as the bike's layout.
        if (bike.hasShield() == false) {
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



