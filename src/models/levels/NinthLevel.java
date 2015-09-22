package models.levels;


import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.enemySpaceships.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NinthLevel extends Level {

    private static final BufferedImage backgroundImage = Assets.levelNineBackground;
    private static final int coins = 20_000;
    private Spaceship spaceStation;
    private Spaceship[] defendingShips;

    private final int countDefenseWithoutShips = 2000;
    private final int maxWave = 3;

    private int wave;
    private int count;
    private int maxWidth;
    private int currentHealth;


    public NinthLevel() {
        super(backgroundImage, coins, 9);
        this.initialization();
        this.wave = 0;
        this.maxWidth = this.spaceStation.getHealth()/100;
        this.currentHealth = spaceStation.getHealth();
    }

    private void initialization() {
        this.spaceStation = new SpaceStation(450, 100,10);
        this.spaceStation.setIsMovingUp(true);
        this.addEnemySpaceship(this.spaceStation);
        this.count = 1500;
        this.defendingShips = new Spaceship[5];
    }

    @Override
    protected void spaceShipRotation(Spaceship spaceship) {
        boolean areDefendersAlive = checkForAliveDefenders();
        if (!areDefendersAlive) {
            this.count++;
            if (this.count >= this.countDefenseWithoutShips) {
                if (this.wave <= this.maxWave) {
                    this.callSpaceships();
                }
                this.count = 0;
            }
            this.moveSpaceStationAndFire();
        }

        if (areDefendersAlive) {
            this.spaceStation.setHeath(this.currentHealth);
            this.defendersStopAtLocation();
            this.defendersAttack();
        }
    }

    private Spaceship getSpaceshipByWave(int num) {
        switch (this.wave) {
            case 0: return new Deathbringer(750, 50 + num * 100, 80);
            case 1: return new NightRider(750, 50 + num * 100, 80);
            case 2: return new DragonFighter(750, 50 + num * 100, 80);
            case 3: return new DragonReaper(750, 50 + num * 100, 80);
        }
        return null;
    }

    private void callSpaceships() {
        this.currentHealth = this.spaceStation.getHealth();
        for (int i = 0; i < this.defendingShips.length; i++) {
            this.defendingShips[i] = getSpaceshipByWave(i);
            this.defendingShips[i].setIsMovingLeft(true);
        }

        this.addEnemySpaceship(this.defendingShips);
        this.wave++;
    }

    private boolean checkForAliveDefenders() {
        for (int i = 0; i < defendingShips.length; i++) {
            if (defendingShips[i] == null){
                return false;
            }

            int spaceshipHealth = defendingShips[i].getHealth();
            if (spaceshipHealth > 0) {
                return true;
            }
        }

        return false;
    }

    private void moveSpaceStationAndFire() {
        this.spaceStation.fire();
        if (this.spaceStation.getY() <= 40) {
            this.spaceStation.setIsMovingUp(false);
            this.spaceStation.setIsMovingDown(true);
        }

        if (this.spaceStation.getY() >= 85) {
            this.spaceStation.setIsMovingUp(true);
            this.spaceStation.setIsMovingDown(false);
        }
    }

    private void defendersStopAtLocation() {
        for (int i = 0; i < defendingShips.length; i++) {
            Spaceship defendingShip = defendingShips[i];
            if (defendingShip != null) {
                if (defendingShip.getX() <= 380) {
                    defendingShip.setIsMovingLeft(false);
                }
            }
        }
    }

    private void defendersAttack() {
        for (int i = 0; i < defendingShips.length; i++) {
            Spaceship defendingShip = defendingShips[i];
            if (defendingShip != null) {
                defendingShip.fire();
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);

        graphics.drawString("Space Station health:", 550, 20);
        graphics.setColor(Color.white);
        graphics.fillRect(590, 5, this.maxWidth, 20);
        graphics.setColor(Color.RED);
        graphics.fillRect(590, 5, this.spaceStation.getHealth()/100, 20);
        graphics.setColor(Color.black);
        graphics.drawRect(590, 5, this.maxWidth, 20);
    }
}
