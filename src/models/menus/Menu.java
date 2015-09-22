package models.menus;


import Utilitys.Constants;
import audio.AudioAssets;
import game.InputHandlers.MenuInputHandler;
import graphics.Assets;
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

    public void render(Graphics graphics){
        //Background image drawn
        graphics.drawImage(Assets.backgroundImage, 0, 0, Constants.WindowWidth, Constants.WindowHeight, null);

        //Title font and color properties
        graphics.setColor(Color.yellow);
        Font titleFont = new Font("Serif", 1, Constants.MenuTitleSize);
        graphics.setFont(titleFont);
        //Draw title
        graphics.drawString(this.title, 50, 100);
        //Draw all lines

        Font menuItemsFont = new Font("Monospaced", 0, Constants.MenuLineSize);
        graphics.setFont(menuItemsFont);
        int linePosition = 175;
        for (int i = 0; i < this.rows.size(); i++) {
            String lineText = this.rows.get(i);
            if (i + 1 == this.currentRow) {
                graphics.setColor(Color.GREEN);
                graphics.drawString(lineText, 50, linePosition);
            } else {
                graphics.setColor(Color.RED);
                graphics.drawString(lineText, 50, linePosition);
            }
            linePosition += Constants.MenuLineSize + 10;

        }
    }

    protected abstract void initialization();


}
