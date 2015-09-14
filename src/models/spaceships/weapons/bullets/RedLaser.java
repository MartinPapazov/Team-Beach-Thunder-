package models.spaceships.weapons.bullets;

import graphics.Assets;

public class RedLaser extends Bullet {

    private static final String name = "RedLaser";
    private static final int width = 40;
    private static final int height = 15;
    private static final int damage = 50;
    private static final int speed = 5;

    public RedLaser(int x, int y, boolean flyingRight) {
        super(name, x, y, width, height, Assets.redLaserImage, damage, speed, flyingRight);
    }
}
