package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.*;

import java.awt.image.BufferedImage;
import java.util.Random;

public class SixthLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelSixBackground;
    private static final int coins = 1800;
    private Spaceship dragonScout1 = new DragonScout(800, 30, 80);
    private Spaceship dragonScout2 = new DragonScout(800, 530, 80);
    private Spaceship dragonDestroyer1 = new DragonDestroyer(700, 120, 70);
    private Spaceship dragonDestroyer2 = new DragonDestroyer(700, 370, 70);
    private Spaceship nightRider3 = new NightRider(600, 230, 60);
    private Spaceship littleSilver = new LittleSilver(560, 330, 90);

    public SixthLevel() {
        super(backgroundImage, coins, 6);
        this.initialization();
    }

    private void initialization() {

        this.addEnemySpaceship(
                this.dragonScout1,
                this.dragonScout2,
                this.dragonDestroyer1,
                this.dragonDestroyer2,
                this.nightRider3,
                this.littleSilver
        );

        this.dragonScout1.setIsMovingLeft(true);
        this.dragonScout2.setIsMovingLeft(true);
        this.nightRider3.setIsMovingLeft(true);
        this.littleSilver.setIsMovingUp(true);
        this.dragonDestroyer1.setIsMovingDown(true);
        this.dragonDestroyer2.setIsMovingUp(true);

    }

    private void movingLeftAndRight(Spaceship spaceship){
        if(spaceship.getX() < 520){
            spaceship.setIsMovingLeft(false);
            spaceship.setIsMovingRight(true);
        }
        if(spaceship.getX() >= 780){
            spaceship.setIsMovingRight(false);
            spaceship.setIsMovingLeft(true);
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

    private void movingUpAndDownAgain(Spaceship spaceship){

        if(spaceship.getY() < 130){
            spaceship.setIsMovingUp(false);
            spaceship.setIsMovingDown(true);
        }
        if(spaceship.getY() > 430){
            spaceship.setIsMovingDown(false);
            spaceship.setIsMovingUp(true);
        }
    }

    @Override
    protected void spaceShipRotation(Spaceship spaceship) {
        movingLeftAndRight(this.dragonScout1);
        movingLeftAndRight(this.dragonScout2);
        movingLeftAndRight(this.nightRider3);

        if(this.littleSilver.getY() < 135){
            this.littleSilver.setIsMovingDown(true);
            this.littleSilver.setIsMovingUp(false);
        }
        if(this.littleSilver.getY() > 400){
            this.littleSilver.setIsMovingDown(false);
            this.littleSilver.setIsMovingUp(true);
        }

        movingDownAndUpAgain(this.dragonDestroyer1);
        movingUpAndDownAgain(this.dragonDestroyer2);

        for (Spaceship sp : this.getEnemys()) {
            sp.fire();
        }
    }

}
