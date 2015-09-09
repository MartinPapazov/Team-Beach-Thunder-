package graphics;


import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage backgroundImage;

    public static void initialization(){
        backgroundImage = ImageLoader.loadImage("/images/MenuWallpaper.jpg");
    }
}
