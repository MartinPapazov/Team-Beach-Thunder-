package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.Deathbringer;

import java.awt.image.BufferedImage;

public class TestLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelOneBackground;
    private static final int coins = 500;

    public TestLevel() {
        super(backgroundImage, coins);
        this.initialization();
    }

    private void initialization() {
        this.addEnemySpaceship(new Deathbringer(Constants.WindowHeight - 200, Constants.WindowWidth/2),
                new Deathbringer(500, 350), new Deathbringer(100, 290));
    }

    @Override
    protected void spaceShipRotation(Spaceship spaceship) {

    }
}
