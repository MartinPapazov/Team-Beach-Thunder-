package models.spaceships.weapons.bullets;

import graphics.Assets;

import java.awt.image.BufferedImage;


public class Missile extends Bullet {

    private static final String name = "Missle";
    private static final int width = 25;
    private static final int height = 15;
    private static final int damage = 200;
    private static final int speed = 5;

    public Missile(int x, int y, boolean flyingRight) {
        super(name, x, y, width, height, Assets.missileImage, damage, speed, flyingRight);
    }


}
