package models.spaceships.playerSpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.PDDLaser;
import models.spaceships.weapons.Weapon;

public class RedHover extends Spaceship {

    private static final String name = "Red Hover";
    private static final int width = 110;
    private static final int height = 100;
    private static final int health = 1000;
    private static final int armor = 800;
    private static final Weapon weapon = new PDDLaser(100, true, 50, 20, 60, 30, 50);
    private static final int velocity = 4;

    public RedHover(int x, int y) {
        super(name, x, y, width, height, Assets.redHover, health, armor, weapon, velocity);
        this.setCoins(1700);
    }
}