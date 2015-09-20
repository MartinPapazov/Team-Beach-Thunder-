package models.inventorys;

import Utilitys.Constants;
import contracts.Informational;
import game.InputHandlers.InputHandler;
import game.InputHandlers.InventoryInputHandler;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public abstract class Inventory {

    private Informational[][] informationals;
    private int currentRow;
    private int currentCol;

    protected Inventory() {
        this.informationals = new Informational[3][3];
        this.currentCol = 0;
        this.currentRow = 0;
        this.initialization();
        new InventoryInputHandler(this);
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        if (currentRow >= 0 && currentRow < 3) {
            this.currentRow = currentRow;
        }
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        if (currentCol >= 0 && currentCol < 3) {
            this.currentCol = currentCol;
        }
    }

    protected void addObjectsToInformationalInventory(Informational[][] objects) {
        for (int i = 0; i < this.informationals.length; i++) {
            for (int j = 0; j < this.informationals[i].length; j++) {
                this.informationals[i][j] = objects[i][j];
            }
        }
    }

    public void update() {

    }

    public void render(Graphics graphics) {
        graphics.drawImage(Assets.backgroundImage, 0, 0, Constants.WindowWidth, Constants.WindowHeight, null);

        int x = 50;
        int y = 45;
        int width = 150;
        int height = 100;

        //Objects
        for (int i = 0; i < this.informationals.length; i++) {
            for (int j = 0; j < this.informationals[i].length; j++) {
                int currentX = x + i*x + i*width;
                int currentY = (55 + y) + j*y + j*height;
                BufferedImage backgroundImage = Assets.inventoryObjectsBackground;
                BufferedImage padlockImage = Assets.padlockImage;
                Informational inform = this.informationals[i][j];


                if (currentRow == j && currentCol == i) {
                    graphics.setColor(Color.CYAN);
                } else {
                    graphics.setColor(Color.white);
                }

                graphics.fillRect(currentX, currentY, width, height);
                graphics.drawImage(backgroundImage, currentX + 5, currentY + 5, width - 10, height - 10, null);
                if (inform != null) {
                   graphics.drawImage(inform.getObjectImage(), currentX + 5, currentY + 5, width - 10, height - 10, null);
                }

                //graphics.drawImage(padlockImage, currentX + 20, currentY + 10, width - 40, height - 20, null);
            }
        }

        int infoTableX = 625;
        int infoTableY = 50;
        int infoTableWidth = 250;
        int infoTableHeight = 500;
        //Information table
        graphics.setColor(Color.black);
        graphics.fillRect(infoTableX, infoTableY, infoTableWidth, infoTableHeight);
        graphics.drawImage(Assets.inventoryBoltImage, infoTableX + 5, infoTableY + 5, infoTableWidth - 10, infoTableHeight - 10, null);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(infoTableX + 25, infoTableY + 25, infoTableWidth - 50, 120);
        graphics.drawImage(Assets.inventoryObjectsBackground, infoTableX + 30, infoTableY + 30, infoTableWidth - 60, 110, null);

        Informational inform = this.informationals[currentCol][currentRow];

        if (inform != null) {
            graphics.drawImage(inform.getObjectImage(), infoTableX + 30, infoTableY + 30, infoTableWidth - 60, 110, null);
            Map<String, String> info = inform.getInformationAboutObject();
            int count = 0;
            for (String s : info.keySet()) {
                Font f = new Font("Helvetica", 2, 20);
                graphics.setFont(f);
                String name = s;
                String status = info.get(s);
                graphics.drawString(name + " " + status, infoTableX + 15, infoTableY + 200 + (count * 30));
                count++;
            }
        }
    }

    public abstract void enter();
    protected abstract void initialization();
}
