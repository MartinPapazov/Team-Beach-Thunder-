package models.inventorys;

import models.Player;
import models.spaceships.Spaceship;
import models.spaceships.playerSpaceships.*;
import phases.PhaseInventory;
import phases.PhaseLevelGameplay;
import phases.PhaseManager;

import java.awt.image.BufferedImage;

public class SpaceshipInventory extends Inventory {

    private static final int defaultX = 50;
    private static final int defaultY = 250;
    private Spaceship[][] spaceships;


    public SpaceshipInventory() {
        super();

    }
    @Override
    public void enter() {
        Spaceship spaceship = this.spaceships[this.getCurrentCol()][this.getCurrentRow()];
        PhaseManager.getCurrentPlayer().setCurrentSpaceship(spaceship);

        PhaseManager.setCurrentPhase(new PhaseInventory(new LevelInventory()));
    }

    @Override
    protected void initialization() {
        this.spaceships = new Spaceship[3][3];
        boolean[][] locks = new boolean[3][3];
        Player player = PhaseManager.getCurrentPlayer();
        this.spaceships[0][0] = new Spacecruiser(defaultX,defaultY);
        locks[0][0] = player.getNamesOfOwnedSpaceships().contains("Spacecruiser");
        this.spaceships[1][0] = new BlackViper(defaultX,defaultY);
        locks[1][0] = player.getNamesOfOwnedSpaceships().contains("Black Viper");
        this.spaceships[2][0] = new RH5(defaultX, defaultY);
        locks[2][0] = player.getNamesOfOwnedSpaceships().contains("RH5");
        this.spaceships[0][1] = new DownFighter(defaultX, defaultY);
        locks[0][1] = player.getNamesOfOwnedSpaceships().contains("DownFighter");
        this.spaceships[1][1] = new Slayer(defaultX, defaultY);
        locks[1][1] = player.getNamesOfOwnedSpaceships().contains("Slayer");
        this.spaceships[2][1] = new MoonStalker(defaultX, defaultY);
        locks[2][1] = player.getNamesOfOwnedSpaceships().contains("Moon Stalker");

        this.addObjectsToInformationalInventory(spaceships, locks);
    }

}
