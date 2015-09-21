package models.spaceships.playerSpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.MissileLauncher;
import models.spaceships.weapons.Weapon;

public class Spacecruiser extends Spaceship {

    private static final String name = "Spacecruiser";
    private static final int width = 70;
    private static final int height = 60;
    private static final int health = 500;
    private static final int armor = 700;
    private static final Weapon weapon = new MissileLauncher(200, true);
    private static final int velocity = 3;

    public Spacecruiser(int x, int y) {
        super(name, x, y, width, height, Assets.spacecruiserImage, health, armor, weapon, velocity);
    }
}
