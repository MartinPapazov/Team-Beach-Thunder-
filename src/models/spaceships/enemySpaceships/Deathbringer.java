package models.spaceships.enemySpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.LaserLauncher;
import models.spaceships.weapons.MissileLauncher;
import models.spaceships.weapons.Weapon;

public class Deathbringer extends Spaceship {

    private static final String DeathbringerName = "Deathbringer";
    private static final int DeathbringerWidth = 100;
    private static final int DeathbringerHeight = 100;
    private static final int DeathbringerHealth = 500;
    private static final int DeathbringerArmor = 1000;
    private static final int DeathbringerVelocity = 1;

    public Deathbringer(int x, int y, int cooldown) {
        super(DeathbringerName, x, y, DeathbringerWidth,
                DeathbringerHeight, Assets.deathbringerImage,
                DeathbringerHealth, DeathbringerArmor,
                new LaserLauncher(cooldown, false),
                DeathbringerVelocity);
    }
}

