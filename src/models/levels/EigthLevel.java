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

public class EigthLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelEightBackground;
    private static final int coins = 2000;
    private final int movementCounter = 150;

    private int count;

    public EigthLevel() {

        super(backgroundImage, coins);
        this.initialization();
        this.count = 0;
    }

    private void initialization() {

        this.addEnemySpaceship(
                new NightRider(800, 250, 300),
                new DragonFighter(750, 350, 170),
                new NightRider(640, 100, 160),
                new DragonFighter(300, 250, 150),
                new LittleSilver(800, 450, 150),
                new Deathbringer(450, 290, 30)
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
