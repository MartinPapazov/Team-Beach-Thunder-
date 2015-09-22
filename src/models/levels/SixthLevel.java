package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.BlueShip;
import models.spaceships.enemySpaceships.Deathbringer;
import models.spaceships.enemySpaceships.LittleSilver;
import models.spaceships.enemySpaceships.NightRider;

import java.awt.image.BufferedImage;
import java.util.Random;

public class SixthLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelSixBackground;
    private static final int coins = 1800;
    private final int movementCounter = 150;

    private int count;

    public SixthLevel() {
        super(backgroundImage, coins, 6);
        this.initialization();
        this.count = 0;
    }

    private void initialization() {

        this.addEnemySpaceship(
                new Deathbringer(670, 350, 100),
                new LittleSilver(580, 250, 170),
                new BlueShip(550, 200, 160),
                new NightRider(500, 100, 210),
                new NightRider(700, 250, 200),
                new Deathbringer(800, 400, 50)
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
