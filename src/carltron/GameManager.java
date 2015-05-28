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
        // find new position of player1
        // find new position of player2


        // player1 went of the grid (top)

        // player1 went of the grid (bottom)

        // player1 went of the grid (left)

        // player1 went of the grid (right)

        // player2 went of the grid (top)

        // player2 went of the grid (bottom)

        // player2 went of the grid (left)

        // player2 went of the grid (right)


        // check if player1 crashed

        // check if player2 crashed


        // update the position of player1 (set velocity to normal from turbo)
        // update the position of player2 (set velocity to normal from turbo)


        this.player1.step();
        this.player2.step();
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();

        double player1PositionX = this.player1.getLayoutX();
        double player1PositionY = this.player1.getLayoutY();
        double player2PositionX = this.player2.getLayoutX();
        double player2PositionY = this.player2.getLayoutY();
        double stepSize = 15.0;

        if (code == KeyCode.LEFT) {
            // do something
        } else if (code == KeyCode.RIGHT) {
            // do something
        } else if (code == KeyCode.UP) {
            // do something
        } else if (code == KeyCode.DOWN) {
            // do something
        } else if (code == KeyCode.A) {
            // do something
        } else if (code == KeyCode.D) {
            // do something
        } else if (code == KeyCode.W) {
            // do something
        } else if (code == KeyCode.S) {
            // do something
        // turbo 1st player?
        } else if (code == KeyCode.Q) {
            // do something
        // jump 1st player?
        } else if (code == KeyCode.E) {
            // do something
        // protector 1st player?
        } else if (cdoe == KeyCode.R) {
            // do something
        // turbo 2nd player?
        } else if (code == KeyCode.ENTER) {
            // do something
        // jump 2nd player?
        } else if (code == KeyCode.SHIFT) {
            // do something
        // protector 2nd player?
        } else if (code == KeyCode.SLASH) {
            // do something
        }

        // if no critical key is pressed, we do not need to do anything to the
        // velocity of the LightCycles.
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
