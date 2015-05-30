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

    public LightCycle(Color color) {
        super(25.0, 25.0);
        this.color = color;
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
        this.setLayoutX(this.getLayoutX() + this.velocityX);
        this.setLayoutY(this.getLayoutY() + this.velocityY);
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
