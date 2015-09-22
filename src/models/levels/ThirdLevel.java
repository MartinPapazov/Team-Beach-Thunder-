package models.levels;

import Utilitys.Constants;
import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.*;
import java.awt.image.BufferedImage;

public class ThirdLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelThreeBackground;
    private static final int coins = 1000;
    private final int movementCounter = 150;
    private Spaceship blueShip = new BlueShip(Constants.WindowWidth - 120, 180, 150);
    private Spaceship dragonFighter = new DragonFighter(750, 450, 130);
    private Spaceship deathbringer = new Deathbringer(750, 100, 140);
    private Spaceship nightRider1 = new NightRider(550, 100, 20);
    private Spaceship nightRider2 = new NightRider(550, Constants.WindowHeight - 200, 20);

    private int count;

    public ThirdLevel() {
        super(backgroundImage, coins, 3);
        this.initialization();
        this.count = 0;
    }

    private void initialization() {

        this.addEnemySpaceship(
                this.blueShip,
                this.dragonFighter,
                this.deathbringer,
                this.nightRider1,
                this.nightRider2
        );

        this.deathbringer.setIsMovingDown(true);
        this.deathbringer.setIsMovingLeft(true);
        this.dragonFighter.setIsMovingUp(true);
        this.dragonFighter.setIsMovingLeft(true);
        this.blueShip.setIsMovingDown(true);
        this.nightRider1.setIsMovingUp(true);
        this.nightRider1.setIsMovingLeft(true);
        this.nightRider2.setIsMovingDown(true);
        this.nightRider2.setIsMovingLeft(true);

    }

    @Override
    protected void spaceShipRotation(Spaceship spaceship) {
        if (this.deathbringer.getY() + this.deathbringer.getWidth() >= Constants.WindowHeight - 300) {
            this.deathbringer.setIsMovingDown(false);
            this.deathbringer.setIsMovingLeft(false);
            this.deathbringer.setIsMovingUp(true);
            this.deathbringer.setIsMovingRight(true);
        }
        if (this.deathbringer.getY() < Constants.GameStatusBar + 40) {
            this.deathbringer.setIsMovingDown(true);
            this.deathbringer.setIsMovingLeft(true);
            this.deathbringer.setIsMovingUp(false);
            this.deathbringer.setIsMovingRight(false);
        }

        if (this.dragonFighter.getY() < Constants.GameStatusBar + 150) {
            this.dragonFighter.setIsMovingUp(false);
            this.dragonFighter.setIsMovingLeft(false);
            this.dragonFighter.setIsMovingDown(true);
            this.dragonFighter.setIsMovingRight(true);
        }

        if (this.dragonFighter.getY() + this.dragonFighter.getWidth() > Constants.WindowHeight - 50) {
            this.dragonFighter.setIsMovingUp(true);
            this.dragonFighter.setIsMovingLeft(true);
            this.dragonFighter.setIsMovingDown(false);
            this.dragonFighter.setIsMovingRight(false);
        }

        if (this.blueShip.getY() >= 340) {
            this.blueShip.setIsMovingDown(false);
            this.blueShip.setIsMovingUp(true);
        }

        if (this.blueShip.getY() <= 180) {
            this.blueShip.setIsMovingDown(true);
            this.blueShip.setIsMovingUp(false);
        }

        if (this.nightRider1.getX() <= 450) {
            this.nightRider1.setIsMovingUp(false);
            this.nightRider1.setIsMovingLeft(false);
            this.nightRider1.setIsMovingDown(false);
            this.nightRider1.setIsMovingRight(true);
        }

        if (this.nightRider1.getX() >= 550) {
            this.nightRider1.setIsMovingUp(false);
            this.nightRider1.setIsMovingLeft(false);
            this.nightRider1.setIsMovingDown(true);
            this.nightRider1.setIsMovingRight(false);
        }

        if (this.nightRider1.getY() >= 100) {
            this.nightRider1.setIsMovingUp(true);
            this.nightRider1.setIsMovingLeft(true);
            this.nightRider1.setIsMovingDown(false);
            this.nightRider1.setIsMovingRight(false);
        }

        //nightrider 2
        if (this.nightRider2.getX() <= 450) {
            this.nightRider2.setIsMovingUp(false);
            this.nightRider2.setIsMovingLeft(false);
            this.nightRider2.setIsMovingDown(false);
            this.nightRider2.setIsMovingRight(true);
        }

       if (this.nightRider2.getX() > 550) {
           this.nightRider2.setIsMovingUp(true);
           this.nightRider2.setIsMovingLeft(false);
           this.nightRider2.setIsMovingDown(false);
           this.nightRider2.setIsMovingRight(false);
       }

       if (this.nightRider2.getY() <= Constants.WindowHeight - 200) {
           this.nightRider2.setIsMovingUp(false);
           this.nightRider2.setIsMovingLeft(true);
           this.nightRider2.setIsMovingDown(true);
           this.nightRider2.setIsMovingRight(false);
       }
        for (Spaceship sp : this.getEnemys()) {
            sp.fire();
        }
    }
}
