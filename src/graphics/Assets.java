package graphics;


import java.awt.image.BufferedImage;

public class Assets {

    private static SpriteSheetAnimation spaceShipExplodingAnimation;

    public static BufferedImage backgroundImage;
    public static BufferedImage testingSpaceshipImage;

    public static BufferedImage getCurrentExplosionAnimtionImage() {
        return spaceShipExplodingAnimation.animationCrop();
    }


    public static void initialization() {
        backgroundImage = ImageLoader.loadImage("/images/MenuWallpaper.jpg");
        testingSpaceshipImage = ImageLoader.loadImage("/images/spaceship.png");
        BufferedImage explosionImage = ImageLoader.loadImage("/images/ExplosionSpriteSheet.png");
        spaceShipExplodingAnimation = new SpriteSheetAnimation(explosionImage, 0, 0, 100, 100, 81, 20);
    }


}
