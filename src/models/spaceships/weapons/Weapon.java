package models.spaceships.weapons;

import models.spaceships.weapons.bullets.Bullet;

import java.awt.*;
import java.util.ArrayList;

public abstract class Weapon {

    private ArrayList<Bullet>  bulletsFired;
    protected int cooldown;
    protected int cooldownCounter;
    protected boolean shootingRight;


    protected Weapon(int cooldown, boolean shootingRight) {
        this.bulletsFired = new ArrayList<>();
        this.cooldown = cooldown;
        this.cooldownCounter = cooldown;
        this.shootingRight = shootingRight;
    }

    public ArrayList<Bullet> getBulletsFired() {
        return this.bulletsFired;
    }

    public int getDamage() {
        //TODO: Get damage from all bullets, calculate and return.
        return 0;
    }
    public abstract void shoot(int y, int x);


    public void update() {
        this.cooldownCounter++;
        for (int i = 0; i < bulletsFired.size(); i++) {
            this.bulletsFired.get(i).update();
        }
        this.checkForUnneededBullets();
    }

    public void render(Graphics graphics) {
        for (int i = 0; i < bulletsFired.size(); i++) {
            this.bulletsFired.get(i).render(graphics);
        }
    }

    protected void addBullet(Bullet bullet) {
        this.bulletsFired.add(bullet);
    }

    private void checkForUnneededBullets() {
        ArrayList<Bullet> activeBullets = new ArrayList<>();
        for (int i = 0; i < this.bulletsFired.size(); i++) {
            Bullet bullet = this.bulletsFired.get(i);
            if (bullet.getStatus()) {
                activeBullets.add(bullet);
            }
        }

        this.bulletsFired = activeBullets;

    }


}
