package phases;

import Utilitys.Constants;
import game.InputHandlers.InputHandler;
import game.InputHandlers.PlayerSpaceshipInputHandler;
import game.Scheduling;
import models.spaceships.Spaceship;
import models.spaceships.TestingSpaceship;

import java.awt.*;

public class GamePlayTESTPhase extends Phase {

    private Spaceship spaceship;
    private Scheduling scheduling;

    public GamePlayTESTPhase() {
        this.spaceship = new TestingSpaceship(1);
        InputHandler handler = new PlayerSpaceshipInputHandler(this.spaceship);
        this.scheduling = new Scheduling(Constants.GameplayFps);
    }

    @Override
    public void update() {
        this.scheduling.update();
        double deltaTime = this.scheduling.getDeltaTime();
        if (deltaTime >= 1) {
            this.spaceship.update();
            deltaTime--;
            this.scheduling.setDeltaTime(deltaTime);
            this.spaceship.hit(3);
        }
    }

    @Override
    public void render(Graphics graphics) {
        this.spaceship.render(graphics);
    }
}
