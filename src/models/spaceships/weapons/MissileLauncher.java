package models.spaceships.weapons;

import audio.AudioAssets;
import models.spaceships.weapons.bullets.Bullet;
import models.spaceships.weapons.bullets.Missile;
import sun.audio.AudioPlayer;

public class MissileLauncher extends Weapon {

    public MissileLauncher(int cooldown, boolean shootingRight) {
        super(cooldown, shootingRight, 700);
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            AudioPlayer.player.start(AudioAssets.getMissleOneSound());
            Bullet firstMissile = new Missile(x, y, this.shootingRight);
            this.addBullet(firstMissile);
            Bullet secondMissile = new Missile(x, y + 40, this.shootingRight);
            this.addBullet(secondMissile);
            this.cooldownCounter = 0;
        }
    }
}
