package carltron;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by shangd on 5/27/15.
 */
public class LightCycle extends Rectangle {
    private int velocityX;
    private int velocityY;
    private Color color;
    private boolean leavesPath;
    private boolean shield;

    public static final int DEFAULT_VELOCITY = 1;
    public static final double DEFAULT_STEP_SIZE = 5;

    public LightCycle() {
        //this.color = color;
        this.leavesPath = true;
        this.shield = false;
    }

    //public Color getColor() {
    //    return this.color;
    //}

    //public boolean hasPath() {
    //    return this.leavesPath;
    //}

    //public void setLeavesPath(boolean flag) {
    //    this.leavesPath = flag;
    //}

    //public boolean hasShield() {
    //    return this.shield;
    //}

    //public void setShield(boolean flag) {
    //    this.shield = flag;
    //}

    public int getVelocityX() {
        return this.velocityX;
    }

    public void setVelocityX(int v) {
        this.velocityX = v;
        //this.velocityY = 0;
    }

    public int getVelocityY() {
        return this.velocityY;
    }

    public void setVelocityY(int v) {
        this.velocityY = v;
        //this.velocityX = 0;
    }

    public void step() {
        this.setLayoutX(this.getLayoutX() + this.velocityX * DEFAULT_STEP_SIZE);
        this.setLayoutY(this.getLayoutY() + this.velocityY * DEFAULT_STEP_SIZE);
    }

    public void turnDefault() {
        if (getVelocityX() < 0) {
            setVelocityX(-DEFAULT_VELOCITY);
        } else if (getVelocityX() > 0) {
            setVelocityX(DEFAULT_VELOCITY);
        } else if (getVelocityY() < 0) {
            setVelocityY(-DEFAULT_VELOCITY);
        } else if (getVelocityY() > 0) {
            setVelocityY(DEFAULT_VELOCITY);
        }

        this.leavesPath = true;
        this.shield = false;
    }
}
