package models.levels;

import Utilitys.Constants;
import contracts.Informational;
import models.spaceships.Spaceship;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Level implements Informational{

    private BufferedImage backgroundImage;
    private ArrayList<Spaceship> enemys;
    private int coinsPerLevel;

    protected Level(BufferedImage image, int coinsPerLevel) {
        //TODO: Add name in constructor and as a field.
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
        for (int i = 0; i < this.enemys.size(); i++) {
            Spaceship enemy = this.enemys.get(i);
            enemy.update();
            this.spaceShipRotation(enemy);
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.backgroundImage, 0, 0, Constants.WindowWidth, Constants.WindowHeight, null);
        this.enemys.stream().forEach((e) -> e.render(graphics));
    }

    public BufferedImage getObjectImage() {
        return this.backgroundImage;
    }

    public Map<String, String> getInformationAboutObject() {
        //TODO: Implement this method.
        return new HashMap<>();
    }

    protected void addEnemySpaceship(Spaceship... spaceships) {
        for (int i = 0; i < spaceships.length; i++) {
            Spaceship spaceship = spaceships[i];
            this.enemys.add(spaceship);
        }
    }

    protected abstract void spaceShipRotation(Spaceship spaceship);


}
