package models.spaceships.enemySpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.FlameStrike;

public class LittleSilver extends Spaceship {
    private static final String LittleSilverName = "Little Silver";
    private static final int LittleSilverWidth = 90;
    private static final int LittleSilverHeight = 90;
    private static final int LittleSilverHealth = 4500;
    private static final int LittleSilverArmor = 900;
    private static final int LittleSilverVelocity = 2;

    public LittleSilver(int x, int y, int cooldown) {
        super(LittleSilverName, x, y, LittleSilverWidth,
                LittleSilverHeight, Assets.littleSilverShipImage,
                LittleSilverHealth, LittleSilverArmor,
                new FlameStrike(cooldown, false),
                LittleSilverVelocity);
    }
}