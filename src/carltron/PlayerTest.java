package carltron;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shangd on 6/1/15.
 */
public class PlayerTest {

    @Test
    public void testGetVehicleShouldNotBeNone() throws Exception {
        Player testPlayer = new Player(new LightCycle());

        LightCycle testVehicle = testPlayer.getVehicle();
        assertNotEquals("vehicle is null", testVehicle, null);
    }

    @Test
    public void testDecrementLifeOnlyDecrements() throws Exception {
        Player testPlayer = new Player(new LightCycle());

        assertEquals(testPlayer.getLife(), 3);
        int beforeLife = testPlayer.getLife();
        testPlayer.decrementLife();
        int afterLife = testPlayer.getLife();
        assertEquals("Life is not decremented", afterLife, beforeLife - 1);
    }

    @Test
    public void testDecrementLifeDoesNothingToZeroLife() throws Exception {
        Player testPlayer = new Player(new LightCycle());

        assertEquals(testPlayer.getLife(), 3);
        for (int i=0;i<5;i++) {
            testPlayer.decrementLife();
            int currentLife = testPlayer.getLife();
            assertTrue("Negative life amount", currentLife >= 0);
        }
    }
}