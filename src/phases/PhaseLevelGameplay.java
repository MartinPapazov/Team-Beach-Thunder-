package phases;

import Utilitys.Constants;
import game.InputHandlers.InputHandler;
import game.InputHandlers.PlayerSpaceshipInputHandler;
import game.Scheduling;
import models.levels.Level;
import models.spaceships.Spaceship;
import models.spaceships.playerSpaceships.Spacecruiser;
import models.spaceships.weapons.bullets.Bullet;

import java.awt.*;
import java.util.ArrayList;

public class PhaseLevelGameplay extends Phase {

    private Level level;
    //TODO: Player field
    private Spaceship playerSpaceShip;
    private Scheduling scheduling;


    public PhaseLevelGameplay(Level level) {
        this.level = level;
        this.playerSpaceShip = new Spacecruiser(50, 50);
        InputHandler handler = new PlayerSpaceshipInputHandler(playerSpaceShip);
        //TODO:
        this.scheduling = new Scheduling(Constants.GameplayFps);
    }

    @Override
    public void update() {
        this.scheduling.update();
        double deltaTime = this.scheduling.getDeltaTime();
        if (deltaTime >= 1) {
            this.playerSpaceShip.update();
            this.level.update();
            deltaTime--;
            this.scheduling.setDeltaTime(deltaTime);
        }

        this.checkForClash();
    }

    @Override
    public void render(Graphics graphics) {
        this.level.render(graphics);
        this.playerSpaceShip.render(graphics);
    }

    private void checkForClash() {
        ArrayList<Spaceship> enemySpaceships = this.level.getEnemys();
        ArrayList<Bullet> playerBullets = this.playerSpaceShip.getWeapon().getBulletsFired();
        for (int i = 0; i < playerBullets.size(); i++) {
            Bullet currentBullet = playerBullets.get(i);

            for (int j = 0; j < enemySpaceships.size(); j++) {
                Spaceship currentSpaceship = enemySpaceships.get(j);
                currentBullet.checkForClash(currentSpaceship);
            }
        }

        for (int i = 0; i < enemySpaceships.size(); i++) {
            ArrayList<Bullet> currentSpaceshipBullets =  enemySpaceships.get(i).getWeapon().getBulletsFired();

            for (int j = 0; j < currentSpaceshipBullets.size(); j++) {
                Bullet currentBullet = currentSpaceshipBullets.get(j);
                currentBullet.checkForClash(this.playerSpaceShip);
            }
        }
    }
}
