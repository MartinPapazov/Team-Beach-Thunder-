package models.spaceships.enemySpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.LaserMachineGun;

public class SpaceStation extends Spaceship {

    private static final String SpaceStationName = "Space station";
    private static final int SpaceStationWidth = 500;
    private static final int SpaceStationHeight = 500;
    private static final int SpaceStationHealth = 10000;
    private static final int SpaceStationArmor = 0;
    private static final int SpaceStationVelocity = 1;

    public SpaceStation(int x, int y, int cooldown) {
        super(SpaceStationName, x, y, SpaceStationWidth,
                SpaceStationHeight, Assets.enemySpaceStation,
                SpaceStationHealth, SpaceStationArmor,
                new LaserMachineGun(cooldown, false),
                SpaceStationVelocity);
    }

}

