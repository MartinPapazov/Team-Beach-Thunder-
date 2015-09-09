package phases;

import game.Scheduling;

import java.awt.*;

public class TestingPhase extends Phase{
    //Fields only for testing purpose
    private int x;
    private int y;
    private boolean moveLeft;
    private boolean moveRight;

    //Class with algorithm for calculating fps.
    private Scheduling scheduling;


    public TestingPhase(){
        this.x = 10;
        this.y = 10;
        this.moveLeft = true;
        this.scheduling = new Scheduling(20);
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
        graphics.drawRect(x,y,30, 100);
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
