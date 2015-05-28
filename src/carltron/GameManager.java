package carltron;

public class GameManager implements EventHandler<KeyEvent> {
    final private double FRAMES_PER_SECOND = 20.0;

    @FXML private Button pauseButton;

    public GameManager() {
        this.paused = false;
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
        // do something
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        KeyCode code = keyEvent.getCode();
        // do something

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
        // turbo 2nd player?
        } else if (code == KeyCode.ENTER) {
            // do something
        // jump 2nd player?
        } else if (code == KeyCode.SHIFT) {
            // do something
        }
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
