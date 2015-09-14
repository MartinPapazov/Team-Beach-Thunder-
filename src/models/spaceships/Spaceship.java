package models.spaceships;

import graphics.Assets;
import graphics.SpriteSheetAnimation;
import models.GameObject;
import models.spaceships.weapons.Weapon;

import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class Spaceship extends GameObject{

    private final SpriteSheetAnimation blowingAnimation;
    private int count;

    private int health;
    private int armor;
    private int maxArmor;
    private Weapon weapon;
    private int velocity;

    public boolean isExploding;
    public boolean isDestroyed;
    public boolean isMovingLeft;
    public boolean isMovingRight;
    public boolean isMovingUp;
    public boolean isMovingDown;

    protected Spaceship(String name, int x, int y, int width, int height, BufferedImage objectImage,
                      int health, int armor, Weapon weapon, int velocity) {
        super(name, x, y, width, height, objectImage);


        this.health = health;
        this.armor = armor;
        this.maxArmor = armor;
        this.weapon = weapon;
        this.velocity = velocity;
        this.isMovingLeft = false;
        this.isMovingRight = false;
        this.isMovingUp = false;
        this.isMovingDown = false;
        this.isExploding = false;
        this.isDestroyed = false;
        this.blowingAnimation = new SpriteSheetAnimation(Assets.explosionImage, 0, 0, 100, 100, 81, 200, false);
    }

    public Weapon getWeapon(){
        return this.weapon;
    }

    public int getHealth() {
        return this.health;
    }

    public int getArmor() {
        return this.armor;
    }

    public void fire() {
        this.weapon.shoot(this.getX(), this.getY());
    }

    public void hit(int damage) {
        this.armor -= damage;
        if (this.armor <= 0) {
            this.health -= damage;
            if (this.health <= 0) {
                this.isExploding = true;
                this.count = 0;
            }
        }
    }

    public void update() {
        if (this.isDestroyed || this.isExploding) {
            return;
        }
        this.move();
    }

    public void render(Graphics graphics) {
        if (!isDestroyed) {
            if (isExploding) {
                BufferedImage image = blowingAnimation.animationCrop();
                graphics.drawImage(image, this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
                 if (image == null){
                     this.isDestroyed = true;
                 }

            } else {
                graphics.drawImage(this.getObjectImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
                this.weapon.render(graphics);
            }
        }
    }

        private void move() {
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


}
