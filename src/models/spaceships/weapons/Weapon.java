package models.spaceships.weapons;

import models.spaceships.weapons.bullets.Bullet;

import java.awt.*;
import java.util.ArrayList;

public abstract class Weapon {

    private Bullet bullet;
    private ArrayList<Bullet>  bulletsFired;
    private int speed;
    private int cooldown;

    protected Weapon(Bullet bullet, int speed, int cooldown) {
        this.bulletsFired = new ArrayList<>();
        this.bullet = bullet;
        this.speed = speed;
        this.cooldown = cooldown;
    }
    public abstract void shoot();

    public void update() {
        for (int i = 0; i < bulletsFired.size(); i++) {
             this.bulletsFired.get(i).update();
        }
    }

    public void render(Graphics graphics) {
        for (int i = 0; i < bulletsFired.size(); i++) {
            this.bulletsFired.get(i).render(graphics);
        }
    }
}
