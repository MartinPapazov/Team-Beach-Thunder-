package models.levels;

import Utilitys.Constants;
import contracts.Informational;
import models.spaceships.Spaceship;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Level implements Informational{

    private BufferedImage backgroundImage;
    private ArrayList<Spaceship> enemys;
    private int level;
    private int coinsPerLevel;

    protected Level(BufferedImage image, int coinsPerLevel, int level) {
        //TODO: Add name in constructor and as a field.
        this.backgroundImage = image;
        this.enemys = new ArrayList<>();
        this.coinsPerLevel = coinsPerLevel;
        this.level = level;
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
        Map<String, String> info = new LinkedHashMap<>();
        String level = Integer.toString(this.level);
        String coins = Integer.toString(this.coinsPerLevel);
        info.put("Level:", level);
        info.put("Reward:", coins + " coins.");
        return info;
    }

    protected void addEnemySpaceship(Spaceship... spaceships) {
        for (int i = 0; i < spaceships.length; i++) {
            Spaceship spaceship = spaceships[i];
            this.enemys.add(spaceship);
        }
    }

    protected abstract void spaceShipRotation(Spaceship spaceship);


}
