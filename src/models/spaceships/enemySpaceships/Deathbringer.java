package models.spaceships.enemySpaceships;

import graphics.Assets;
import models.spaceships.Spaceship;
import models.spaceships.weapons.MissileLauncher;
import models.spaceships.weapons.Weapon;

public class Deathbringer extends Spaceship {

    private static final String DeathbringerName = "Deathbringer";
    private static final int DeathbringerWidth = 100;
    private static final int DeathbringerHeight = 100;
    private static final int DeathbringerHealth = 500;
    private static final int DeathbringerArmor = 1000;
    private static final Weapon DeathbringerWeapon = new MissileLauncher(150, false);
    private static final int DeathbringerVelocity = 3;

    public Deathbringer(int x, int y) {
        super(DeathbringerName, x, y, DeathbringerWidth, DeathbringerHeight, Assets.deathbringerImage,
                DeathbringerHealth, DeathbringerArmor, DeathbringerWeapon, DeathbringerVelocity);
    }
}

