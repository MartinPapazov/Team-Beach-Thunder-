package models.spaceships.playerSpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.SuperNovaShoot;
import models.spaceships.weapons.Weapon;

public class DownFighter extends Spaceship {
    private static final String name = "Down Fighter";
    private static final int width = 150;
    private static final int height = 60;
    private static final int health = 900;
    private static final int armor = 1500;
    private static final Weapon weapon = new SuperNovaShoot(100, true, 70, 8);
    private static final int velocity = 3;

    public DownFighter(int x, int y) {
        super(name, x, y, width, height, Assets.downFighterImage, health, armor, weapon, velocity);
    }
}