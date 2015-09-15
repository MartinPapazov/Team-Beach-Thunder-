package models.spaceships.weapons.bullets;

import graphics.Assets;

public class BlueLaser extends Bullet {
    private static final String name = "RedLaser";
    private static final int width = 40;
    private static final int height = 15;
    private static final int damage = 32;
    private static final int speed = 6;

    public BlueLaser(int x, int y, boolean flyingRight) {
        super(name, x, y, width, height, Assets.blueLaserImge, damage, speed, flyingRight);
    }
}
