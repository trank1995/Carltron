package carltron;

/**
 * Created by shangd on 6/5/15.
 */
public class AiPlayer extends Player {
    private Player human;
    private Grid grid;
    private String direction;

    public AiPlayer(LightCycle vehicle, Player human, Grid grid) {
        super(vehicle);
        this.human = human;
        this.grid = grid;
        this.direction = "LEFT";
    }

    @Override
    public void strategy() {
        if (getDistance() <= 80) {
            this.vehicle.setVelocityX(0);
            this.vehicle.setVelocityY(-1);
        }
        //System.out.println(grid.hasWayToPoint(vehicle.getLayoutX(), vehicle
        //                    .getLayoutY(),530.0,220.0));
    }

    private void detectOpenArea() {

    }

    private double getDistance() {
        return Math.sqrt(Math.pow(this.vehicle.getLayoutX() -
                                  human.vehicle.getLayoutX(), 2) +
                         Math.pow(this.vehicle.getLayoutY() -
                                  human.vehicle.getLayoutY(), 2));
    }

}