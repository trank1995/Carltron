package carltron;

/**
 * Created by shangd on 5/27/15.
 */
public class Grid {
    private int width;
    private int height;

    public Grid(){
        this.width = 500;
        this.height = 500;

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



