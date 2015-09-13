package models.levels;

import models.spaceships.Spaceship;
import models.spaceships.playerSpaceships.Spacecruiser;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Level {

    private BufferedImage backgroundImage;
    private ArrayList<Spaceship> enemys;
    private int coinsPerLevel;

    public Level(BufferedImage image, int coinsPerLevel) {
        this.backgroundImage = image;
        this.enemys = new ArrayList<>();
        this.coinsPerLevel = coinsPerLevel;
    }

    public int getCoinsPerLevel() {
        return this.coinsPerLevel;
    }

    public void addEnemySpaceship(Spaceship spaceship) {
        this.enemys.add(spaceship);
    }

    public void update() {
        this.enemys.stream().forEach((e) -> spaceShipRotation(e));
        this.enemys.stream().forEach((e) -> e.fire());
    }

    public void render(Graphics graphics) {
        this.enemys.stream().forEach((e) -> e.render(graphics));
    }

    protected abstract void spaceShipRotation(Spaceship spaceship);
}
