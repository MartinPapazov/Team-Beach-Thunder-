package models.spaceships.enemySpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.LaserCannon;

public class BlueShip extends Spaceship {
    private static final String BlueShipName = "Blue Ship";
    private static final int BlueShipWidth = 100;
    private static final int BlueShipHeight = 100;
    private static final int BlueShipHealth = 500;
    private static final int BlueShipArmor = 1000;
    private static final int BlueShipVelocity = 1;

    public BlueShip(int x, int y, int cooldown) {
        super(BlueShipName, x, y, BlueShipWidth,
                BlueShipHeight, Assets.blueShipImage,
                BlueShipHealth, BlueShipArmor,
                new LaserCannon(cooldown, false),
                BlueShipVelocity);
    }
}