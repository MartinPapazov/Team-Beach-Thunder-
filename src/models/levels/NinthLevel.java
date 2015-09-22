package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.Deathbringer;
import models.spaceships.enemySpaceships.DragonFighter;
import models.spaceships.enemySpaceships.LittleSilver;
import models.spaceships.enemySpaceships.NightRider;

import java.awt.image.BufferedImage;
import java.util.Random;

public class NinthLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelNineBackground;
    private static final int coins = 500;
    private final int movementCounter = 150;

    private int count;

    public NinthLevel() {

        super(backgroundImage, coins, 9);
        this.initialization();
        this.count = 0;
    }

    private void initialization() {

        this.addEnemySpaceship(
                new NightRider(600, 250, 500),
                new DragonFighter(700, 350, 70),
                new LittleSilver(500, 100, 160),
                new LittleSilver(700, 250, 250),
                new DragonFighter(800, 450, 150)
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
