package phases;

import game.Scheduling;
import graphics.ImageLoader;
import graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TestingPhase extends Phase{
    //Fields only for testing purpose
    private int x;
    private int y;
    private boolean moveLeft;
    private boolean moveRight;
    private BufferedImage spaceshipImage = ImageLoader.loadImage("/images/spaceship.png");
    private SpriteSheet spriteSheet;
    private BufferedImage bombImage;

    //Class with algorithm for calculating fps.
    private Scheduling scheduling;


    public TestingPhase(){
        this.x = 10;
        this.y = 10;
        this.moveLeft = true;
        this.scheduling = new Scheduling(50);
        this.spriteSheet =  new SpriteSheet(ImageLoader.loadImage("/images/ExplosionSpriteSheet.png"));
        this.bombImage = this.spriteSheet.crop(100, 100, 100, 100);
    }

    @Override
    public void update() {
        this.scheduling.update();
        double deltaTime = this.scheduling.getDeltaTime();
        if (deltaTime >= 1) {
            this.tick();
            deltaTime--;
            this.scheduling.setDeltaTime(deltaTime);
        }
    }

    @Override
    public void render(Graphics graphics) {

        graphics.drawImage(spaceshipImage, this.x, this.y, 200, 200, null);
        graphics.drawImage(bombImage, 300, 300, 100, 100, null);
    }

    private void tick() {
        if (this.x <= 0){
            this.moveLeft = true;
            this.moveRight = false;
        }

        if (this.x >= 170){
            this.moveRight = true;
            this.moveLeft = false;
        }

        if (moveLeft){
            this.x += 1;
        }

        if (moveRight) {
            this.x -= 1;
        }
    }
}
