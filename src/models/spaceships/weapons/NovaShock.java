package models.spaceships.weapons;

import audio.AudioAssets;
import models.spaceships.weapons.bullets.Bullet;
import models.spaceships.weapons.bullets.NovaImpulse;
import sun.audio.AudioPlayer;

public class NovaShock extends Weapon {

    public NovaShock(int cooldown, boolean shootingRight) {
        super(cooldown, shootingRight);
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            AudioPlayer.player.start(AudioAssets.getSpaceshipLasserOneAudiInputStream());
            Bullet leftImpulse = new NovaImpulse(x + 10, y + 20, this.shootingRight);
            Bullet rightImpulse = new NovaImpulse(x + 10, y + 60, this.shootingRight);
            this.addBullet(leftImpulse);
            this.addBullet(rightImpulse);
            this.cooldownCounter = 0;
        }
    }
}