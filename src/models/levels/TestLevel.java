package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.Deathbringer;

import java.awt.image.BufferedImage;
import java.util.Random;

public class TestLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelOneBackground;
    private static final int coins = 500;
    private final int movementCounter = 150;

    private int count;

    public TestLevel() {
        super(backgroundImage, coins);
        this.initialization();
        this.count = 0;
    }

    private void initialization() {
        this.addEnemySpaceship(new Deathbringer(Constants.WindowHeight - 200, Constants.WindowWidth/2, 500),
                new Deathbringer(Constants.WindowWidth - 100, 350, 100),
                new Deathbringer(500, 100, 50),
                new Deathbringer(400, 250, 50));
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
                spaceship.getY() <= 10 ||
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

        this.count++;


    }
}
