package models.spaceships.weapons;

import models.spaceships.weapons.bullets.Bullet;
import models.spaceships.weapons.bullets.SuperNova;

public class SuperNovaShoot extends Weapon {
    private final int yNova;
    private final int xNova;

    public SuperNovaShoot(int cooldown, boolean shootingRight, int xNova, int yNova) {
        super(cooldown, shootingRight);
        this.yNova = yNova;
        this.xNova = xNova;
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            Bullet bullet = new SuperNova(x + xNova, y + yNova, shootingRight);
            this.addBullet(bullet);
            this.cooldownCounter = 0;
        }
    }
}