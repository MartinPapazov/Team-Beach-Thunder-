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

public class EnemySpaceshipsTestLevel extends Level {
    private static final BufferedImage backgroundImage = Assets.levelOneBackground;
    private static final int coins = 500;
    private final int movementCounter = 150;

    private int count;

    public EnemySpaceshipsTestLevel() {
        super(backgroundImage, coins);
        this.initialization();
        this.count = 0;
    }

    private void initialization() {
        this.addEnemySpaceship(new Deathbringer(Constants.WindowHeight - 200, Constants.WindowWidth / 2, 500));
        this.addEnemySpaceship(new NightRider(Constants.WindowHeight - 200, Constants.WindowWidth / 2, 500));
        this.addEnemySpaceship(new BlueShip(Constants.WindowHeight - 100, Constants.WindowWidth / 2, 300));
        this.addEnemySpaceship(new LittleSilver(Constants.WindowHeight - 50, Constants.WindowWidth / 2, 400));

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
        if (counterFinished ||
                spaceship.getY() <= 10 ||
                spaceship.getY() >= Constants.WindowHeight - spaceship.getHeight() - 10) {
            if (counterFinished) {
                this.count = 0;
            }

            if (spaceship.isMovingDown) {
                spaceship.isMovingDown = false;
                spaceship.isMovingUp = true;
            } else if (spaceship.isMovingUp) {
                spaceship.isMovingUp = false;
                spaceship.isMovingDown = true;
            }
        }

        this.count++;


    }
}
