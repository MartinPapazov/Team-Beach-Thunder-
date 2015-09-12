package graphics;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage explosionImage;
    public static BufferedImage backgroundImage;

    //Spaceships
    public static BufferedImage spacecruiserImage;

    //Bullets
    public static BufferedImage missileImage;

    //Testing
    public static BufferedImage testingSpaceshipImage;


    public static void initialization() {
        backgroundImage = ImageLoader.loadImage("/images/MenuWallpaper.jpg");
        testingSpaceshipImage = ImageLoader.loadImage("/images/spaceship.png");
        explosionImage = ImageLoader.loadImage("/images/ExplosionSpriteSheet.png");
        spacecruiserImage = ImageLoader.loadImage("/images/Spacecruiser.png");
        missileImage = ImageLoader.loadImage("/images/missile.png");
    }


}
