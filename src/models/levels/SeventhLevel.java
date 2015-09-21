package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.Deathbringer;
import models.spaceships.enemySpaceships.DragonFighter;
import models.spaceships.enemySpaceships.NightRider;

import java.awt.image.BufferedImage;
import java.util.Random;

public class SeventhLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelSevenBackground;
    private static final int coins = 500;
    private final int movementCounter = 150;

    private int count;

    public SeventhLevel() {

        super(backgroundImage, coins, 7);
        this.initialization();
        this.count = 0;
    }

    private void initialization() {

        this.addEnemySpaceship(
                new DragonFighter(600, 250, 500),
                new DragonFighter(750, 350, 170),
                new DragonFighter(300, 100, 160),
                new NightRider(600, 250, 150),
                new NightRider(800, 450, 150)
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
