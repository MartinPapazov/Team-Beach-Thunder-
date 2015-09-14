package models.spaceships.weapons;

import models.spaceships.weapons.bullets.Bullet;
import models.spaceships.weapons.bullets.Missile;

public class MissileLauncher extends Weapon {

    public MissileLauncher(int cooldown, boolean shootingRight) {
        super(cooldown, shootingRight);
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            Bullet bullet = new Missile(x, y, this.shootingRight);
            this.addBullet(bullet);
            this.cooldownCounter = 0;
        }
    }
}
