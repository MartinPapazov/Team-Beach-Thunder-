package models.spaceships.weapons.bullets;

import graphics.Assets;

public class SuperNova extends Bullet {

    private static final String name = "Super Nova";
    private static final int width = 40;
    private static final int height = 40;
    private static final int damage = 200;
    private static final int speed = 6;

    public SuperNova(int x, int y, boolean flyingRight) {
        super(name, x, y, width, height, Assets.superNovaImage, damage, speed, flyingRight);
    }
}