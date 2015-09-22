package graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage explosionImage;
    public static BufferedImage backgroundImage;
    public static BufferedImage levelOneBackground;
    public static BufferedImage levelTwoBackground;
    public static BufferedImage levelThreeBackground;
    public static BufferedImage levelFourBackground;
    public static BufferedImage levelFiveBackground;
    public static BufferedImage levelSixBackground;
    public static BufferedImage levelSevenBackground;
    public static BufferedImage levelEightBackground;
    public static BufferedImage levelNineBackground;
    public static BufferedImage inventoryObjectsBackground;
    public static BufferedImage inventoryBoltImage;
    public static BufferedImage padlockImage;
    public static BufferedImage statusBarImage;


    //Player spaceships
    public static BufferedImage spacecruiserImage;
    public static BufferedImage blackViperImage;
    public static BufferedImage RH5SpaceshipImage;
    public static BufferedImage downFighterImage;
    public static BufferedImage moonStalkerImage;
    public static BufferedImage slayerImage;

    //Enemy spaceships
    public static BufferedImage deathbringerImage;
    public static BufferedImage nightRiderImage;
    public static BufferedImage blueShipImage;
    public static BufferedImage littleSilverShipImage;
    public static BufferedImage dragonFighterImage;
    public static BufferedImage dragonDestroyerImage;
    public static BufferedImage dragonScoutImage;
    public static BufferedImage dragonReaperImage;

    //Bullets
    public static BufferedImage missileImage;
    public static BufferedImage redLaserImage;
    public static BufferedImage greenLaserImage;
    public static BufferedImage blueLaserImge;
    public static BufferedImage fireLaserImage;
    public static BufferedImage flameStrikeImage;
    public static BufferedImage mediumNovaImage;
    public static BufferedImage novaImpulseImage;
    public static BufferedImage auroraTearImage;
    public static BufferedImage superNovaImage;



    public static void initialization() {
        SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.loadImage("/images/laserSpriteSheet.png"));

        //Images
        backgroundImage = ImageLoader.loadImage("/images/MenuWallpaper.jpg");
        explosionImage = ImageLoader.loadImage("/images/ExplosionSpriteSheet.png");
        spacecruiserImage = ImageLoader.loadImage("/images/Spacecruiser.png");
        missileImage = ImageLoader.loadImage("/images/missile.png");
        levelOneBackground =  ImageLoader.loadImage("/images/LevelOneBackground.jpg");
        levelTwoBackground = ImageLoader.loadImage("/images/LevelTwoBackground.jpg");
        levelThreeBackground = ImageLoader.loadImage("/images/ThirdLevelBackground.jpg");
        levelFourBackground = ImageLoader.loadImage("/images/LevelFourrBackground.jpg");
        levelFiveBackground = ImageLoader.loadImage("/images/LevelFiveBackground.jpg");
        levelSixBackground = ImageLoader.loadImage("/images/LevelSixBackground.jpg");
        levelSevenBackground = ImageLoader.loadImage("/images/LevelSevenBackground.jpg");
        levelEightBackground = ImageLoader.loadImage("/images/LevelEightBackground.jpg");
        levelNineBackground = ImageLoader.loadImage("/images/LevelNineBackground.jpg");
        deathbringerImage =  ImageLoader.loadImage("/images/Deathbringer.png");
        nightRiderImage = ImageLoader.loadImage("/images/NightRaider.png");
        blueShipImage = ImageLoader.loadImage("/images/BlueShip.png");
        mediumNovaImage = ImageLoader.loadImage("/images/MediumNova.png");
        novaImpulseImage = ImageLoader.loadImage("/images/NovaImpulse.png");
        dragonFighterImage = ImageLoader.loadImage("/images/DragonFighter.png");
        dragonDestroyerImage = ImageLoader.loadImage("/images/DragonDestroyer.png");
        auroraTearImage = ImageLoader.loadImage("/images/AuroraTear.png");
        dragonScoutImage = ImageLoader.loadImage("/images/DragonScout.png");
        dragonReaperImage = ImageLoader.loadImage("/images/DragonReaper.png");
        downFighterImage = ImageLoader.loadImage("/images/DownFighter.png");
        moonStalkerImage = ImageLoader.loadImage("/images/MoonStalker.png");
        superNovaImage = ImageLoader.loadImage("/images/SuperNova.png");
        slayerImage = ImageLoader.loadImage("/images/Slayer.png");
        redLaserImage = spriteSheet.crop(0, 224, 256, 16);
        greenLaserImage = spriteSheet.crop(0, 304, 256, 16);
        blackViperImage = ImageLoader.loadImage("/images/BlackViper.png");
        blueLaserImge = spriteSheet.crop(0, 128, 256, 16);
        RH5SpaceshipImage = ImageLoader.loadImage("/images/RH5.png");
        fireLaserImage = spriteSheet.crop(0, 240, 256, 16);
        flameStrikeImage = ImageLoader.loadImage("/images/FlameStrike.png");
        littleSilverShipImage = ImageLoader.loadImage("/images/LittleSilver.png");
        inventoryObjectsBackground = ImageLoader.loadImage("/images/metalBackgroundInventory.jpg");
        padlockImage = ImageLoader.loadImage("/images/Padlock.png");
        inventoryBoltImage = ImageLoader.loadImage("/images/metalBoltInventoryImage.jpg");
        statusBarImage = ImageLoader.loadImage("/images/statusBarImage.jpg");
    }
}
