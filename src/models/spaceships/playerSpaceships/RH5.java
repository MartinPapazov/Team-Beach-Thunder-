package models.spaceships.playerSpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.LaserCannon;
import models.spaceships.weapons.LaserMachineGun;
import models.spaceships.weapons.Weapon;
import models.spaceships.weapons.bullets.FireLaser;

public class RH5 extends Spaceship {

    private static final String name = "RH5";
    private static final int width = 90;
    private static final int height = 70;
    private static final int health = 1500;
    private static final int armor = 1600;
    private static final Weapon weapon = new LaserMachineGun(10, true);
    private static final int velocity = 6;

    public RH5(int x, int y) {
        super(name, x, y, width, height, Assets.RH5SpaceshipImage, health, armor, weapon, velocity);
    }
}
