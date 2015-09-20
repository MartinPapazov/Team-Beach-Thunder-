package phases;

import Utilitys.Constants;
import audio.AudioAssets;
import game.InputHandlers.PlayerSpaceshipInputHandler;
import game.Scheduling;
import models.Player;
import models.levels.Level;
import models.spaceships.Spaceship;
import models.spaceships.weapons.bullets.Bullet;
import sun.audio.AudioPlayer;

import java.awt.*;
import java.util.ArrayList;

public class PhaseLevelGameplay extends Phase {

    private Level level;
    private Player player;
    private Spaceship playerSpaceShip;
    private Scheduling scheduling;
    private int playerFullHealth;
    private int playerFullArmor;
    private boolean isGameOver;
    private boolean isGameWin;


    public PhaseLevelGameplay(Level level) {
        AudioPlayer.player.stop(AudioAssets.menuStream);
        this.level = level;
        this.setPlayer(PhaseManager.getCurrentPlayer());
        this.playerSpaceShip = this.player.getCurrentSpaceship();
        this.playerFullHealth = this.playerSpaceShip.getHealth();
        this.playerFullArmor = this.playerSpaceShip.getArmor();
        new PlayerSpaceshipInputHandler(playerSpaceShip);
        this.scheduling = new Scheduling(Constants.GameplayFps);
        this.isGameOver = false;
        this.isGameWin = false;
    }

    private void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void update() {
        if (!(this.isGameOver || this.isGameWin)) {
            this.scheduling.update();
            double deltaTime = this.scheduling.getDeltaTime();
            if (deltaTime >= 1) {
                this.playerSpaceShip.update();
                this.level.update();
                deltaTime--;
                this.scheduling.setDeltaTime(deltaTime);
            }

            this.checkForClash();
            this.checkForGameEnd();
        }
    }

    @Override
    public void render(Graphics graphics) {
        this.level.render(graphics);
        this.playerSpaceShip.render(graphics);

        //Draw gray bar
        graphics.setColor(new Color(153, 153, 102));
        graphics.fillRect(0, 0, Constants.WindowWidth, Constants.GameStatusBar);
        graphics.setColor(Color.black);
        graphics.drawString(this.player.getName(), 5, 20);

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

        if (this.isGameOver) {
            //TODO: GAME OVER Message drawn.
        }
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

    private void gameWin() {
        this.player.setCoins(this.player.getCoins() + this.level.getCoinsPerLevel());
        this.player.setLevelsCompleted(this.player.getLevelsCompleted() + 1);
    }

    private void checkForGameEnd() {
        if (this.playerSpaceShip.getHealth() <= 0) {
            this.isGameOver = true;
        }

        if (!this.level.getEnemys().stream().anyMatch((e) -> e.getHealth() > 0)) {
            this.isGameWin = true;
        }
    }
}
