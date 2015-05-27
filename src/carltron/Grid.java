package carltron;

/**
 * Created by shangd on 5/27/15.
 */
public class Grid {
    private int WIDTH;
    private int HEIGHT;

    public Grid(){
        WIDTH = 500;
        HEIGHT = 500;

    }

    private int getWidth(){
    return WIDTH;
    }

    private int getHeight(){
    return HEIGHT;
    }

    private void setWidth(int givenWidth){
    WIDTH = givenWidth;
    }

    private void setHeight(int givenHeight){
    HEIGHT = givenHeight;
    }

}



