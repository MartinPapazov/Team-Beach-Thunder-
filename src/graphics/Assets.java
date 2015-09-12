package graphics;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage explosionImage;
    public static BufferedImage backgroundImage;
    public static BufferedImage testingSpaceshipImage;


    public static void initialization() {
        backgroundImage = ImageLoader.loadImage("/images/MenuWallpaper.jpg");
        testingSpaceshipImage = ImageLoader.loadImage("/images/spaceship.png");
        explosionImage = ImageLoader.loadImage("/images/ExplosionSpriteSheet.png");
    }


}
