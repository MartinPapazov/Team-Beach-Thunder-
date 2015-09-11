package models.spaceships.weapons;

import models.spaceships.weapons.bullets.Bullet;
import models.spaceships.weapons.bullets.TestBullet;

public class TestWeaopn extends Weapon {

    public TestWeaopn() {
        super(new TestBullet(), 0, 0);
    }

    @Override
    public void shoot() {

    }
}
