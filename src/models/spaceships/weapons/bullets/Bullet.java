package models.spaceships.weapons.bullets;

import models.GameObject;
import models.spaceships.Spaceship;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Bullet extends GameObject {

    private int damage;
    private int speed;


    public Bullet(String name, int x, int y, int width, int height, BufferedImage objectImage, int damage, int speed) {
        super(name, x, y, width, height, objectImage);
        this.damage = damage;
        this.speed = speed;
    }

    public void update() {
        this.setX(this.getX() + this.speed);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.getObjectImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }

    public void checkForCollision(Spaceship spaceship) {
        if (spaceship.isDestroyed || spaceship.isExploding){
            return;
        }

        if (spaceship.getBoundingBox().contains(this.getBoundingBox())){
            spaceship.hit(this.damage);
        }
    }
}
