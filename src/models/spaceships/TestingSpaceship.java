package models.spaceships;

import graphics.Assets;
import models.spaceships.weapons.MissileLauncher;

public class TestingSpaceship extends Spaceship{

    public TestingSpaceship( int velocity) {
        super("Gosho", 50, 40, 50, 60, Assets.testingSpaceshipImage, 500,
                1000,
                new MissileLauncher(20000, true),
                velocity);
    }
}
