package carltron;

import javafx.scene.effect.Light;
import javafx.scene.paint.Color;

import java.util.HashMap;

/**
 * Created by shangd on 5/29/15.
 */
public class Player {
    private LightCycle vehicle;
    private int life;
    private Bonus[] bonuses;
    private HashMap<String, Integer> counter;

    public static final int TURBO_DURATION = 5;
    public static final int JUMP_DURATION = 3;
    public static final int PROTECTOR_DURATION = 3;

    public Player() {
        this.life = 3;
        this.vehicle = new LightCycle();
        this.bonuses = new Bonus[] {
                new Turbo(3, this.vehicle),
                new Jump(3, this.vehicle),
                new Protector(0, this.vehicle)
        };
        this.counter = new HashMap<>();
        this.counter.put("turbo",0);
        this.counter.put("jump",0);
        this.counter.put("protector",0);
    }

    public void setVehicle(LightCycle new_bike) {
        this.vehicle = new_bike;
    }

    public int getLife() {
        return this.life;
    }

    public LightCycle getVehicle() {
        return this.vehicle;
    }

    public void decrementLife() {
        if (this.life > 0) {
            this.life--;
        }
    }

    // GameManager calls this method every frame to handle every change that
    // needs to be made to player.
    public void statusCheck() {
        bonusEffectCheck();
    }

    //******************* hasn't resolved the case where more than 1 bonuses
    // are used at the same time**************************
    private void bonusEffectCheck() {
        for (String key : this.counter.keySet()) {
            if (this.counter.get(key) != 0) {
                this.counter.put(key, this.counter.get(key)+1);
                switch (key) {
                    case "turbo":
                        if (this.counter.get(key) == TURBO_DURATION) {
                            this.vehicle.turnDefault();
                            this.counter.put(key, 0);
                        }
                        break;
                    case "jump":
                        if (this.counter.get(key) == JUMP_DURATION) {
                            this.vehicle.turnDefault();
                            this.counter.put(key, 0);
                        }
                        break;
                    case "protector":
                        if (this.counter.get(key) == PROTECTOR_DURATION) {
                            this.vehicle.turnDefault();
                            this.counter.put(key, 0);
                        }
                        break;
                    default: break;
                }
            }
        }
    }

    public void consume(String type) {
        switch (type) {
            case "turbo":
                this.bonuses[0].consume();
                this.counter.put("turbo", 1);
                break;
            case "jump":
                this.bonuses[1].consume();
                this.counter.put("jump", 1);
                break;
            case "protector":
                this.bonuses[2].consume();
                this.counter.put("protector", 1);
                break;
            default: break;
        }
    }
}
