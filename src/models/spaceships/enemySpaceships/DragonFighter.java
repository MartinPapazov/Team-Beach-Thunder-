package models.spaceships.enemySpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.NovaShock;

public class DragonFighter extends Spaceship {
    private static final String ShipName = "Dragon Fighter";
    private static final int ShipWidth = 100;
    private static final int ShipHeight = 100;
    private static final int ShipHealth = 700;
    private static final int ShipArmor = 1200;
    private static final int ShipVelocity = 2;

    public DragonFighter(int x, int y, int cooldown) {
        super(ShipName, x, y, ShipWidth,
                ShipHeight, Assets.dragonFighterImage,
                ShipHealth, ShipArmor,
                new NovaShock(cooldown, false),
                ShipVelocity);
    }
}