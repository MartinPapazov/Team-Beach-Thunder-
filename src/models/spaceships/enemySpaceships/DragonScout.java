package models.spaceships.enemySpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.RedLazerShoot;

public class DragonScout extends Spaceship {
    private static final String ShipName = "Dragon Scout";
    private static final int ShipWidth = 80;
    private static final int ShipHeight = 50;
    private static final int ShipHealth = 600;
    private static final int ShipArmor = 200;
    private static final int ShipVelocity = 3;

    public DragonScout(int x, int y, int cooldown) {
        super(ShipName, x, y, ShipWidth,
                ShipHeight, Assets.dragonScoutImage,
                ShipHealth, ShipArmor,
                new RedLazerShoot(cooldown, false, 20),
                ShipVelocity);
    }
}