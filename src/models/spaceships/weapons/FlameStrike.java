package models.spaceships.weapons;

import audio.AudioAssets;
import models.spaceships.weapons.bullets.*;
import sun.audio.AudioPlayer;

public class FlameStrike extends Weapon{

    public FlameStrike(int cooldown, boolean shootingRight) {
        super(cooldown, shootingRight, 0);
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            AudioPlayer.player.start(AudioAssets.getSpaceshipLasserFourAudiInputStream());
            Bullet bullet = new Fireball(x + 20, y + 40, this.shootingRight);
            this.addBullet(bullet);
            this.cooldownCounter = 0;
        }
    }
}