package models.spaceships.weapons;

import audio.AudioAssets;
import models.spaceships.weapons.bullets.*;

public class PDDLaser extends Weapon {
    //Positions where bullets will be launch
    private final int yGreenLaser1;
    private final int yGreenLaser2;
    private final int yRedLaser1;
    private final int yRedLaser2;
    private final int xLaser;
    private BulletType lastBulletShot;

    public PDDLaser(int cooldown, boolean shootingRight, int xLaser, int yGLaser1, int yGLaser2, int yRLaser1, int yRLaser2) {
        super(cooldown, shootingRight);
        this.yGreenLaser1 = yGLaser1;
        this.yGreenLaser2 = yGLaser2;
        this.yRedLaser1 = yRLaser1;
        this.yRedLaser2 = yRLaser2;
        this.xLaser = xLaser;
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            if (this.lastBulletShot == BulletType.GreenLaser) {
                // AudioPlayer.player.start(AudioAssets.getSpaceshipLasserFourAudiInputStream());
                Bullet redLaser1 = new RedLaser(x + xLaser, y + this.yRedLaser1, this.shootingRight);
                Bullet redLaser2 = new RedLaser(x + xLaser, y + this.yRedLaser2, this.shootingRight);
                this.addBullet(redLaser1);
                this.addBullet(redLaser2);
                this.lastBulletShot = BulletType.RedLaser;
            } else {
                // AudioPlayer.player.start(AudioAssets.getSpaceshipLasserFourAudiInputStream());
                Bullet greenLaser1 = new GreenLaser(x + xLaser, y + yGreenLaser1, this.shootingRight);
                Bullet greenLaser2 = new GreenLaser(x + xLaser, y + yGreenLaser2, this.shootingRight);
                this.addBullet(greenLaser1);
                this.addBullet(greenLaser2);
                this.lastBulletShot = BulletType.GreenLaser;
            }

            this.cooldownCounter = 0;
        }
    }
}