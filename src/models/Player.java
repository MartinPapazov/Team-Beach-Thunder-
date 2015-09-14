package models;

import models.spaceships.Spaceship;

import java.util.ArrayList;

public class Player {

    private String name;
    private Spaceship currentSpaceship;
    private ArrayList<String> namesOfOwnedSpaceships;
    private int coins;
    private int levelsCompleted;

    public Player(String name, Spaceship currentSpaceship, ArrayList<String> namesOfOwnedSpaceships, int coins, int levelsCompleted) {
        this.name = name;
        this.currentSpaceship = currentSpaceship;
        this.namesOfOwnedSpaceships = namesOfOwnedSpaceships;
        this.coins = coins;
        this.levelsCompleted = levelsCompleted;
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

}
