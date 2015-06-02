package carltron;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shangd on 6/1/15.
 */
public class LightCycleTest {

    @Test
    public void testHasPathDefaultIsTrue() throws Exception {
        LightCycle testBike = new LightCycle();

        assertTrue("default leavesPath is not true", testBike.hasPath());
    }

    @Test
    public void testHasShieldDefaultIsFalse() throws Exception {
        LightCycle testBike = new LightCycle();

        assertFalse("default shield is not false", testBike.hasShield());
    }

    @Test
    public void testTurnDefaultShouldSetCorrectVelocity() throws Exception {
        LightCycle testBike = new LightCycle();

        testBike.turnDefault();
        assertTrue("velocityX is not turned to default",
                testBike.getVelocityX() == 0 ||
                        testBike.getVelocityX() == 1 ||
                        testBike.getVelocityX() == -1);
        assertTrue("velocityY is not turned to default",
                testBike.getVelocityX() == 0 ||
                        testBike.getVelocityX() == 1 ||
                        testBike.getVelocityX() == -1);

    }

    @Test
    public void testTurnDefaultShouldSetCorrectLeavesPath() throws Exception {
        LightCycle testBike = new LightCycle();

        assertTrue("default leavesPath is not true", testBike.hasPath());
    }

    @Test
    public void testTurnDefaultShouldSetCorrectShield() throws Exception {
        LightCycle testBike = new LightCycle();

        assertFalse("default shield is not false", testBike.hasShield());
    }
}