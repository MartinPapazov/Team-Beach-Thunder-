package models.spaceships.weapons.bullets;

import models.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Bullet extends GameObject {

    public Bullet(String name, int x, int y, int width, int height, BufferedImage objectImage) {
        super(name, x, y, width, height, objectImage);
    }

    public void update() {

    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.getObjectImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }
}
