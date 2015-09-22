package models.spaceships.weapons;

import audio.AudioAssets;
import models.spaceships.weapons.bullets.*;
import sun.audio.AudioPlayer;

public class TripleDoubleShoot extends Weapon {
    //Positions where bullets will be launch
    private final int yGreenLaser1;
    private final int yGreenLaser2;
    private final int yRedLaser1;
    private final int yRedLaser2;
    private final int xLaser;
    private BulletType nextBulletShot;

    public TripleDoubleShoot(int cooldown, boolean shootingRight, int xLaser, int yGLaser1, int yGLaser2, int yRLaser1, int yRLaser2) {
        super(cooldown, shootingRight, 0);
        this.yGreenLaser1 = yGLaser1;
        this.yGreenLaser2 = yGLaser2;
        this.yRedLaser1 = yRLaser1;
        this.yRedLaser2 = yRLaser2;
        this.xLaser = xLaser;
        this.nextBulletShot = BulletType.RedLaser;
    }

    @Override
    public void shoot(int x, int y) {
        if (this.cooldownCounter >= this.cooldown) {
            if (this.nextBulletShot == BulletType.RedLaser) {
                AudioPlayer.player.start(AudioAssets.getSpaceshipBigLasserOneAudiInputStream());
                Bullet redLaser1 = new RedLaser(x + xLaser, y + this.yRedLaser1, this.shootingRight);
                Bullet redLaser2 = new RedLaser(x + xLaser, y + this.yRedLaser2, this.shootingRight);
                this.addBullet(redLaser1);
                this.addBullet(redLaser2);
                this.nextBulletShot = BulletType.GreenLaser;
            } else if (this.nextBulletShot == BulletType.GreenLaser) {
                AudioPlayer.player.start(AudioAssets.getSpaceshipBigLasserOneAudiInputStream());
                Bullet greenLaser1 = new GreenLaser(x + xLaser, y + yGreenLaser1, this.shootingRight);
                Bullet greenLaser2 = new GreenLaser(x + xLaser, y + yGreenLaser2, this.shootingRight);
                this.addBullet(greenLaser1);
                this.addBullet(greenLaser2);
                this.nextBulletShot = BulletType.MediumNova;
            } else {
                AudioPlayer.player.start(AudioAssets.getSpaceshipLasserFourAudiInputStream());
                Bullet nova1 = new MediumNova(x + xLaser, y + yGreenLaser1, this.shootingRight);
                Bullet nova2 = new MediumNova(x + xLaser, y + yGreenLaser2, this.shootingRight);
                this.addBullet(nova1);
                this.addBullet(nova2);
                this.nextBulletShot = BulletType.RedLaser;
            }

            this.cooldownCounter = 0;
        }
    }
}