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
    private Bonus[] bonuses;
    private int life;

    public static final int DEFAULT_VELOCITY = 5;

    public LightCycle(int life, Color color) {
        super(25.0, 25.0);
        this.life = life;
        this.color = color;
        this.bonuses = new Bonus[3];
        this.bonuses[0] = new Turbo(3);
        this.bonuses[1] = new Jump(3);
        this.bonuses[2] = new Protector(0);
    }

    public int getVelocityX() {
        return this.velocityX;
    }

    public void setVelocityX(int v) {
        this.velocityX = v;
    }

    public int getVelocityY() {
        return this.velocityY;
    }

    public void setVelocityY(int v) {
        this.velocityY = v;
    }

    public void decrementLife() {
        if (this.life > 0) { this.life--; }
    }

    public void step() {
        this.setLayoutX(this.getLayoutX() + this.velocityX);
        this.setLayoutY(this.getLayoutY() + this.velocityY);

        //setX(getX() + getVelocityX());
        //setY(getY() + getVelocityY());
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

    public void consume(String type) {
        switch (type) {
            case "turbo":
                this.bonuses[0].consume();
                break;
            case "jump":
                this.bonuses[1].consume();
                break;
            case "protector":
                this.bonuses[2].consume();
                break;
            default: break;
        }
    }
}
