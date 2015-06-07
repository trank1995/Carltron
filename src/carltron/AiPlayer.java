package carltron;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by shangd on 6/5/15.
 */
public class AiPlayer extends Player {
    private Player human;
    private Grid grid;
    private String direction;
    private Queue<Rectangle> queue;

    public AiPlayer(LightCycle vehicle, Player human, Grid grid) {
        super(vehicle);
        this.human = human;
        this.grid = grid;
        this.direction = "LEFT";
        this.queue = new ArrayBlockingQueue<>((int)(Math.ceil(grid
                .DEFAULT_HEIGHT)*Math.ceil(grid.DEFAULT_WIDTH)));
    }

    @Override
    public void strategy() {
        if (this.vehicle.getLayoutX() <= human.vehicle.getLayoutX()+80) {
            this.vehicle.setVelocityX(0);
            this.vehicle.setVelocityY(-1);
        }
    }

    private void detectOpenArea() {

    }

    private double getDistance() {
        return Math.sqrt(Math.pow(this.vehicle.getLayoutX() -
                                  human.vehicle.getLayoutX(), 2) +
                         Math.pow(this.vehicle.getLayoutY() -
                                  human.vehicle.getLayoutY(), 2));
    }

    private boolean hasWayToPoint(double currentX, double currentY,
                                  double endX, double endY) {
        boolean find = false;
        List<Rectangle> seen = new ArrayList<>();
        Rectangle start = new Rectangle(currentX, currentY);
        queue.add(start);
        seen.add(start);

        while (!find) {
            Rectangle[] short_one = new Rectangle[4];
            Rectangle current = queue.poll();
            if (!seen.contains(current)) {
                seen.add(current);
            }

            if (current.getLayoutX() <= grid.DEFAULT_WIDTH-5) {
                Rectangle neighbor1 = new Rectangle(current.getLayoutX()+5,
                        current.getLayoutY());
                short_one[0] = neighbor1;
            }
            if (current.getLayoutX() >= 5) {
                Rectangle neighbor2 = new Rectangle(current.getLayoutX()-5,
                          currentY);
                short_one[1] = neighbor2;
            }
            if (current.getLayoutY() <= grid.DEFAULT_HEIGHT-5) {
                Rectangle neighbor3 = new Rectangle(current.getLayoutX(),
                          current.getLayoutY()+5);
                short_one[2] = neighbor3;
            }
            if (current.getLayoutY() >= 5) {
                Rectangle neighbor4 = new Rectangle(current.getLayoutX(),
                          current.getLayoutY()-5);
                short_one[3] = neighbor4;
            }

            for (int i=0;i<short_one.length;i++) {
                boolean bool_seen = false;
                if (short_one[i] != null) {
                    for (Rectangle item : seen) {
                        if (item.getLayoutX() == short_one[i].getLayoutX() &&
                            item.getLayoutY() == short_one[i].getLayoutY()) {
                            bool_seen = true;
                        }
                    }
                    if (!bool_seen) {
                        if (short_one[i].getLayoutX() == endX &&
                            short_one[i].getLayoutY() == endY) {
                            find = true;
                        }
                        queue.add(short_one[i]);
                    }
                }
            }

            if (queue.size() == 0 && find == false) {
                return false;
            }
        }

        return find;
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