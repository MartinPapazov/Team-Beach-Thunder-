package phases;

import Utilitys.Constants;
import game.InputHandlers.InputHandler;
import game.InputHandlers.PlayerSpaceshipInputHandler;
import game.Scheduling;
import models.spaceships.Spaceship;
import models.spaceships.TestingSpaceship;
import models.spaceships.playerSpaceships.Spacecruiser;

import java.awt.*;

public class GamePlayTESTPhase extends Phase {

    private Spaceship spaceship;
    private Spaceship spaceshipTwo;
    private Scheduling scheduling;

    public GamePlayTESTPhase() {
        this.spaceship = new Spacecruiser(10,50);
        InputHandler handler = new PlayerSpaceshipInputHandler(this.spaceship);
        this.scheduling = new Scheduling(Constants.GameplayFps);
        this.spaceshipTwo = new TestingSpaceship(1);
    }

    @Override
    public void update() {
        this.scheduling.update();
        double deltaTime = this.scheduling.getDeltaTime();
        if (deltaTime >= 1) {
            this.spaceship.update();
            this.spaceshipTwo.update();
            deltaTime--;
            this.scheduling.setDeltaTime(deltaTime);
            this.spaceship.hit(1);

        }
    }

    @Override
    public void render(Graphics graphics) {
        this.spaceship.render(graphics);
        this.spaceshipTwo.render(graphics);
    }
}
