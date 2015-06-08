package carltron;

import java.util.Random;

/**
 * AiPlayer.java
 * This class represents an AI player in 1 player mode. It defines basic
 * strategic methods to prevent path and edge collisions.
 */
public class AiPlayer extends Player {
    // instance variable field
    private Player human;
    private Grid grid;
    private GridCell goal;
    private Random generator = new Random();

    public AiPlayer(LightCycle vehicle, Player human, Grid grid) {
        super(vehicle);
        this.human = human;
        this.grid = grid;
        this.goal = grid.getCells()[60][220];
    }


    public void strategy() {

        if (almostHitUp()) {
            turnLeft();
        } else if (almostHitDown()) {
            turnRight();
        } else if (almostHitLeft()) {
            turnDown();
        } else if (almostHitRight()) {
            turnUp();
        }

        GridCell nextStep = grid.getCells()[(int)vehicle.getLayoutX() +
                10*vehicle.getVelocityX()][
                (int)vehicle.getLayoutY() + 10*vehicle.getVelocityY()];

        for (int i=0; i<4 && nextStep.isWall(); i++) {
            randomTurn();
        }
    }

    public boolean almostHitUp() {
        return vehicle.getVelocityY() == -1 && vehicle.getLayoutY() <= 5;
    }

    public boolean almostHitDown() {
        return vehicle.getVelocityY() == 1 &&
                vehicle.getLayoutY() >= grid.DEFAULT_HEIGHT-5;
    }

    public boolean almostHitLeft() {
        return vehicle.getVelocityX() == -1 && vehicle.getLayoutX() <= 5;
    }

    public boolean almostHitRight() {
        return vehicle.getVelocityX() == 1 &&
                vehicle.getLayoutX() >= grid.DEFAULT_WIDTH-5;
    }


    private int randInt(int min, int max) {
        return (generator.nextInt((max - min)+1)+min)*5;
    }

    private double getDistance() {
        return Math.sqrt(Math.pow(this.vehicle.getLayoutX() -
                human.vehicle.getLayoutX(), 2) +
                Math.pow(this.vehicle.getLayoutY() -
                        human.vehicle.getLayoutY(), 2));
    }

    public void randomTurn() {
        int change = randInt(0,3);
        switch (change) {
            case 0: turnLeft(); break;
            case 5: turnRight(); break;
            case 10: turnUp(); break;
            case 15: turnDown(); break;
            default: turnUp(); break;
        }
    }

    public void turnLeft() {
        if (vehicle.getVelocityX() <= 0) {
            this.vehicle.setVelocityX(-1);
            this.vehicle.setVelocityY(0);
        }
    }

    public void turnRight() {
        if (vehicle.getVelocityX() >= 0) {
            this.vehicle.setVelocityX(1);
            this.vehicle.setVelocityY(0);
        }
    }

    public void turnUp() {
        if (vehicle.getVelocityY() <= 0) {
            this.vehicle.setVelocityX(0);
            this.vehicle.setVelocityY(-1);
        }
    }

    public void turnDown() {
        if (vehicle.getVelocityY() >= 0) {
            this.vehicle.setVelocityX(0);
            this.vehicle.setVelocityY(1);
        }
    }

}