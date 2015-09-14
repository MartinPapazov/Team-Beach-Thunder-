package graphics;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage explosionImage;
    public static BufferedImage backgroundImage;
    public static BufferedImage levelOneBackground;


    //Player spaceships
    public static BufferedImage spacecruiserImage;

    //Enemy spaceships
    public static BufferedImage deathbringerImage;

    //Bullets
    public static BufferedImage missileImage;
    public static BufferedImage redLaserImage;
    public static BufferedImage greenLaserImage;

    //Testing
    public static BufferedImage testingSpaceshipImage;


    public static void initialization() {
        SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/images/laserSpriteSheet.png"));

        backgroundImage = ImageLoader.loadImage("/images/MenuWallpaper.jpg");
        testingSpaceshipImage = ImageLoader.loadImage("/images/spaceship.png");
        explosionImage = ImageLoader.loadImage("/images/ExplosionSpriteSheet.png");
        spacecruiserImage = ImageLoader.loadImage("/images/Spacecruiser.png");
        missileImage = ImageLoader.loadImage("/images/missile.png");
        levelOneBackground =  ImageLoader.loadImage("/images/LevelOneBackground.jpg");
        deathbringerImage =  ImageLoader.loadImage("/images/Deathbringer.png");
        redLaserImage = spriteSheet.crop(0, 224, 256 ,16);
        greenLaserImage = spriteSheet.crop(0, 304, 256, 16);
    }


}
