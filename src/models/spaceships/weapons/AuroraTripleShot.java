package models.spaceships.weapons;

import audio.AudioAssets;
import models.spaceships.weapons.bullets.AuroraTear;
import models.spaceships.weapons.bullets.Bullet;
import sun.audio.AudioPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AuroraTripleShot extends Weapon implements ActionListener {

    private Timer tripleShootTimer;
    private int currentX;
    private int currentY;
    private int shootCounter;

    public AuroraTripleShot(int cooldown, boolean shootingRight) {
        super(cooldown, shootingRight);
        this.tripleShootTimer = new Timer(200, this);
    }

    @Override
    public void shoot(int x, int y) {
        this.currentX = x;
        this.currentY = y;
        if (this.cooldownCounter >= this.cooldown) {
            tripleShootTimer.start();
            AudioPlayer.player.start(AudioAssets.getSpaceshipBigLasserOneAudiInputStream());

            this.cooldownCounter = 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Bullet tear = new AuroraTear(this.currentX, this.currentY + 18, this.shootingRight);
        this.addBullet(tear);
        shootCounter++;
        if (shootCounter == 3) {
            shootCounter = 0;
            this.tripleShootTimer.stop();
        }
    }
}