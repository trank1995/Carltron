package carltron;

import java.util.*;
import javafx.scene.shape.Rectangle;

/**
 * Created by shangd on 5/27/15.
 */
public class Grid {
    private int width;
    private int height;
    private ArrayList<Rectangle> path = new ArrayList<Rectangle>();

    public Grid(){
        this.width = 500;
        this.height = 500;

    }

    public void addToGrid(Rectangle new_path) {
        path.add(new_path);
    }

    public boolean collisionWithPath(Rectangle bike) {
        x;
    }

    private int getWidth(){
        return width;
    }

    private int getHeight(){
        return height;
    }

    private void setWidth(int givenWidth){
        this.width = givenWidth;
    }

    private void setHeight(int givenHeight){
        this.height = givenHeight;
    }

}



