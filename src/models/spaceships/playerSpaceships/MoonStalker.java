package models.spaceships.playerSpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.PDDLaser;
import models.spaceships.weapons.Weapon;

public class MoonStalker extends Spaceship {

    private static final String name = "Moon Stalker";
    private static final int width = 120;
    private static final int height = 100;
    private static final int health = 2500;
    private static final int armor = 1200;
    private static final Weapon weapon = new PDDLaser(100, true, 50, 20, 60, 30, 50);
    private static final int velocity = 2;

    public MoonStalker(int x, int y) {
        super(name, x, y, width, height, Assets.moonStalkerImage, health, armor, weapon, velocity);
        this.setCoins(1200);
    }
}