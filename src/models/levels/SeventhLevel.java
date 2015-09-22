package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.*;

import java.awt.image.BufferedImage;
import java.util.Random;

public class SeventhLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelSevenBackground;
    private static final int coins = 2200;
    private Spaceship littleSilver1 = new LittleSilver(800, 40, 100);
    private Spaceship littleSilver2 = new LittleSilver(800, 500, 100);
    private Spaceship dragonDestroyer1 = new DragonDestroyer(800, 30, 200);
    private Spaceship dragonDestroyer2 = new DragonDestroyer(800, 250, 200);
    private Spaceship dragonDestroyer3 = new DragonDestroyer(800, 530, 200);

    public SeventhLevel() {

        super(backgroundImage, coins, 7);
        this.initialization();
    }

    private void initialization() {

        this.addEnemySpaceship(
                this.littleSilver1,
                this.littleSilver2,
                this.dragonDestroyer1,
                this.dragonDestroyer2,
                this.dragonDestroyer3
        );

        this.littleSilver1.setIsMovingLeft(true);
        this.littleSilver2.setIsMovingLeft(true);
        this.dragonDestroyer1.setIsMovingDown(true);
        this.dragonDestroyer1.setIsMovingLeft(true);
        this.dragonDestroyer2.setIsMovingDown(true);
        this.dragonDestroyer2.setIsMovingLeft(true);
        this.dragonDestroyer3.setIsMovingUp(true);
        this.dragonDestroyer3.setIsMovingLeft(true);

    }

    private void rotationEverywhere(Spaceship spaceship) {

        if (spaceship.getX() < 560) {
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

    private void movingLeftAndRight(Spaceship spaceship){
        if(spaceship.getX() < 500){
            spaceship.setIsMovingLeft(false);
            spaceship.setIsMovingRight(true);
        }
        if(spaceship.getX() >= 780){
            spaceship.setIsMovingRight(false);
            spaceship.setIsMovingLeft(true);
        }
    }

    @Override
    protected void spaceShipRotation(Spaceship spaceship) {

        rotationEverywhere(this.dragonDestroyer1);
        rotationEverywhere(this.dragonDestroyer2);

        if(this.dragonDestroyer3.getX() < 560){
            this.dragonDestroyer3.setIsMovingLeft(false);
            this.dragonDestroyer3.setIsMovingRight(true);
        }
        if(this.dragonDestroyer3.getX() >= 780){
            this.dragonDestroyer3.setIsMovingRight(false);
            this.dragonDestroyer3.setIsMovingLeft(true);
        }
        if(this.dragonDestroyer3.getY() < 75){
            this.dragonDestroyer3.setIsMovingDown(true);
            this.dragonDestroyer3.setIsMovingUp(false);
        }
        if(this.dragonDestroyer3.getY() > 470){
            this.dragonDestroyer3.setIsMovingDown(false);
            this.dragonDestroyer3.setIsMovingUp(true);
        }

        movingLeftAndRight(this.littleSilver1);
        movingLeftAndRight(this.littleSilver2);

        for (Spaceship sp : this.getEnemys()) {
            sp.fire();
        }
    }
}