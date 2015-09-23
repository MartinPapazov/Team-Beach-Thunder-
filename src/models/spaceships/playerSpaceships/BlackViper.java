package models.spaceships.playerSpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.LaserCannon;

import models.spaceships.weapons.Weapon;

public class BlackViper extends Spaceship {

    private static final String name = "Black Viper";
    private static final int width = 120;
    private static final int height = 100;
    private static final int health = 1000;
    private static final int armor = 1500;
    private static final Weapon weapon = new LaserCannon(100, true);
    private static final int velocity = 1;

    public BlackViper(int x, int y) {
        super(name, x, y, width, height, Assets.blackViperImage, health, armor, weapon, velocity);
        this.setCoins(500);
    }
}
