package models.spaceships.enemySpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.DDLaser;

public class DragonReaper extends Spaceship {
    private static final String ShipName = "Dragon Reaper";
    private static final int ShipWidth = 70;
    private static final int ShipHeight = 70;
    private static final int ShipHealth = 1000;
    private static final int ShipArmor = 400;
    private static final int ShipVelocity = 2;

    public DragonReaper(int x, int y, int cooldown) {
        super(ShipName, x, y, ShipWidth,
                ShipHeight, Assets.dragonReaperImage,
                ShipHealth, ShipArmor,
                new DDLaser(cooldown, false, 0, 60, 10, 40),
                ShipVelocity);
    }
}