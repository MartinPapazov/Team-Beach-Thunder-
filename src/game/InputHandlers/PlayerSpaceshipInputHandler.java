package game.InputHandlers;


import models.spaceships.Spaceship;
import phases.PhaseManager;

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
        if (keyCode == KeyEvent.VK_DOWN){
            this.spaceship.isMovingDown = true;
        }

        if (keyCode == KeyEvent.VK_UP) {
            this.spaceship.isMovingUp = true;
        }

        if (keyCode == KeyEvent.VK_LEFT){
            this.spaceship.isMovingLeft = true;
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            this.spaceship.isMovingRight = true;
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
            this.spaceship.isMovingDown = false;
        }

        if (keyCode == KeyEvent.VK_UP) {
            this.spaceship.isMovingUp = false;
        }

        if (keyCode == KeyEvent.VK_LEFT){
            this.spaceship.isMovingLeft = false;
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            this.spaceship.isMovingRight = false;
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {
    }
}
