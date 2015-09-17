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
    public static BufferedImage RH5SpaceshipImage;

    //Enemy spaceships
    public static BufferedImage deathbringerImage;
    public static BufferedImage nightRiderImage;
    public static BufferedImage blueShipImage;

    //Bullets
    public static BufferedImage missileImage;
    public static BufferedImage redLaserImage;
    public static BufferedImage greenLaserImage;
    public static BufferedImage blueLaserImge;
    public static BufferedImage fireLaserImage;



    public static void initialization() {
        SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/images/laserSpriteSheet.png"));

        //Images
        backgroundImage = ImageLoader.loadImage("/images/MenuWallpaper.jpg");
        explosionImage = ImageLoader.loadImage("/images/ExplosionSpriteSheet.png");
        spacecruiserImage = ImageLoader.loadImage("/images/Spacecruiser.png");
        missileImage = ImageLoader.loadImage("/images/missile.png");
        levelOneBackground =  ImageLoader.loadImage("/images/LevelOneBackground.jpg");
        deathbringerImage =  ImageLoader.loadImage("/images/Deathbringer.png");
        nightRiderImage = ImageLoader.loadImage("/images/NightRaider.png");
        blueShipImage = ImageLoader.loadImage("/images/BlueShip.png"); //Crossfighter BlueShip.png
        redLaserImage = spriteSheet.crop(0, 224, 256, 16);
        greenLaserImage = spriteSheet.crop(0, 304, 256, 16);
        blackViperImage = ImageLoader.loadImage("/images/BlackViper.png");
        blueLaserImge = spriteSheet.crop(0, 128, 256, 16);
        RH5SpaceshipImage = ImageLoader.loadImage("/images/RH5.png");
        fireLaserImage = spriteSheet.crop(0, 240, 256, 16);
    }


}
