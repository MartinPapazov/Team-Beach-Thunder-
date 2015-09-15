package phases;

import Utilitys.Constants;
import game.InputHandlers.InputHandler;
import game.InputHandlers.PlayerSpaceshipInputHandler;
import game.Scheduling;
import graphics.Assets;
import models.levels.Level;
import models.spaceships.Spaceship;
import models.spaceships.playerSpaceships.BlackViper;
import models.spaceships.playerSpaceships.Spacecruiser;
import models.spaceships.weapons.bullets.Bullet;

import java.awt.*;
import java.util.ArrayList;

public class PhaseLevelGameplay extends Phase {

    private Level level;
    //TODO: Player field
    private Spaceship playerSpaceShip;
    private Scheduling scheduling;
    private int playerFullHealth;
    private int playerFullArmor;


    public PhaseLevelGameplay(Level level) {
        this.level = level;
        this.playerSpaceShip = new BlackViper(50, 50);
        this.playerFullHealth = this.playerSpaceShip.getHealth();
        this.playerFullArmor = this.playerSpaceShip.getArmor();
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

        //Draw gray bar
        graphics.setColor(new Color(153, 153, 102));
        graphics.fillRect(0, 0, Constants.WindowWidth, Constants.GameStatusBar);
        graphics.setColor(Color.black);
        graphics.drawString("Player name", 5, 20);

        //Draw player health
        graphics.drawString("HP:", 200, 20);
        graphics.setColor(Color.white);
        graphics.fillRect(225, 5, 100, 20);
        int playerHealthInPercentage = getPlayerAtributePercent(this.playerFullHealth, this.playerSpaceShip.getHealth());
        if (playerHealthInPercentage > 20) {
            graphics.setColor(Color.green);
        } else {
            graphics.setColor(Color.red);
        }
        graphics.fillRect(225, 5, playerHealthInPercentage, 20);
        graphics.setColor(Color.black);
        graphics.drawRect(225, 5, 100, 20);
        graphics.drawString(playerSpaceShip.getHealth() + "/" + this.playerFullHealth, 230, 20);

        //Draw player armor
        graphics.drawString("Armor:", 350, 20);
        graphics.setColor(Color.white);
        graphics.fillRect(390, 5, 100, 20);
        graphics.setColor(Color.CYAN);
        int playerArmorInPercentage = this.getPlayerAtributePercent(this.playerFullArmor, this.playerSpaceShip.getArmor());
        graphics.fillRect(390, 5, playerArmorInPercentage, 20);
        graphics.setColor(Color.black);
        graphics.drawRect(390, 5, 100, 20);
        graphics.drawString(this.playerSpaceShip.getArmor() + "/" + this.playerFullArmor, 395, 20);
    }

    private int getPlayerAtributePercent(int full, int current) {
        double onePercent = full / 100;
        if (current <= 0) {
            return 0;
        }
        double playerHealth = current / onePercent;

        return (int)playerHealth;
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
