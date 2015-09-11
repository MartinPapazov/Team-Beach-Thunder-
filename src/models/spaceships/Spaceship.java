package models.spaceships;

import graphics.Assets;
import models.GameObject;
import models.spaceships.armors.Armor;
import models.spaceships.weapons.Weapon;

import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class Spaceship extends GameObject{

    private int health;
    private Armor armor;
    private Weapon weapon;
    private int velocity;

    public boolean isExploding;
    public boolean isDestroyed;
    public boolean isMovingLeft;
    public boolean isMovingRight;
    public boolean isMovingUp;
    public boolean isMovingDown;

    protected Spaceship(String name, int x, int y, int width, int height, BufferedImage objectImage,
                      int health, Armor armor, Weapon weapon, int velocity) {
        super(name, x, y, width, height, objectImage);

        this.health = health;
        this.armor = armor;
        this.weapon = weapon;
        this.velocity = velocity;
        this.isMovingLeft = false;
        this.isMovingRight = false;
        this.isMovingUp = false;
        this.isMovingDown = false;
        this.isExploding = false;
        this.isDestroyed = false;
    }

    public void fire() {
        this.weapon.shoot();
    }

    public void hit(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.isExploding = true;
        }
    }

    public void update() {
        if (this.isMovingUp){
            this.setY(this.getY() - this.velocity);
        }

        if (this.isMovingDown){
            this.setY(this.getY() + this.velocity);
        }

        if (this.isMovingLeft){
            this.setX(this.getX() - this.velocity);
        }

        if (this.isMovingRight){
            this.setX(this.getX() + this.velocity);
        }

        this.updateBoundingBox();
        this.weapon.update();
    }

    public void render(Graphics graphics) {
        if (isExploding){
            BufferedImage currentAnimationImage = Assets.getCurrentExplosionAnimtionImage();
            graphics.drawImage(currentAnimationImage, this.getX(), this.getY(), this.getWidth(), this.getHeight(),null);
        } else {
            graphics.drawImage(this.getObjectImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
            this.weapon.render(graphics);
        }
    }

}
