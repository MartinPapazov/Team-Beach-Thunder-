package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.Deathbringer;
import models.spaceships.enemySpaceships.NightRider;

import java.awt.image.BufferedImage;
import java.util.Random;

public class SecondLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelTwoBackground;
    //TODO set coins value and movementCounter
    private static final int coins = 800;
    private final int movementCounter = 220;

    private int count;

    public SecondLevel(){
        super(backgroundImage,coins);
        this.initialization();
        this.count = 0;
    }

    private void initialization(){
        this.addEnemySpaceship(
                new NightRider(600, 250, 500),
                new Deathbringer(400, 250, 180),
                new Deathbringer(700, 350, 180),
                new Deathbringer(800, 450, 250),
                new NightRider(500, 100, 160)
        );
    }


    @Override
    protected void spaceShipRotation(Spaceship spaceship) {
        spaceship.fire();
        if (!spaceship.isMovingDown && !spaceship.isMovingUp) {
            Random random = new Random();
            switch (random.nextInt(2)) {
                case 0:
                    spaceship.isMovingDown = true;
                    break;
                case 1:
                    spaceship.isMovingUp = true;
            }
        }

        boolean counterFinished = this.count >= movementCounter;
        if ( counterFinished ||
                spaceship.getY() <= 10 + Constants.GameStatusBar ||
                spaceship.getY() >= Constants.WindowHeight - spaceship.getHeight() - 10) {
            if (counterFinished) {
                this.count = 0;
            }

            if (spaceship.isMovingDown) {
                spaceship.isMovingDown = false;
                spaceship.isMovingUp = true;
            } else if(spaceship.isMovingUp) {
                spaceship.isMovingUp = false;
                spaceship.isMovingDown = true;
            }
        }
    }
}
