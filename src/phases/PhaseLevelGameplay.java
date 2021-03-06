package phases;

import Utilitys.Constants;
import audio.AudioAssets;
import display.Display;
import game.InputHandlers.InputHandler;
import game.InputHandlers.PlayerSpaceshipInputHandler;
import game.Scheduling;
import jdk.internal.util.xml.impl.Input;
import models.Player;
import models.inventorys.SpaceshipInventory;
import models.levels.Level;
import models.spaceships.Spaceship;
import models.spaceships.weapons.bullets.Bullet;
import sun.audio.AudioPlayer;
import graphics.Assets;

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
    private InputHandler handler;


    public PhaseLevelGameplay(Level level) {
        AudioPlayer.player.stop(AudioAssets.menuStream);
        this.level = level;
        this.setPlayer(PhaseManager.getCurrentPlayer());
        this.playerSpaceShip = this.player.getCurrentSpaceship();
        this.playerFullHealth = this.playerSpaceShip.getHealth();
        this.playerFullArmor = this.playerSpaceShip.getArmor();
        this.activateInputHandler();
        this.scheduling = new Scheduling(Constants.GameplayFps);
        this.isGameOver = false;
        this.isGameWin = false;
    }

    public void activateInputHandler() {
        this.handler = new PlayerSpaceshipInputHandler(playerSpaceShip);
    }

    public void deactivateInputHandler() {
        if (this.handler != null) {
            Display.getInstance().getCanvas().removeKeyListener(this.handler);
        }
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

        if (this.isGameWin) {
            this.deactivateInputHandler();
            this.gameWin();
            PhaseManager.setCurrentPhase(new PhaseEndGame(false));
        }

        if (this.isGameOver) {
            this.deactivateInputHandler();
            PhaseManager.setCurrentPhase(new PhaseEndGame(true));
        }
    }

    @Override
    public void render(Graphics graphics) {
        this.level.render(graphics);
        this.playerSpaceShip.render(graphics);


        graphics.drawString(this.player.getName(), 5, 20);
        //Draw player health
        graphics.drawString("HP:", 200, 20);
        graphics.setColor(Color.white);
        graphics.fillRect(225, 5, 100, 20);
        int playerHealthInPercentage = getPlayerAtributeInPercent(this.playerFullHealth, this.playerSpaceShip.getHealth());
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
        int playerArmorInPercentage = this.getPlayerAtributeInPercent(this.playerFullArmor, this.playerSpaceShip.getArmor());
        graphics.fillRect(390, 5, playerArmorInPercentage, 20);
        graphics.setColor(Color.black);
        graphics.drawRect(390, 5, 100, 20);
        graphics.drawString(this.playerSpaceShip.getArmor() + "/" + this.playerFullArmor, 395, 20);

    }

    private int getPlayerAtributeInPercent(int full, int current) {
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
                if (currentSpaceship != null || currentBullet != null) {
                    currentBullet.checkForClash(currentSpaceship);
                }
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
