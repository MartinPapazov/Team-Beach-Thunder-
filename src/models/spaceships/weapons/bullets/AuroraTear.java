package models.spaceships.weapons.bullets;

import graphics.Assets;

public class AuroraTear extends Bullet {
    private static final String name = "Aurora Tear";
    private static final int width = 40;
    private static final int height = 15;
    private static final int damage = 150;
    private static final int speed = 6;

    public AuroraTear(int x, int y, boolean flyingRight) {
        super(name, x, y, width, height, Assets.auroraTearImage, damage, speed, flyingRight);
    }
}