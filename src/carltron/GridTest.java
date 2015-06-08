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

//Neccessary imports
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for Grid.
 */
public class GridTest {

    @Test
    public void testAddToGridWithNoneShouldStillHaveEmptyList() throws
            Exception {
        Grid grid = new Grid();
        grid.addToPaths(null);
        List<GridCell> grid_list = grid.getPaths();
        assertEquals(0, grid_list.size());
    }

    @Test
    public void testAddToGridWithRectangleShouldHaveListWithRectangle() throws
            Exception {
        Grid grid = new Grid();
        grid.addToPaths(grid.getCells()[100][100]);

        List<GridCell> grid_list = grid.getPaths();
        assertEquals(1, grid_list.size());
        assertEquals(100.0, grid_list.get(0).getLayoutX(), 0.1);
        assertEquals(100.0, grid_list.get(0).getLayoutY(), 0.1);
    }

    @Test
    public void testCollisionWithPathWithNoneShouldReturnFalse() throws
            Exception {
        Grid grid = new Grid();
        assertEquals(false, grid.collisionWithPath(null));
    }

    @Test
    public void testCollisionWithPathWithRectangleShouldReturnFalse() throws
            Exception {
        Grid grid = new Grid();

        LightCycle bike = new LightCycle();
        bike.setLayoutX(10);
        bike.setLayoutY(10);

        assertEquals(false, grid.collisionWithPath(bike));
    }

    @Test
    public void
    testCollisionWithPathWithRectangleOnNoneEmptyListShouldReturnFalse() throws
            Exception {
        Grid grid = new Grid();

        grid.addToPaths(grid.getCells()[100][100]);

        LightCycle bike = new LightCycle();
        bike.setLayoutX(10);
        bike.setLayoutY(10);

        assertEquals(false, grid.collisionWithPath(bike));
    }

    @Test
    public void testCollisionWithPathWithRectangleWithItemShouldReturnTrue()
            throws
            Exception {
        Grid grid = new Grid();

        grid.addToPaths(grid.getCells()[100][100]);

        LightCycle bike = new LightCycle();
        bike.setLayoutX(100);
        bike.setLayoutY(100);

        assertEquals(true, grid.collisionWithPath(bike));
    }
}