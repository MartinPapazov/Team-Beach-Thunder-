package models.spaceships.weapons.bullets;

import Utilitys.Constants;
import models.GameObject;
import models.spaceships.Spaceship;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Bullet extends GameObject {

    private int damage;
    private int speed;
    private boolean flyingRight;
    private boolean isActive;

    public Bullet(String name, int x, int y, int width, int height, BufferedImage objectImage, int damage, int speed, boolean flyingRight) {
        super(name, x, y, width, height, objectImage);
        this.damage = damage;
        this.speed = speed;
        this.flyingRight = flyingRight;
        this.isActive = true;
    }

    public boolean getStatus() {
        return isActive;
    }

    public int getDamage() {
        return this.damage;
    }

    public void update() {
        if (isActive) {
            if (flyingRight) {
                this.setX(this.getX() + this.speed);
            } else {
                this.setX(this.getX() - this.speed);
            }

            boolean outOfBounds = this.getX() + this.getWidth() >= Constants.WindowWidth - 10 || this.getX() <= 10;
            if (outOfBounds) {
                this.isActive = false;
            }
        }
    }

    public void render(Graphics graphics) {
          graphics.drawImage(this.getObjectImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }

    public void checkForClash(Spaceship spaceship) {
        if (spaceship.isDestroyed() || spaceship.isExploding() || !this.isActive){
            return;
        }

        if (spaceship.getBoundingBox().contains(this.getBoundingBox()) ||
                this.getBoundingBox().contains(spaceship.getBoundingBox())) {
            spaceship.hit(this.damage);
            this.isActive = false;
        }
    }
}
