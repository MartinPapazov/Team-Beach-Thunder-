package models;

import java.awt.image.BufferedImage;

public abstract class GameObject {

    private int x;
    private int y;
    private int width;
    private int height;

    private BufferedImage objectImage;


    public GameObject(int x, int y, int width, int height, BufferedImage objectImage) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.objectImage = objectImage;
    }


}
