package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.*;

import java.awt.image.BufferedImage;
import java.util.Random;

public class SecondLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelTwoBackground;
    //TODO set coins value and movementCounter
    private static final int coins = 800;
    private final int movementCounter = 220;
    private Spaceship nightRider1 = new NightRider(Constants.WindowWidth - 120, 50, 100);
    private Spaceship deathbringer1 = new Deathbringer(400, 100, 50);
    private Spaceship deathbringer2 = new Deathbringer(400 , Constants.WindowHeight - 120,100);
    private Spaceship nightRider2 = new NightRider(Constants.WindowWidth - 120,Constants.WindowHeight - 120, 100);
    private Spaceship blueShip = new BlueShip(Constants.WindowWidth - 120,Constants.WindowHeight / 2 , 100);

    private int count;

    public SecondLevel(){
        super(backgroundImage,coins, 2);
        this.initialization();
        this.count = 0;
    }

    private void initialization(){
        this.addEnemySpaceship(
               this.nightRider1,
               this.deathbringer1,
               this.deathbringer2,
               this.nightRider2,
                this.blueShip

        );

        this.deathbringer1.setIsMovingDown(true);
        this.deathbringer1.setIsMovingRight(true);
        this.nightRider1.setIsMovingDown(true);
        this.nightRider1.setIsMovingLeft(true);
        this.deathbringer2.setIsMovingRight(true);
        this.deathbringer2.setIsMovingUp(true);
        this.nightRider2.setIsMovingUp(true);
        this.nightRider2.setIsMovingLeft(true);
        this.blueShip.setIsMovingUp(true);

    }


    @Override
    protected void spaceShipRotation(Spaceship spaceship) {
        spaceship.fire();

        if (this.deathbringer1.getY() + this.deathbringer1.getWidth() >= Constants.WindowHeight - 300) {
            this.deathbringer1.setIsMovingDown(false);
            this.deathbringer1.setIsMovingLeft(false);
            this.deathbringer1.setIsMovingUp(true);
            this.deathbringer1.setIsMovingRight(false);
        }
        if (this.deathbringer1.getY() < Constants.GameStatusBar + 40) {
            this.deathbringer1.setIsMovingDown(false);
            this.deathbringer1.setIsMovingLeft(true);
            this.deathbringer1.setIsMovingUp(false);
            this.deathbringer1.setIsMovingRight(false);
        }
        if (this.deathbringer1.getX() < 400){
            this.deathbringer1.setIsMovingDown(true);
            this.deathbringer1.setIsMovingLeft(false);
            this.deathbringer1.setIsMovingUp(false);
            this.deathbringer1.setIsMovingRight(true);
        }

        if (this.deathbringer2.getY() + this.deathbringer2.getWidth() <= Constants.WindowHeight - 150){
            this.deathbringer2.setIsMovingRight(false);
            this.deathbringer2.setIsMovingLeft(false);
            this.deathbringer2.setIsMovingUp(false);
            this.deathbringer2.setIsMovingDown(true);
        }

        if (this.deathbringer2.getY() + this.deathbringer2.getHeight() + 10 >= Constants.WindowHeight) {
            this.deathbringer2.setIsMovingDown(false);
            this.deathbringer2.setIsMovingLeft(true);
            this.deathbringer2.setIsMovingUp(false);
            this.deathbringer2.setIsMovingRight(false);
        }

        if (this.deathbringer2.getX() <= 400){
            this.deathbringer2.setIsMovingDown(false);
            this.deathbringer2.setIsMovingLeft(false);
            this.deathbringer2.setIsMovingUp(true);
            this.deathbringer2.setIsMovingRight(true);
        }

        if (this.nightRider1.getY() > 300) {
            this.nightRider1.setIsMovingRight(true);
            this.nightRider1.setIsMovingDown(false);
            this.nightRider1.setIsMovingLeft(false);
            this.nightRider1.setIsMovingUp(true);
        }

        if (this.nightRider1.getY() <= 50 ) {
            this.nightRider1.setIsMovingLeft(true);
            this.nightRider1.setIsMovingDown(true);
            this.nightRider1.setIsMovingRight(false);
            this.nightRider1.setIsMovingUp(false);
        }

        if ( this.nightRider2.getY() < 325){
            this.nightRider2.setIsMovingDown(true);
            this.nightRider2.setIsMovingLeft(false);
            this.nightRider2.setIsMovingUp(false);
            this.nightRider2.setIsMovingRight(true);
        }

        if(this.nightRider2.getY() + this.nightRider2.getHeight() + 10 >= Constants.WindowHeight){
            this.nightRider2.setIsMovingDown(false);
            this.nightRider2.setIsMovingLeft(true);
            this.nightRider2.setIsMovingUp(true);
            this.nightRider2.setIsMovingRight(false);
        }

        if(this.blueShip.getY() + this.blueShip.getHeight() <= 250 ){
            this.blueShip.setIsMovingLeft(false);
            this.blueShip.setIsMovingUp(false);
            this.blueShip.setIsMovingRight(false);
            this.blueShip.setIsMovingDown(true);
        }

        if(this.blueShip.getY() + this.blueShip.getHeight() >= Constants.WindowHeight - 120 ){
            this.blueShip.setIsMovingLeft(false);
            this.blueShip.setIsMovingUp(true);
            this.blueShip.setIsMovingRight(false);
            this.blueShip.setIsMovingDown(false);
        }
    }
}
