package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.*;

import java.awt.image.BufferedImage;
import java.util.Random;

public class FourthLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelFourBackground;
    private static final int coins = 1400;
    private Spaceship dragonFighter1 = new DragonFighter(800, 30, 150);
    private Spaceship dragonFighter2 = new DragonFighter(800, 480, 150);
    private Spaceship littleSilver1 = new LittleSilver(800, 30, 130);
    private Spaceship littleSilver2 = new LittleSilver(800, 480, 130);
    private Spaceship nightRider = new NightRider(800, 285, 100);

    public FourthLevel() {
        super(backgroundImage, coins, 4);
        this.initialization();
    }

    private void initialization() {

        this.addEnemySpaceship(
                this.dragonFighter1,
                this.dragonFighter2,
                this.littleSilver1,
                this.littleSilver2,
                this.nightRider

        );

        this.dragonFighter1.setIsMovingLeft(true);
        this.dragonFighter1.setIsMovingDown(true);
        this.dragonFighter2.setIsMovingUp(true);
        this.dragonFighter2.setIsMovingLeft(true);
        this.littleSilver1.setIsMovingLeft(true);
        this.littleSilver1.setIsMovingLeft(true);
        this.littleSilver2.setIsMovingLeft(true);
        this.littleSilver2.setIsMovingLeft(true);
        this.nightRider.setIsMovingUp(true);

    }

    @Override
    protected void spaceShipRotation(Spaceship spaceship) {

        //enemyShip 1
        if(this.dragonFighter1.getX() < 560){
            this.dragonFighter1.setIsMovingLeft(false);
            this.dragonFighter1.setIsMovingRight(true);
        }
        if(this.dragonFighter1.getX() >= 780){
            this.dragonFighter1.setIsMovingRight(false);
            this.dragonFighter1.setIsMovingLeft(true);
        }
        if(this.dragonFighter1.getY() > 470){
            this.dragonFighter1.setIsMovingDown(false);
            this.dragonFighter1.setIsMovingUp(true);
        }
        if(this.dragonFighter1.getY() < 75){
            this.dragonFighter1.setIsMovingDown(true);
            this.dragonFighter1.setIsMovingUp(false);
        }

        //enemyShip 2
        if(this.dragonFighter2.getX() < 560){
            this.dragonFighter2.setIsMovingLeft(false);
            this.dragonFighter2.setIsMovingRight(true);
        }
        if(this.dragonFighter2.getX() >= 780){
            this.dragonFighter2.setIsMovingRight(false);
            this.dragonFighter2.setIsMovingLeft(true);
        }
        if(this.dragonFighter2.getY() < 75){
            this.dragonFighter2.setIsMovingDown(true);
            this.dragonFighter2.setIsMovingUp(false);
        }
        if(this.dragonFighter2.getY() > 470){
            this.dragonFighter2.setIsMovingDown(false);
            this.dragonFighter2.setIsMovingUp(true);
        }

        //enemyShip3
        if(this.littleSilver1.getX() < 500){
            this.littleSilver1.setIsMovingLeft(false);
            this.littleSilver1.setIsMovingRight(true);
        }
        if(this.littleSilver1.getX() >= 780){
            this.littleSilver1.setIsMovingRight(false);
            this.littleSilver1.setIsMovingLeft(true);
        }

        //enemyShip4
        if(this.littleSilver2.getX() < 500){
            this.littleSilver2.setIsMovingLeft(false);
            this.littleSilver2.setIsMovingRight(true);
        }
        if(this.littleSilver2.getX() >= 780){
            this.littleSilver2.setIsMovingRight(false);
            this.littleSilver2.setIsMovingLeft(true);
        }

        //enemyShip5
        if(this.nightRider.getY() < 185){
            this.nightRider.setIsMovingDown(true);
            this.nightRider.setIsMovingUp(false);
        }
        if(this.nightRider.getY() > 300){
            this.nightRider.setIsMovingDown(false);
            this.nightRider.setIsMovingUp(true);
        }

        for (Spaceship sp : this.getEnemys()) {
            sp.fire();
        }
    }
}
