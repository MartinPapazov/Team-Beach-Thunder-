package models.spaceships.weapons;

import audio.AudioAssets;
import models.spaceships.weapons.bullets.Bullet;
import models.spaceships.weapons.bullets.RedLaser;
import sun.audio.AudioPlayer;

public class RedLaserShoot extends Weapon {
    private final int yLaser;

    public RedLaserShoot(int cooldown, boolean shootingRight, int yRedLaser) {
        super(cooldown, shootingRight, 0);
        this.yLaser = yRedLaser;
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            AudioPlayer.player.start(AudioAssets.getSpaceshipLasserOneAudiInputStream());
            Bullet laser = new RedLaser(x, y + this.yLaser, this.shootingRight);
            this.addBullet(laser);
            this.cooldownCounter = 0;
        }
    }
}