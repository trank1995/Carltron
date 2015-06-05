package carltron;

import java.util.HashMap;

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
        if (this.vehicle.getLayoutX() <= human.vehicle.getLayoutX()+80) {
            this.vehicle.setVelocityX(0);
            this.vehicle.setVelocityY(-1);
            //System.out.println(this.vehicle.getVelocityY());
            //System.out.println("set v");
        }
        if (this.vehicle.getVelocityY() == -1) {
            this.vehicle.setVelocityX(-1);
            this.vehicle.setVelocityY(0);
        }
    }
}


   // The following lines were previously in GameManager
   /* public void AIplayer(double player1x,double player1y, double player2x,
                         double player2y) {
        // player 2
        /* speed is the magnitude of player's velocity. Since velocityX is
        either 0 or positive/minus speed, we use the ternary operator to
        obtain the speed. *

        int speed2 = (this.player2.getVelocityX() == 0) ?
                Math.abs(this.player2.getVelocityY()) :
                Math.abs(this.player2.getVelocityX());

        boolean path_check_p2 = this.grid.detectpathcollision(this.player2);
        //System.out.println(path_check_p2);

        //if about to collide with path
        if (path_check_p2 == true){
            turndown(speed2);
        }


        //if headon collision
        if (Math.abs(player1x - player2x) <= 50) {
            int random = 3;
            if (random ==3) {
                turnup(speed2);
            }
        }

        // player2 went of the grid (top)
        if ((player2y) < 50) {
            turnleft(speed2);
        }

        // player2 went of the grid (left)
        if ((player2x) < 20) {
            turndown(speed2);
        }

        // player2 went of the grid (right)
        if ((player2x+50) + this.player2.getWidth() > this.grid_fxml
                .getWidth()){
            turnup(speed2);
        }

        //player2 went to the botom of grid.
        System.out.println(player2y);
        double use = player2y +20;

        if (use > this.grid_fxml.getHeight()) {
            turnright(speed2);

        }

    }

    public void turnup(int speed2){
        if (this.player2.getVelocityY() <= 0) {
            // velocityX to 0 and Y to 1.
            this.player2.setVelocityY(-speed2);
            this.player2.setVelocityX(0);
        }
    }

    public void turndown(int speed2) {

        if (this.player2.getVelocityY() >= 0) {
            // velocityX to 0 and Y to -1.
            this.player2.setVelocityY(speed2);
            this.player2.setVelocityX(0);
        }
    }

    public void turnleft(int speed2) {
        if (this.player2.getVelocityX() <= 0) {
            // velocityX to -1 and Y to 0.
            this.player2.setVelocityY(0);
            this.player2.setVelocityX(-speed2);
        }
    }

    public void turnright(int speed2) {

        if (this.player2.getVelocityX() >= 0) {
            // velocityX to 1 and Y to 0.
            this.player2.setVelocityY(0);
            this.player2.setVelocityX(speed2);
        }
    }  */