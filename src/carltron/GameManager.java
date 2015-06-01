package carltron;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

// NOTE!
// need to make off the path crash into a method.
// call the method on both players.
// do checks for #t / #f.
// as now if they both go off the grid at the same time it is not a draw (tie).


public class GameManager implements EventHandler<KeyEvent>{
    final private double FRAMES_PER_SECOND = 15.0;
    final private double STEP_SIZE = 5.0;
    private Grid grid_object = new Grid();
    public Stage primaryStage;
    public int win;

    @FXML private Button pauseButton;
    @FXML private LightCycle player1;
    @FXML private LightCycle player2;
    @FXML private AnchorPane grid_fxml;
    @FXML private Label player1TurboLabel;
    @FXML private Label player2TurboLabel;
    @FXML private Label player1JumpLabel;
    @FXML private Label player2JumpLabel;
    @FXML private Label player1LifeLabel;
    @FXML private Label player2LifeLabel;


    private boolean paused;
    private Timer timer;

    public GameManager() {
        this.paused = false;
        this.primaryStage = null;
        this.win =0;
    }

    public void initialize() throws Exception{
        this.setUpAnimationTimer();
    }

    public void setUpAnimationTimer(){
        TimerTask timerTask = new TimerTask() {
            public void run(){
                Platform.runLater(new Runnable() {
                    public void run(){
                        try {
                            if (updateAnimation() == true){
                                updateAnimation();
                            }else{
                                callVictoryPage();
                                updateAnimation();
                            }
                        }catch (Exception e){
                            System.out.println("big error");
                        }
                    }
                });
            }
        };

        final long startTimeInMilliseconds = 0;
        final long repetitionPeriodInMilliseconds = 100;
        long frameTimeInMilliseconds = (long)(1000.0 / FRAMES_PER_SECOND);
        this.timer = new java.util.Timer();
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }

