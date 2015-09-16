package models.spaceships.weapons;

import audio.AudioAssets;
import graphics.Assets;
import models.spaceships.weapons.bullets.BlueLaser;
import models.spaceships.weapons.bullets.Bullet;
import sun.audio.AudioPlayer;

public class LaserCannon extends Weapon {

    public LaserCannon(int cooldown, boolean shootingRight) {
        super(cooldown, shootingRight);
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            AudioPlayer.player.start(AudioAssets.getSpaceshipBigLasserOneAudiInputStream());
            Bullet bigBlueLaser1 = new BlueLaser(x, y, this.shootingRight);
            Bullet bigBlueLaser2 = new BlueLaser(x + 10, y + 20, this.shootingRight);
            Bullet bigBlueLaser3 = new BlueLaser(x + 20, y + 40, this.shootingRight);
            Bullet bigBlueLaser4 = new BlueLaser(x + 10, y + 60, this.shootingRight);
            Bullet bigBlueLaser5 = new BlueLaser(x, y + 80, this.shootingRight);
            this.addBullet(bigBlueLaser1);
            this.addBullet(bigBlueLaser2);
            this.addBullet(bigBlueLaser3);
            this.addBullet(bigBlueLaser4);
            this.addBullet(bigBlueLaser5);
            this.cooldownCounter = 0;
        }
    }
}
