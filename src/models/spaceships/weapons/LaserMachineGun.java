package models.spaceships.weapons;

import audio.AudioAssets;
import models.spaceships.weapons.bullets.Bullet;
import models.spaceships.weapons.bullets.FireLaser;
import sun.audio.AudioPlayer;

public class LaserMachineGun extends Weapon{

    private int count;

    public LaserMachineGun(int cooldown, boolean shootingRight) {
        super(cooldown, shootingRight);
        this.count = 0;
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            if (this.count > 3) {
                this.count = 0;
            }

            AudioPlayer.player.start(AudioAssets.getSpaceshipLasserThreeAudiInputStream());
            Bullet bullet;
             switch (this.count){
                 case 0:
                     bullet = new FireLaser(x - 5, y, this.shootingRight);
                     break;
                 case 1:
                     bullet = new FireLaser(x, y + 55, this.shootingRight);
                     break;
                 case 2:
                     bullet = new FireLaser(x, y + 15, this.shootingRight);
                     break;
                 case 3:
                     bullet = new FireLaser(x, y + 35, this.shootingRight);
                     break;
                 default:
                     bullet = new FireLaser(x, y , this.shootingRight);
                     break;
             }
             this.count++;
            this.addBullet(bullet);
            this.cooldownCounter = 0;
        }
    }
}
