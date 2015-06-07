/**
 ************************ CARLTRON GAME****************************************
 * Made by  Derek Shang (shangd7)
 *          Frederik Ronn Stensaeth (stensaethf)
 *          Sabastian Mugazambi (mugazambis)
 *          Kiet Tran (trank)
 *          *******************************************************************
 *
 * Date : June 5 2015
 * @Purpose Software Design Course Final Project
 **/


package carltron;

//Importing all important libraries
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

    public static final double DEFAULT_WIDTH = 590;
    public static final double DEFAULT_HEIGHT = 460;

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
                    if (((bike.getLayoutX()) == (path.getLayoutX())) &&
                            ((bike.getLayoutY()) == (path.getLayoutY())
                            )) {
                        return true;
                    }
                    }
                }
            }
            // return false if no collision
            return false;
        }


    public int[] getFreeSides(LightCycle bike){
        int[] sides = {0,0,0,0};

        for (Rectangle path : paths) {

            //moving in X direction so change sides by turning
            if (bike.getVelocityY() == 0) {

                //System.out.println("got here");
                //check up and down for free
                if (((bike.getLayoutX()) == (path.getLayoutX())) &&
                        ((bike.getLayoutY()) == (path.getLayoutY() + 20)
                        )) {
                    sides[2] = 3;

                }

                //detect stuff to the bottom
                if (((bike.getLayoutX()) == (path.getLayoutX())) &&
                        ((bike.getLayoutY() - 20) == (path.getLayoutY())
                        )) {
                    sides[3] = 4;

                }
            } else {

                //detect stuff at the left
                if (((bike.getLayoutX()) == (path.getLayoutX() + 20)) &&
                        ((bike.getLayoutY()) == (path.getLayoutY())
                        )) {
                    sides[0] = 1;

                }

                //detect stuff to the right
                if (((bike.getLayoutX() - 20) == (path.getLayoutX())) &&
                        ((bike.getLayoutY()) == (path.getLayoutY())
                        )) {
                    sides[1] = 2;

                    }
                }
            }
        return sides;

    }

    public void printPaths() {
        for (Rectangle path : paths) {
            System.out.print("("+path.getLayoutX()+", "+path.getLayoutY()+") ");
        }
    }
}



