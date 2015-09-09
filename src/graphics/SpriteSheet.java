package graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    protected BufferedImage spriteSheet;

    public SpriteSheet(BufferedImage spriteSheet){
        this.spriteSheet = spriteSheet;
    }

    public BufferedImage crop(int x, int y, int width, int height) {
        BufferedImage croppedImage = this.spriteSheet.getSubimage(x, y, width, height);
        return croppedImage;
    }
}
