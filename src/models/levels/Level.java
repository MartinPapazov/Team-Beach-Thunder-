package models.levels;

import Utilitys.Constants;
import models.spaceships.Spaceship;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Level {

    private BufferedImage backgroundImage;
    private ArrayList<Spaceship> enemys;
    private int coinsPerLevel;

    protected Level(BufferedImage image, int coinsPerLevel) {
        this.backgroundImage = image;
        this.enemys = new ArrayList<>();
        this.coinsPerLevel = coinsPerLevel;
    }

    public int getCoinsPerLevel() {
        return this.coinsPerLevel;
    }

    public ArrayList<Spaceship> getEnemys() {
        return this.enemys;
    }

    public void update() {
        this.enemys.stream().forEach((e) -> spaceShipRotation(e));
        this.enemys.stream().forEach((e) -> e.update());
        this.enemys.stream().forEach((e) -> e.fire());
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.backgroundImage, 0, 0, Constants.WindowWidth, Constants.WindowHeight, null);
        this.enemys.stream().forEach((e) -> e.render(graphics));
    }

    protected void addEnemySpaceship(Spaceship... spaceships) {
        for (int i = 0; i < spaceships.length; i++) {
            Spaceship spaceship = spaceships[i];
            this.enemys.add(spaceship);
        }
    }

    protected abstract void spaceShipRotation(Spaceship spaceship);


}
