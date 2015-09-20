package models.spaceships.weapons;

import audio.AudioAssets;
import models.spaceships.weapons.bullets.Bullet;
import models.spaceships.weapons.bullets.RedLaser;
import sun.audio.AudioPlayer;

public class RedLazerShoot extends Weapon {
    private final int yLazer;

    public RedLazerShoot(int cooldown, boolean shootingRight, int yRedLazer) {
        super(cooldown, shootingRight);
        this.yLazer = yRedLazer;
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            AudioPlayer.player.start(AudioAssets.getSpaceshipLasserOneAudiInputStream());
            Bullet lazer = new RedLaser(x, y + this.yLazer, this.shootingRight);
            this.addBullet(lazer);
            this.cooldownCounter = 0;
        }
    }
}