package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.*;
import models.spaceships.playerSpaceships.Spacecruiser;

import java.awt.image.BufferedImage;
import java.util.Random;

public class FifthLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelFiveBackground;
    private static final int coins = 1600;
    private Spaceship dragonDestroyer1 = new DragonDestroyer(800, 480, 80);
    private Spaceship dragonDestroyer2 = new DragonDestroyer(800, 30, 70);
    private Spaceship dragonScout1 = new DragonScout(700, 480, 100);
    private Spaceship dragonScout2 = new DragonScout(700, 30, 90);
    private Spaceship littleSilver1 = new LittleSilver(600, 480, 120);
    private Spaceship littleSilver2 = new LittleSilver(600, 30, 110);


    public FifthLevel() {
        super(backgroundImage, coins, 5);
        this.initialization();
    }

    private void initialization() {

        this.addEnemySpaceship(
                this.dragonDestroyer1,
                this.dragonDestroyer2,
                this.dragonScout1,
                this.dragonScout2,
                this.littleSilver1,
                this.littleSilver2
        );

        this.dragonDestroyer1.setIsMovingUp(true);
        this.dragonDestroyer2.setIsMovingDown(true);
        this.dragonScout1.setIsMovingUp(true);
        this.dragonScout2.setIsMovingDown(true);
        this.littleSilver1.setIsMovingUp(true);
        this.littleSilver2.setIsMovingDown(true);

    }

    private void movingDownAndUpAgain(Spaceship spaceship){


        if(spaceship.getY() > 470){
            spaceship.setIsMovingDown(false);
            spaceship.setIsMovingUp(true);
        }
        if(spaceship.getY() < 55){
            spaceship.setIsMovingDown(true);
            spaceship.setIsMovingUp(false);
        }
    }

    private void movingUpAndDownAgain(Spaceship spaceship){

        if(spaceship.getY() < 55){
            spaceship.setIsMovingDown(true);
            spaceship.setIsMovingUp(false);
        }
        if(spaceship.getY() > 470){
            spaceship.setIsMovingDown(false);
            spaceship.setIsMovingUp(true);
        }
    }

    @Override
    protected void spaceShipRotation(Spaceship spaceship) {

        movingUpAndDownAgain(this.dragonDestroyer1);
        movingUpAndDownAgain(this.dragonScout1);
        movingUpAndDownAgain(this.littleSilver1);

        movingDownAndUpAgain(this.dragonDestroyer2);
        movingDownAndUpAgain(this.dragonScout2);
        movingDownAndUpAgain(this.littleSilver2);

        for (Spaceship sp : this.getEnemys()) {
            sp.fire();
        }
    }
}
