package models.menus;

import audio.AudioAssets;
import game.InputHandlers.MenuInputHandler;
import game.InputHandlers.StoreHandler;
import sun.audio.AudioPlayer;

import java.awt.*;
import java.util.ArrayList;

public abstract class Store {

    private int currentRow;
    private int currentCol;
    private int rowsInMenu;
    private int colsInMenu;
    private String title;
    private StoreHandler inputHandler;

    protected Store (int rowsInMenu, int colsInMenu, String title){
        this.currentRow = 1;
        this.currentCol = 1;
        this.rowsInMenu = rowsInMenu;
        this.colsInMenu = colsInMenu;
        this.title = title;
        this.inputHandler = new StoreHandler(this);

    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        boolean isOutOfBounds = currentRow > this.rowsInMenu || currentRow < 1;
        if (!isOutOfBounds) {
            AudioPlayer.player.start(AudioAssets.getMenuChoiceSound());
            this.currentRow = currentRow;
        }
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        boolean isOutOfBounds = currentCol > this.colsInMenu || currentCol < 1;
        if (!isOutOfBounds) {
            AudioPlayer.player.start(AudioAssets.getMenuChoiceSound());
            this.currentCol = currentCol;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public abstract void enter();

    public abstract void update();

    public abstract void render(Graphics graphics);

    protected abstract void initialization();
}
