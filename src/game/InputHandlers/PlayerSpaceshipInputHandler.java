package game.InputHandlers;


import models.menus.PauseMenu;
import models.spaceships.Spaceship;
import phases.Phase;
import phases.PhaseManager;
import phases.PhaseMenu;

import java.awt.event.KeyEvent;


public class PlayerSpaceshipInputHandler extends InputHandler {

    private Spaceship spaceship;

    public PlayerSpaceshipInputHandler(Spaceship spaceship) {
        super();
        this.spaceship = spaceship;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ESCAPE){
            Phase currentPhase = PhaseManager.getCurrentPhase();
            PhaseManager.setCurrentPhase(new PhaseMenu(new PauseMenu(currentPhase)));
        }

        if (keyCode == KeyEvent.VK_DOWN){
            this.spaceship.setIsMovingDown(true);
        }

        if (keyCode == KeyEvent.VK_UP) {
            this.spaceship.setIsMovingUp(true);
        }

        if (keyCode == KeyEvent.VK_LEFT){
            this.spaceship.setIsMovingLeft(true);
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            this.spaceship.setIsMovingRight(true);
        }

        if (keyCode == KeyEvent.VK_SPACE) {
            this.spaceship.fire();
        }

        if (keyCode == KeyEvent.VK_ENTER) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_DOWN){
            this.spaceship.setIsMovingDown(false);
        }

        if (keyCode == KeyEvent.VK_UP) {
            this.spaceship.setIsMovingUp(false);
        }

        if (keyCode == KeyEvent.VK_LEFT){
            this.spaceship.setIsMovingLeft(false);
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            this.spaceship.setIsMovingRight(false);
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {
    }
}
