package models.spaceships.enemySpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.LaserLauncher;
import models.spaceships.weapons.LaserMachineGun;

public class NightRider extends Spaceship {
    private static final String NightRiderName = "Night Rider";
    private static final int NightRiderWidth = 100;
    private static final int NightRiderHeight = 100;
    private static final int NightRiderHealth = 500;
    private static final int NightRiderArmor = 1000;
    private static final int NightRiderVelocity = 1;

    public NightRider(int x, int y, int cooldown) {
        super(NightRiderName, x, y, NightRiderWidth,
                NightRiderHeight, Assets.nightRiderImage,
                NightRiderHealth, NightRiderArmor,
                new LaserMachineGun(cooldown, false),
                NightRiderVelocity);
    }
}
