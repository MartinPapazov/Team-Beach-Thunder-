package models.spaceships.weapons;

import models.spaceships.Spaceship;
import models.spaceships.weapons.bullets.Bullet;

import java.awt.*;
import java.util.ArrayList;

public abstract class Weapon {

    private ArrayList<Bullet>  bulletsFired;
    protected int cooldown;
    protected int cooldownCounter;


    protected Weapon(int cooldown) {
        this.bulletsFired = new ArrayList<>();
        this.cooldown = cooldown;
        this.cooldownCounter = cooldown;
    }

    public ArrayList<Bullet> getBulletsFired() {
        return this.bulletsFired;
    }

    public abstract void shoot(int y, int x);

    public void update() {
        this.cooldownCounter++;
        for (int i = 0; i < bulletsFired.size(); i++) {
             this.bulletsFired.get(i).update();

        }
    }

    public void render(Graphics graphics) {
        for (int i = 0; i < bulletsFired.size(); i++) {
            this.bulletsFired.get(i).render(graphics);
        }
    }

    protected void addBullet(Bullet bullet) {
        this.bulletsFired.add(bullet);
    }
}
