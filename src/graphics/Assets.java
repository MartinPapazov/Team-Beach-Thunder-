package graphics;

import audio.AudioLoader;
import jdk.internal.util.xml.impl.Input;
import sun.audio.AudioData;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Assets {

    public static BufferedImage explosionImage;
    public static BufferedImage backgroundImage;
    public static BufferedImage levelOneBackground;


    //Player spaceships
    public static BufferedImage spacecruiserImage;
    public static BufferedImage blackViperImage;

    //Enemy spaceships
    public static BufferedImage deathbringerImage;

    //Bullets
    public static BufferedImage missileImage;
    public static BufferedImage redLaserImage;
    public static BufferedImage greenLaserImage;
    public static BufferedImage blueLaserImge;



    public static void initialization() {
        SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/images/laserSpriteSheet.png"));

        //Images
        backgroundImage = ImageLoader.loadImage("/images/MenuWallpaper.jpg");
        explosionImage = ImageLoader.loadImage("/images/ExplosionSpriteSheet.png");
        spacecruiserImage = ImageLoader.loadImage("/images/Spacecruiser.png");
        missileImage = ImageLoader.loadImage("/images/missile.png");
        levelOneBackground =  ImageLoader.loadImage("/images/LevelOneBackground.jpg");
        deathbringerImage =  ImageLoader.loadImage("/images/Deathbringer.png");
        redLaserImage = spriteSheet.crop(0, 224, 256, 16);
        greenLaserImage = spriteSheet.crop(0, 304, 256, 16);
        blackViperImage = ImageLoader.loadImage("/images/BlackViper.png");
        blueLaserImge = spriteSheet.crop(0, 128, 256, 16);



    }


}
