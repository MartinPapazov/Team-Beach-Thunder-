package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.*;

import java.awt.image.BufferedImage;
import java.util.Random;

public class EigthLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelEightBackground;
    private static final int coins = 3000;
    private Spaceship littleSilver1 = new LittleSilver(800, 30, 100);
    private Spaceship littleSilver2 = new LittleSilver(750, 60, 130);
    private Spaceship littleSilver3 = new LittleSilver(700, 90, 190);
    private Spaceship littleSilver4 = new LittleSilver(650, 120, 220);
    private Spaceship dragonScout1 = new DragonDestroyer(700, 250, 100);
    private Spaceship dragonScout2 = new DragonDestroyer(700, 150, 120);
    private Spaceship dragonScout3 = new DragonDestroyer(700, 50, 130);
    private Spaceship dragonScout4 = new DragonDestroyer(700, 30, 130);


    public EigthLevel() {

        super(backgroundImage, coins, 8);
        this.initialization();
    }

    private void moveLeftAndDown(Spaceship spaceship){
        spaceship.setIsMovingDown(true);
        spaceship.setIsMovingLeft(true);
    }

    private void initialization() {

        this.addEnemySpaceship(
                this.littleSilver1,
                this.littleSilver2,
                this.littleSilver3,
                this.littleSilver4,
                this.dragonScout1,
                this.dragonScout2,
                this.dragonScout3,
                this.dragonScout4
        );

        moveLeftAndDown(littleSilver1);
        moveLeftAndDown(littleSilver2);
        moveLeftAndDown(littleSilver3);
        moveLeftAndDown(littleSilver4);

        this.dragonScout1.setIsMovingDown(true);
        this.dragonScout2.setIsMovingDown(true);
        this.dragonScout3.setIsMovingDown(true);
        this.dragonScout4.setIsMovingDown(true);
    }

    private void rotationEverywhere(Spaceship spaceship) {

        if (spaceship.getX() < 530) {
            spaceship.setIsMovingLeft(false);
            spaceship.setIsMovingRight(true);
        }
        if (spaceship.getX() >= 780) {
            spaceship.setIsMovingRight(false);
            spaceship.setIsMovingLeft(true);
        }
        if (spaceship.getY() > 470) {
            spaceship.setIsMovingDown(false);
            spaceship.setIsMovingUp(true);
        }
        if (spaceship.getY() < 75) {
            spaceship.setIsMovingDown(true);
            spaceship.setIsMovingUp(false);
        }
    }

    private void movingDownAndUpAgain(Spaceship spaceship){


        if(spaceship.getY() > 430){
            spaceship.setIsMovingDown(false);
            spaceship.setIsMovingUp(true);
        }
        if(spaceship.getY() < 130){
            spaceship.setIsMovingDown(true);
            spaceship.setIsMovingUp(false);
        }
    }

    @Override
    protected void spaceShipRotation(Spaceship spaceship) {
        rotationEverywhere(this.littleSilver1);
        rotationEverywhere(this.littleSilver2);
        rotationEverywhere(this.littleSilver3);
        rotationEverywhere(this.littleSilver4);
        movingDownAndUpAgain(this.dragonScout1);
        movingDownAndUpAgain(this.dragonScout2);
        movingDownAndUpAgain(this.dragonScout3);
        movingDownAndUpAgain(this.dragonScout4);

        for (Spaceship sp : this.getEnemys()) {
            sp.fire();
        }
    }
}
