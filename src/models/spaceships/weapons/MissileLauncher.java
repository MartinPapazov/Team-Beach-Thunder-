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
            Bullet firstMissile = new Missile(x, y, this.shootingRight);
            this.addBullet(firstMissile);
            Bullet secondMissile = new Missile(x, y + 40, this.shootingRight);
            this.addBullet(secondMissile);
            this.cooldownCounter = 0;
        }
    }
}
