package models.inventorys;

import models.spaceships.Spaceship;
import models.spaceships.playerSpaceships.*;
import phases.PhaseInventory;
import phases.PhaseLevelGameplay;
import phases.PhaseManager;

public class SpaceshipInventory extends Inventory {

    private static final int defaultX = 50;
    private static final int defaultY = 250;
    private  Spaceship[][] spaceships;

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
        this.spaceships[0][0] = new Spacecruiser(defaultX,defaultY);
        this.spaceships[0][1] = new BlackViper(defaultX,defaultY);
        this.spaceships[0][2] = new RH5(defaultX, defaultY);
        this.spaceships[1][0] = new DownFighter(defaultX, defaultY);
        this.spaceships[1][1] = new Slayer(defaultX, defaultY);
        this.spaceships[1][2] = new MoonStalker(defaultX, defaultY);

        this.addObjectsToInformationalInventory(spaceships);
    }

}
