package models.spaceships.weapons.bullets;

import graphics.Assets;

public class NovaImpulse extends Bullet {
    private static final String name = "Nova impulse";
    private static final int width = 40;
    private static final int height = 15;
    private static final int damage = 400;
    private static final int speed = 3;

    public NovaImpulse(int x, int y, boolean flyingRight) {
        super(name, x, y, width, height, Assets.novaImpulseImage, damage, speed, flyingRight);
    }
}