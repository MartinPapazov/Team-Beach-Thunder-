package graphics;

import java.awt.image.BufferedImage;

public class SpriteSheetAnimation extends SpriteSheet {

    private int startX;
    private int startY;
    private int currentX;
    private int currentY;
    private int width;
    private int height;
    private int maxCount;
    private int count;
    private int positionOnLine;
    private int cols;
    private int rows;
    private BufferedImage currentImage;
    private boolean cycle;
    private int animationSpeed;
    private int animationSpeedCounter;

    public SpriteSheetAnimation(BufferedImage bufferedImage, int startX, int startY,
                                int width, int height, int maxCount, int animationSpeed , boolean cycle){
        super(bufferedImage);
        this.startX = startX;
        this.startY = startY;
        this.currentX = startX;
        this.currentY = startY;
        this.width = width;
        this.height = height;
        this.maxCount = maxCount;
        this.count = 1;
        this.cols = bufferedImage.getWidth() / width;
        this.rows = bufferedImage.getHeight() / height;
        this.positionOnLine = cols - (bufferedImage.getWidth() - startX) / width;
        this.animationSpeed = animationSpeed;
        this.animationSpeedCounter = 0;
        this.cycle = cycle;

        this.currentImage = this.getCurrentImage();
    }

    public BufferedImage animationCrop(){
       this.animationSpeedCounter++;
        if (this.animationSpeedCounter == this.animationSpeed) {
            this.animationSpeedCounter = 0;
            this.currentImage = getCurrentImage();
        }

        return this.currentImage;
    }

    private BufferedImage getCurrentImage() {
        this.positionOnLine++;
        BufferedImage bufferedImage = this.crop(currentX, currentY, width, height);

        this.currentX = this.positionOnLine * width;

        boolean isOutOfCols = this.positionOnLine >= this.cols;
        if (isOutOfCols){
            this.currentX = this.startX;
            this.positionOnLine = 0;
            this.currentY += this.height;
            boolean isOutOfRows = this.currentY >= this.rows * this.height;
            if (isOutOfRows){
                this.currentY = this.startY;
            }
        }


        this.count++;
        if (this.count > this.maxCount){
            if (!this.cycle) {
                return null;
            }

            this.count = 1;
            this.positionOnLine = cols - (spriteSheet.getWidth() - startX) / width;
            this.currentX = this.startX;
            this.currentY = this.startY;
        }

        return bufferedImage;
    }
}
