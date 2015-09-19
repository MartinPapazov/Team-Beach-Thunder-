package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.*;

import java.awt.image.BufferedImage;
import java.util.Random;

public class ThirdLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelThreeBackground;
    private static final int coins = 1000;
    private final int movementCounter = 150;

    private int count;

    public ThirdLevel() {
        super(backgroundImage, coins);
        this.initialization();
        this.count = 0;
    }

    private void initialization() {

        this.addEnemySpaceship(
                new BlueShip(500, 250, 220),
                new DragonFighter(700, 450, 130),
                new Deathbringer(650, 100, 140),
                new Deathbringer(450, 400, 130),
                new NightRider(600, 250, 45)
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

        boolean isCounterFinished = this.count >= movementCounter;
        boolean isEnemyShipAtTopLine = spaceship.getY() <= 10 + Constants.GameStatusBar;
        boolean isEnemyShipAtBottomLine = spaceship.getY() >= Constants.WindowHeight - spaceship.getHeight() - 10;
        if (isCounterFinished || isEnemyShipAtTopLine || isEnemyShipAtBottomLine) {
            if (isCounterFinished) {
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
