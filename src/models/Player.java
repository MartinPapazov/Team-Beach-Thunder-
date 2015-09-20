package models;

import models.spaceships.Spaceship;
import models.spaceships.playerSpaceships.Spacecruiser;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {

    private String name;
    private Spaceship currentSpaceship;
    private ArrayList<String> namesOfOwnedSpaceships;
    private int coins;
    private int levelsCompleted;
    private String lastSave;




    public Player(String name, Spaceship currentSpaceship, ArrayList<String> namesOfOwnedSpaceships, int coins, int levelsCompleted, String lastSave) {
        this.setName(name);
        this.setCurrentSpaceship(currentSpaceship);
        this.setNamesOfOwnedSpaceships(namesOfOwnedSpaceships);
        this.setCoins(coins);
        this.setLevelsCompleted(levelsCompleted);
        this.setLastSave(lastSave);

    }

    public Player() {
        this(
                "",
                new Spacecruiser(50, 50),
                new ArrayList<String>() {{
                    add("Spacecruiser");
                }},
                0,
                0,
                "-"
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Spaceship getCurrentSpaceship() {
        return currentSpaceship;
    }

    public void setCurrentSpaceship(Spaceship currentSpaceship) {
        this.currentSpaceship = currentSpaceship;
    }

    public ArrayList<String> getNamesOfOwnedSpaceships() {
        return namesOfOwnedSpaceships;
    }

    public void setNamesOfOwnedSpaceships(ArrayList<String> namesOfOwnedSpaceships) {
        this.namesOfOwnedSpaceships = namesOfOwnedSpaceships;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getLevelsCompleted() {
        return levelsCompleted;
    }

    public void setLevelsCompleted(int levelsCompleted) {
        this.levelsCompleted = levelsCompleted;
    }

    public String getLastSave() {
        return lastSave;
    }

    public void setLastSave(String lastSave) {
        this.lastSave = lastSave;
    }
}