    public boolean updateAnimation() throws Exception{
        // find position of player1
        double player1X = this.player1.getLayoutX();
        double player1Y = this.player1.getLayoutY();

        // find position of player2
        double player2X = this.player2.getLayoutX();
        double player2Y = this.player2.getLayoutY();


        // find new position of player1
        double player1X_new = player1X + (STEP_SIZE * this.player1
                .getVelocityX());
        double player1Y_new = player1Y + (STEP_SIZE * this.player1
                .getVelocityY());

        // find new position of player2
        double player2X_new = player2X + (STEP_SIZE * this.player2
                .getVelocityX());
        double player2Y_new = player2Y + (STEP_SIZE * this.player2
                .getVelocityY());


        // do checks:



        ////////////// putting this before checking for wall collision

        // check if bike collided with a path.
        boolean path_check_p1 = grid_object.collisionWithPath(this.player1);
        boolean path_check_p2 = grid_object.collisionWithPath(this.player2);

        // player1 and player2 crashed at the same time --> draw (tie).
        if ((path_check_p1 == true) && (path_check_p2 == true)) {
            // crash
            this.win = 0;
            this.timer.cancel();
            return false;

            // player1 crashed --> player2 wins.
        } else if (path_check_p1 == true) {
            // crash
            this.win = 2;
            this.timer.cancel();
            return false;

            // player2 crashed --> player1 wins.
        } else if (path_check_p2 == true) {
            // crash
            this.timer.cancel();
            this.win = 1;
            return false;

        }

        ///////////////////////
        // player1 went of the grid (bottom)
        if (player1Y_new + this.player1.getHeight() > this.grid_fxml.getHeight
                ()) {
            // crash
            this.win = 2;
            this.timer.cancel();
            return false;
        }
        // player1 went of the grid (top)
        if (player1Y_new < 0) {
            // crash
            this.win = 2;
            this.timer.cancel();
            return false;
        }
        // player1 went of the grid (left)
        if (player1X_new < 0) {
            // crash
            this.win = 2;
            this.timer.cancel();
            return false;
        }
        // player1 went of the grid (right)
        if (player1X_new + this.player1.getWidth() > this.grid_fxml.getWidth
                ()) {
            // crash
            this.win = 2;
            this.timer.cancel();
            return false;
        }
        // player2 went of the grid (bottom)
        if (player2Y_new + this.player2.getHeight() > this.grid_fxml.getHeight
                ()) {
            // crash
            this.win = 1;
            this.timer.cancel();
            return false;
        }
        // player2 went of the grid (top)
        if (player2Y_new < 0) {
            // crash
            this.win = 1;
            this.timer.cancel();
            return false;
        }
        // player2 went of the grid (left)
        if (player2X_new < 0) {
            // crash
            this.win = 1;
            this.timer.cancel();
            return false;
        }
        // player2 went of the grid (right)
        if (player2X_new + this.player2.getWidth() > this.grid_fxml.getWidth
                ()) {
            // crash
            this.win = 1;
            this.timer.cancel();
            return false;
        }


        // check if player1 crashed with path

        // check if player2 crashed with path

        // check if player1 and player2 crashed with eachother
        // --> this is a draw (tie).
//        if (this.player1.getBoundsInParent().intersects(this.player2
//                .getBoundsInParent())) {
//            // crash
//        }

        // collision is only when their position overlap.
        // p1--><--p2
        if ((player1X_new == player2X_new) && (player1Y_new == player2Y_new)) {
            this.win = 0;
            this.timer.cancel();
            return false;


            // p1-->p2
        } else if ((player1X_new == player2X) && (player1Y_new ==
                player2Y_new)) {
            this.win = 0;//2;
            this.timer.cancel();
            return false;

            // p1<--p2
        } else if ((player1X == player2X_new) && (player1Y_new ==
                player2Y_new)) {
            this.win = 0;//1;
            this.timer.cancel();
            return false;

            // p1/p2
        } else if ((player1X_new == player2X_new) && (player1Y_new ==
                player2Y)) {
            this.win = 0;//2;
            this.timer.cancel();
            return false;

            // p2/p1
        } else if ((player1X_new == player2X_new) && (player1Y ==
                player2Y_new)) {
            this.win = 0;//1;
            this.timer.cancel();
            return false;

        }

        // add new path rectangle
        Rectangle path_p1 = new Rectangle();
        path_p1.setWidth(STEP_SIZE);
        path_p1.setHeight(STEP_SIZE);
        path_p1.setFill(Color.ORANGE);
        path_p1.setLayoutX(player1X);
        path_p1.setLayoutY(player1Y);
        Rectangle path_p2 = new Rectangle();
        path_p2.setWidth(STEP_SIZE);
        path_p2.setHeight(STEP_SIZE);
        path_p2.setFill(Color.WHITE);
        path_p2.setLayoutX(player2X);
        path_p2.setLayoutY(player2Y);
        this.grid_fxml.getChildren().add(path_p1);
        this.grid_fxml.getChildren().add(path_p2);
        grid_object.addToGrid(path_p1);
        grid_object.addToGrid(path_p2);


        // update the position of player1 and player2, as they passed all the
        // collision tests.
        this.player1.step();
        this.player2.step();

        return true;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        // only gets called when a key is pressed, so here we really only want
        // to update the velocity and direction in which the player is moving.

        KeyCode code = keyEvent.getCode();
        int turbo_dist = 2;

        // player 2
        if (code == KeyCode.LEFT) {
            if (this.player2.getVelocityX() != 1) {
                // velocityX to -1 and Y to 0.
                this.player2.setVelocityY(0);
                this.player2.setVelocityX(-1);
            }
        } else if (code == KeyCode.RIGHT) {
            if (this.player2.getVelocityX() != -1) {
                // velocityX to 1 and Y to 0.
                this.player2.setVelocityY(0);
                this.player2.setVelocityX(1);
            }
        } else if (code == KeyCode.UP) {
            if (this.player2.getVelocityY() != 1) {
                // velocityX to 0 and Y to 1.
                this.player2.setVelocityY(-1);
                this.player2.setVelocityX(0);
            }
        } else if (code == KeyCode.DOWN) {
            if (this.player2.getVelocityY() != -1) {
                // velocityX to 0 and Y to -1.
                this.player2.setVelocityY(1);
                this.player2.setVelocityX(0);
            }
            // turbo 2nd player?
        } else if (code == KeyCode.ENTER) {
            //this.player2.consume("turbo");
            // jump 2nd player?
        } else if (code == KeyCode.SHIFT) {
            //this.player2.consume("jump");

            // player 1
        } else if (code == KeyCode.A) {
            if (this.player1.getVelocityX() != 1) {
                // velocityX to -1 and Y to 0.
                this.player1.setVelocityY(0);
                this.player1.setVelocityX(-1);
            }
        } else if (code == KeyCode.D) {
            if (this.player1.getVelocityX() != -1) {
                // velocityX to 1 and Y to 0.
                this.player1.setVelocityY(0);
                this.player1.setVelocityX(1);
            }
        } else if (code == KeyCode.W) {
            if (this.player1.getVelocityY() != 1) {
                // velocityX to 0 and Y to 1.
                this.player1.setVelocityY(-1);
                this.player1.setVelocityX(0);
            }
        } else if (code == KeyCode.S) {
            if (this.player1.getVelocityY() != -1) {
                // velocityX to 0 and Y to -1.
                this.player1.setVelocityY(1);
                this.player1.setVelocityX(0);
            }
            // turbo 1st player?
        } else if (code == KeyCode.Q) {
            //this.player1.consume("turbo");
            // jump 1st player?
        } else if (code == KeyCode.E) {
            //this.player1.consume("jump");
        }

        // if no critical key is pressed, we do not need to do anything to the
        // velocity and direction of the LightCycles.
        keyEvent.consume();
    }

    public void onPauseButton(ActionEvent actionEvent) throws Exception {
        if (this.paused) {
            this.setUpAnimationTimer();
            this.pauseButton.setText("Pause");
        } else {
            this.timer.cancel();
            this.pauseButton.setText("Resume");
        }
        this.paused = !this.paused;
    }

    //this sets and saves the primary stage for reuse in the window recreation.
    public void setStage(Stage primary) {
        this.primaryStage = primary;
    }
    public Stage getStage(){
        return this.primaryStage;
    }


    public void callVictoryPage() throws Exception{
        System.out.println(this.win);
        Main victor = new Main();
        victor.victorPage(this.primaryStage, this.win);
    }
}
