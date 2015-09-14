package models.spaceships.weapons;

import models.spaceships.weapons.bullets.Bullet;
import models.spaceships.weapons.bullets.BulletType;
import models.spaceships.weapons.bullets.GreenLaser;
import models.spaceships.weapons.bullets.RedLaser;

public class LaserLauncher extends Weapon{

    private BulletType lastBulletShot;

    public LaserLauncher(int cooldown, boolean shootingRight) {
        super(cooldown, shootingRight);
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            Bullet bullet;
            if (this.lastBulletShot == BulletType.GreenLaser) {
                bullet = new RedLaser(x, y, this.shootingRight);
                this.lastBulletShot = BulletType.RedLaser;
            } else {
                bullet = new GreenLaser(x, y, this.shootingRight);
                this.lastBulletShot = BulletType.GreenLaser;
            }

            this.addBullet(bullet);
            this.cooldownCounter = 0;
        }
    }
}
