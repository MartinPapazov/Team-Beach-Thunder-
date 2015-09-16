package models.spaceships.weapons.bullets;

import graphics.Assets;

public class FireLaser extends Bullet {

    private static final String name = "Fire Laser";
    private static final int width = 50;
    private static final int height = 10;
    private static final int damage = 60;
    private static final int speed = 7;

    public FireLaser(int x, int y, boolean flyingRight) {
        super(name, x, y, width, height, Assets.fireLaserImage, damage, speed, flyingRight);
    }

}
