package models;


import java.awt.*;

public abstract class Menu {

    private int currentRow;
    private int rowsInMenu;

    public Menu(int rowsInMenu) {
        this.currentRow = 1;
        this.rowsInMenu = rowsInMenu;
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

    public abstract void update();

    public abstract void render(Graphics graphics);
      //  graphics.drawImage(Assets.backgroundImage, 0, 0, Constants.WindowWidth, Constants.WindowHeight, null);
      //  graphics.setColor(Color.yellow);
      //  Font font = new Font("Serif", 1, 50);
      //  graphics.setFont(font);
      //  graphics.drawString("THUNDER SPACE", Constants.WindowWidth/2 - 220, 100);

}
