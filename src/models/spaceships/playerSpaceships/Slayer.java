package models.spaceships.playerSpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.TripleDoubleShoot;
import models.spaceships.weapons.Weapon;

public class Slayer extends Spaceship {

    private static final String name = "Slayer";
    private static final int width = 120;
    private static final int height = 100;
    private static final int health = 2500;
    private static final int armor = 1700;
    private static final Weapon weapon = new TripleDoubleShoot(100, true, 50, 20, 60, 30, 50);
    private static final int velocity = 2;

    public Slayer(int x, int y) {
        super(name, x, y, width, height, Assets.slayerImage, health, armor, weapon, velocity);
    }
}