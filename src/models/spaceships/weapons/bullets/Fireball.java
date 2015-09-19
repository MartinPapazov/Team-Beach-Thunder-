package models.spaceships.weapons.bullets;

import graphics.Assets;

public class Fireball extends Bullet {
    private static final String name = "Fireball";
    private static final int width = 40;
    private static final int height = 15;
    private static final int damage = 300;
    private static final int speed = 3;

    public Fireball(int x, int y, boolean flyingRight) {
        super(name, x, y, width, height, Assets.flameStrikeImage, damage, speed, flyingRight);
    }
}