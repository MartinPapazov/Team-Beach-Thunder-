package models.spaceships;

import audio.AudioAssets;
import contracts.Informational;
import graphics.Assets;
import graphics.SpriteSheetAnimation;
import models.GameObject;
import models.spaceships.weapons.Weapon;
import sun.audio.AudioPlayer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public abstract class Spaceship extends GameObject implements Informational{

    private final SpriteSheetAnimation blowingAnimation;

    private int health;
    private int armor;
    private Weapon weapon;
    private int velocity;
    private int coins;
    private boolean explode;
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
        this.weapon = weapon;
        this.velocity = velocity;
        this.setIsMovingLeft(false);
        this.setIsMovingRight(false);
        this.setIsMovingDown(false);
        this.setIsMovingUp(false);
        this.setIsExploding(false);
        this.setIsDestroyed(false);
        this.blowingAnimation = new SpriteSheetAnimation(Assets.explosionImage, 0, 0, 100, 100, 81, 50, false);
        this.explode = true;
        this.coins = 200;
    }


    public Weapon getWeapon() {

        return this.weapon;
    }


    public void setWeapon(Weapon weapon) {

        this.weapon = weapon;
    }

    public int getHealth() {

        return this.health;
    }

    public void setHeath(int health) {

        this.health = health;
    }

    public int getArmor() {

        return this.armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getVelocity() {

        return this.velocity;
    }

    public void setVelocity(int velocity) {

        this.velocity = velocity;
    }


    public boolean isMovingRight() {

        return isMovingRight;
    }

    public void setIsMovingRight(boolean isMovingRight) {

        this.isMovingRight = isMovingRight;
    }

    public boolean isExploding() {

        return isExploding;
    }

    public void setIsExploding(boolean isExploding) {

        this.isExploding = isExploding;
    }

    public boolean isDestroyed() {

        return isDestroyed;
    }

    public void setIsDestroyed(boolean isDestroyed) {

        this.isDestroyed = isDestroyed;
    }

    public boolean isMovingLeft() {

        return isMovingLeft;
    }

    public void setIsMovingLeft(boolean isMovingLeft) {

        this.isMovingLeft = isMovingLeft;
    }

    public boolean isMovingUp() {

        return isMovingUp;
    }

    public void setIsMovingUp(boolean isMovingUp) {

        this.isMovingUp = isMovingUp;
    }

    public boolean isMovingDown() {

        return isMovingDown;
    }

    public void setIsMovingDown(boolean isMovingDown) {

        this.isMovingDown = isMovingDown;
    }

    private void setCoins(int coins) {
        this.coins = coins;
    }

    public int getCoins() {
        return this.coins;
    }



    public void fire() {
        this.weapon.shoot(this.getX(), this.getY());
    }

    public void hit(int damage) {
        if (this.armor > 0) {
            this.armor -= damage;
        }

        if (this.armor <= 0) {
            this.armor = 0;
            this.health -= damage;
            if (this.health <= 0) {
                if (this.explode) {
                    AudioPlayer.player.start(AudioAssets.getExplosionAudio());
                    this.explode = false;
                }

                this.isExploding = true;
            }
        }
    }

    public Map<String, String> getInformationAboutObject() {
        String name = this.getName();
        String health = Integer.toString(this.getHealth());
        String armor = Integer.toString(this.getArmor());
        String damage = Integer.toString(this.getWeapon().getDamage());
        String speed = Integer.toString(this.getVelocity());
        Map<String, String> info = new LinkedHashMap<>();
        info.put("Name:", name);
        info.put("Health:", health);
        info.put("Armor:", armor);
        info.put("Damage:", damage);
        info.put("Speed:", speed);
        return info;
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
                this.weapon.render(graphics);
                graphics.drawImage(this.getObjectImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
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
