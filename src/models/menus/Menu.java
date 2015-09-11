package models.menus;


import display.Display;
import game.InputHandlers.MenuInputHandler;

import java.awt.*;
import java.util.ArrayList;

public abstract class Menu {

    private int currentRow;
    private int rowsInMenu;
    private String title;
    private MenuInputHandler inputHandler;
    protected ArrayList<String> rows;



    protected Menu(int rowsInMenu, String title) {
        this.currentRow = 1;
        this.rowsInMenu = rowsInMenu;
        this.title = title;
        this.inputHandler = new MenuInputHandler(this);
        this.rows = new ArrayList<>();
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        boolean isOutOfBounds = currentRow > this.rowsInMenu || currentRow < 1;
        if (!isOutOfBounds) {
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
