package models.spaceships.weapons;

import audio.AudioAssets;
import models.spaceships.weapons.bullets.BlueLaser;
import models.spaceships.weapons.bullets.Bullet;
import models.spaceships.weapons.bullets.RedLaser;
import sun.audio.AudioPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Double Double Laser
public class DDLaser extends Weapon implements ActionListener {
    //Positions where bullets will be launch
    private final int yBlueLazer1;
    private final int yBlueLazer2;
    private final int yRedLazer1;
    private final int yRedLazer2;
    private Timer redLazersShootTimer;
    private int currentX;
    private int currentY;

    public DDLaser(int cooldown, boolean shootingRight, int yBLazer1, int yBLazer2, int yRLazer1, int yRLazer2) {
        super(cooldown, shootingRight, 0);
        this.redLazersShootTimer = new Timer(2000, this);
        this.yBlueLazer1 = yBLazer1;
        this.yBlueLazer2 = yBLazer2;
        this.yRedLazer1 = yRLazer1;
        this.yRedLazer2 = yRLazer2;
    }

    @Override
    public void shoot(int x, int y) {
        this.currentX = x;
        this.currentY = y;
        if (this.cooldownCounter >= this.cooldown) {
            AudioPlayer.player.start(AudioAssets.getSpaceshipBigLasserOneAudiInputStream());
            Bullet laser1 = new BlueLaser(this.currentX, this.currentY + yBlueLazer1, this.shootingRight);
            Bullet laser2 = new BlueLaser(this.currentX, this.currentY + yBlueLazer2, this.shootingRight);
            this.addBullet(laser1);
            this.addBullet(laser2);
            redLazersShootTimer.start();
            this.cooldownCounter = 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AudioPlayer.player.start(AudioAssets.getSpaceshipBigLasserOneAudiInputStream());
        Bullet laser1 = new RedLaser(this.currentX, this.currentY + yRedLazer1, this.shootingRight);
        Bullet laser2 = new RedLaser(this.currentX, this.currentY + yRedLazer2, this.shootingRight);
        this.addBullet(laser1);
        this.addBullet(laser2);
    }
}