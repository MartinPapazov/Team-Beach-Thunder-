package models.menus;


import audio.AudioAssets;
import game.InputHandlers.MenuInputHandler;
import sun.audio.AudioPlayer;

import java.awt.*;
import java.util.ArrayList;

public abstract class Menu {

    private int currentRow;
    private String title;
    private MenuInputHandler inputHandler;
    protected ArrayList<String> rows;



    protected Menu(String title) {
        this.currentRow = 1;
        this.rows = new ArrayList<>();
        this.title = title;
        this.inputHandler = new MenuInputHandler(this);
    }


    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        boolean isOutOfBounds = currentRow > this.rows.size() || currentRow < 1;
        if (!isOutOfBounds) {
            AudioPlayer.player.start(AudioAssets.getMenuChoiceSound());
            this.currentRow = currentRow;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<String> getRows(){
        return this.rows;
    }

    public void addRows(String element){
        this.rows.add(element);
    }

    public abstract void enter();

    public abstract void update();

    public abstract void render(Graphics graphics);

    protected abstract void initialization();


}
