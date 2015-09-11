package models.spaceships;

import graphics.Assets;
import models.spaceships.armors.TestArmor;
import models.spaceships.weapons.TestWeaopn;

public class TestingSpaceship extends Spaceship{

    public TestingSpaceship( int velocity) {
        super("Gosho", 50, 40, 50, 60, Assets.testingSpaceshipImage, 500,
                new TestArmor(),
                new TestWeaopn(),
                velocity);
    }
}
