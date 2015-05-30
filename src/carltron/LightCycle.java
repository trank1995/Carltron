package carltron;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 * Created by shangd on 5/27/15.
 */
public class LightCycle extends Rectangle {
    private int velocityX;
    private int velocityY;
    private Color color;

    public static final int DEFAULT_VELOCITY = 5;
    private final double STEP_SIZE = 10.0;

    public LightCycle() {
        //this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public int getVelocityX() {
        return this.velocityX;
    }

    public void setVelocityX(int v) {
        this.velocityX = v;
        this.velocityY = 0;
    }

    public int getVelocityY() {
        return this.velocityY;
    }

    public void setVelocityY(int v) {
        this.velocityY = v;
        this.velocityX = 0;
    }

    public void step() {
        this.setLayoutX(this.getLayoutX() + this.velocityX * STEP_SIZE);
        this.setLayoutY(this.getLayoutY() + this.velocityY * STEP_SIZE);
    }

    public void turnDefault() {
        if (getVelocityX() != 0) {
            setVelocityX(DEFAULT_VELOCITY);
        } else if (getVelocityY() != 0) {
            setVelocityY(DEFAULT_VELOCITY);
        }
        // also need to adjust other variables such as "invincible",
        // "leavesPath"
    }
}
