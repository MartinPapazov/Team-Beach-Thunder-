package models;

import Utilitys.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    private String name;
    private BufferedImage objectImage;
    private int x;
    private int y;
    private int width;
    private int height;
    private Rectangle boundingBox;

    protected GameObject(String name, int x, int y, int width, int height, BufferedImage objectImage) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.objectImage = objectImage;
        this.boundingBox = new Rectangle(x, y, width, height);
    }

    public String getName() {
        return name;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }


    public BufferedImage getObjectImage() {
        return objectImage;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected void updateBoundingBox() {
        this.boundingBox.x = this.x;
        this.boundingBox.y = this.y;
    }

    protected void setX(int x) {
        if (!(x + this.width >= Constants.WindowWidth) && x > 0 ) {
            this.x = x;
        }
    }

    protected void setY(int y) {
        if (!(y + this.height >= Constants.WindowHeight) && y > 0) {
            this.y = y;
        }
    }

}
