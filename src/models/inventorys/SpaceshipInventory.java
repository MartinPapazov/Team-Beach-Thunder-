package models.inventorys;

import models.spaceships.Spaceship;
import models.spaceships.playerSpaceships.BlackViper;
import models.spaceships.playerSpaceships.RH5;
import models.spaceships.playerSpaceships.Spacecruiser;

public class SpaceshipInventory extends Inventory {

    @Override
    public void enter() {
        System.out.println("work");
    }

    @Override
    protected void initialization() {
        Spaceship[][] spaceships = new Spaceship[3][3];
        spaceships[0][0] = new Spacecruiser(50,50);
        spaceships[0][1] = new BlackViper(50,50);
        spaceships[0][2] = new RH5(50, 50);

        this.addObjectsToInformationalInventory(spaceships);
    }
}
