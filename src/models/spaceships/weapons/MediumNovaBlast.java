package models.spaceships.weapons;

import audio.AudioAssets;
import models.spaceships.weapons.bullets.Bullet;
import models.spaceships.weapons.bullets.MediumNova;
import sun.audio.AudioPlayer;

public class MediumNovaBlast extends Weapon {

    public MediumNovaBlast(int cooldown, boolean shootingRight) {
        super(cooldown, shootingRight);
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            AudioPlayer.player.start(AudioAssets.getSpaceshipLasserFourAudiInputStream());
            Bullet bullet = new MediumNova(x + 20, y + 40, this.shootingRight);
            this.addBullet(bullet);
            this.cooldownCounter = 0;
        }
    }
}