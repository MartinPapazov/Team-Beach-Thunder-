package models.spaceships.enemySpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.AuroraTripleShot;

public class DragonDestroyer extends Spaceship {
    private static final String ShipName = "Dragon Destroyer";
    private static final int ShipWidth = 100;
    private static final int ShipHeight = 50;
    private static final int ShipHealth = 1200;
    private static final int ShipArmor = 800;
    private static final int ShipVelocity = 3;

    public DragonDestroyer(int x, int y, int cooldown) {
        super(ShipName, x, y, ShipWidth,
                ShipHeight, Assets.dragonDestroyerImage,
                ShipHealth, ShipArmor,
                new AuroraTripleShot(cooldown, false),
                ShipVelocity);
    }
}