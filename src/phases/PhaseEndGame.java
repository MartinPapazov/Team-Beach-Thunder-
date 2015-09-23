package phases;

import Utilitys.Constants;
import models.inventorys.SpaceshipInventory;

import java.awt.*;

public class PhaseEndGame extends Phase {

    private final int maxCount = 90000;

    private boolean isGameOver;
    private int count;

    public PhaseEndGame(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    @Override
    public void update() {
        count++;
        if (count >= maxCount) {
            PhaseManager.setCurrentPhase(new PhaseInventory(new SpaceshipInventory()));
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(new Font("Serif", 1, 40));
        String text;
        if (isGameOver) {
            text = "GAME OVER!";
            graphics.setColor(Color.black);
        } else {
            text = "VICOTORY!";
            graphics.setColor(Color.CYAN);
        }

        graphics.fillRect(0, 0, Constants.WindowWidth, Constants.WindowHeight);
        graphics.setColor(Color.white);
        graphics.drawString(text, 300, 200);
    }
}
