package carltron;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Lavel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.Timer;
import java.util.TimerTask;

public class GameManager implements EventHandler<KeyEvent> {
    final private double FRAMES_PER_SECOND = 20.0;

    @FXML private Button pauseButton;
    @FXML private Rectangle player1;
    @FXML private Rectangle player2;
    @FXML private AnchorPane gameBoard;
    @FXML private Label player1TurboLabel;
    @FXML private Label player2TurboLabel;
    @FXML private Label player1JumpLabel;
    @FXML private Label player2JumpLabel;
    @FXML private Label player1ProtectorLabel;
    @FXML private Label player2ProtectorLabel;

    private int player1_turbo;
    private int player2_turbo;
    private int player1_jump;
    private int player2_jump;
    private int player1_protector;
    private int player2_protector;
    private boolean paused;
    private Timer timer;

    public GameManager() {
        this.paused = false;
        this.player1_turbo = 3;
        this.player2_turbo = 3;
        this.player1_jump = 3;
        this.player2_jump = 3;
        this.player1_protector = 0;
        this.player2_protector = 0;
    }

    public void initialize() {
        this.setUpAnimationTimer();
    }

    public void setUpAnimationTimer() {
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        updateAnimation();
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

    public void updateAnimation() {
        // find position of player1
        double player1X = this.player1.getLayoutX();
        double player1Y = this.player1.getLayoutY();

        // find position of player2
        double player2X = this.player2.getLayoutX();
        double player2Y = this.player2.getLayoutY();


        // find new position of player1
        // find new position of player2


        // do checks:

        // player1 went of the grid (top)

        // player1 went of the grid (bottom)

        // player1 went of the grid (left)

        // player1 went of the grid (right)

        // player2 went of the grid (top)

        // player2 went of the grid (bottom)

        // player2 went of the grid (left)

        // player2 went of the grid (right)


        // check if player1 crashed with path

        // check if player2 crashed with path

        // check if player1 and player2 crashed with eachother
        // --> this is a draw (tie).


        // update the position of player1 (set velocity to normal from turbo)
        // update the position of player2 (set velocity to normal from turbo)


        this.player1.step();
        this.player2.step();
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        // only gets called when a key is pressed, so here we really only want
        // to update the velocity and direction in which the player is moving.

        KeyCode code = keyEvent.getCode();

        double player1PositionX = this.player1.getLayoutX();
        double player1PositionY = this.player1.getLayoutY();
        double player2PositionX = this.player2.getLayoutX();
        double player2PositionY = this.player2.getLayoutY();
        double stepSize = 15.0;

        // player 2
        if (code == KeyCode.LEFT) {
            // velocityX to -1 and Y to 0.
            this.player2.setVelocityY(0);
            this.player2.setVeloctiyX(-1);
        } else if (code == KeyCode.RIGHT) {
            // velocityX to 1 and Y to 0.
            this.player2.setVelocityY(0);
            this.player2.setVeloctiyX(1);
        } else if (code == KeyCode.UP) {
            // velocityX to 0 and Y to 1.
            this.player2.setVelocityY(1);
            this.player2.setVeloctiyX(0);
        } else if (code == KeyCode.DOWN) {
            // velocityX to 0 and Y to -1.
            this.player2.setVelocityY(-1);
            this.player2.setVeloctiyX(0);
        // turbo 2nd player?
        } else if (code == KeyCode.ENTER) {
            // velocityX to be 2x and Y to be 2y.
            this.player2.setVelocityY(this.player2.getVelocityY() * 2);
            this.player2.setVelocityX(this.player2.getVelocityX() * 2);
        // jump 2nd player?
        } else if (code == KeyCode.SHIFT) {
            // do something
        // protector 2nd player?
        } else if (code == KeyCode.SLASH) {
            // do something

        // player 1
        } else if (code == KeyCode.A) {
            // velocityX to -1 and Y to 0.
            this.player1.setVelocityY(0);
            this.player1.setVeloctiyX(-1);
        } else if (code == KeyCode.D) {
            // velocityX to 1 and Y to 0.
            this.player1.setVelocityY(0);
            this.player1.setVeloctiyX(1);
        } else if (code == KeyCode.W) {
            // velocityX to 0 and Y to 1.
            this.player1.setVelocityY(1);
            this.player1.setVeloctiyX(0);
        } else if (code == KeyCode.S) {
            // velocityX to 0 and Y to -1.
            this.player1.setVelocityY(-1);
            this.player1.setVeloctiyX(0);
        // turbo 1st player?
        } else if (code == KeyCode.Q) {
            // velocityX to be 2x and Y to be 2y.
            this.player1.setVelocityY(this.player1.getVelocityY() * 2);
            this.player1.setVelocityX(this.player1.getVelocityX() * 2);
        // jump 1st player?
        } else if (code == KeyCode.E) {
            // do something
        // protector 1st player?
        } else if (cdoe == KeyCode.R) {
            // do something
        }

        // if no critical key is pressed, we do not need to do anything to the
        // velocity and dircetion of the LightCycles.
    }

    public void onPauseButton(ActionEvent actionEvent) {
        if (this.paused) {
            this.setUpAnimationTimer();
        } else {
            this.timer.cancel();
        }
        this.paused = !this.paused;
    }
}
