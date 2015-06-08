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
import java.util.List;

/**
 * Grid.java
 * This class will (1) record the path of LightCycles
 * (2) detect collision between LightCycles and the paths.
 * June 1, 2015 - version 1
 */
public class Grid {
    //an arraylist of path
    private GridCell[][] cells;
    private List<GridCell> paths = new ArrayList<>();

    public static final double DEFAULT_WIDTH = 590;
    public static final double DEFAULT_HEIGHT = 460;

    /**
     * The constructor for Grid. Takes no parameters and sets up nothing.
     * */
    public Grid() {
        cells = new GridCell[(int)DEFAULT_WIDTH+1][(int)DEFAULT_HEIGHT+1];
        for (int i=0; i<=(int)DEFAULT_WIDTH; i+=5) {
            for (int j=0; j<=(int)DEFAULT_HEIGHT; j+=5) {
                cells[i][j] = new GridCell(i,j, GameManager.STEP_SIZE,
                                           GameManager.STEP_SIZE);
            }
        }
        // set the neighbors of all cells
        for (int i=0; i<=(int)DEFAULT_WIDTH; i+=5) {
            for (int j=0; j<=(int)DEFAULT_HEIGHT; j+=5) {
                if (i <= DEFAULT_WIDTH-5) {
                    cells[i][j].setNeighbors(cells[i+5][j]);
                }
                if (i >= 5) {
                    cells[i][j].setNeighbors(cells[i-5][j]);
                }
                if (j <= DEFAULT_HEIGHT-5) {
                    cells[i][j].setNeighbors(cells[i][j+5]);
                }
                if (j >= 5) {
                    cells[i][j].setNeighbors(cells[i][j-5]);
                }
            }
        }
    }

    public GridCell[][] getCells() {
        return this.cells;
    }

    /**
     * addToGrid(Rectangle) adds a rectangle to into the arrayList, which
     * enables us to update the path the LightCycles leave behind them.
     *
     * @params path
     */
    public void addToPaths(GridCell cell) {
        if (!cell.isWall()) {
            cell.setWall(true);
            paths.add(cell);
        }
    }

    /**
     * getGridList() returns the arraylist of path so we can draw.
     * This method is used for testing.
     *
     * @return ArrayList<Rectangle>
     */
    public List<GridCell> getPaths() {
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
                for (GridCell path : paths) {
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

    public int[] getFreeSides(LightCycle bike){
        int[] sides = {0,0,0,0};

        for (Rectangle path : paths) {

            //moving in X direction so change sides by turning
            if (bike.getVelocityY() == 0) {

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

    //********** FOR TESTING ONLY **************//
    public void printPaths() {
        for (Rectangle path : paths) {
            System.out.print("("+path.getLayoutX()+", "+path.getLayoutY()+") ");
        }
    }
}



