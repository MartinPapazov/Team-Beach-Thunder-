package game.InputHandlers;

import display.Display;
import models.inventorys.Inventory;

import java.awt.event.KeyEvent;

public class InventoryInputHandler extends InputHandler {

    private Inventory inventory;

    public InventoryInputHandler(Inventory inventory) {
        super();
        this.inventory = inventory;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_DOWN){
            this.inventory.setCurrentRow(this.inventory.getCurrentRow() + 1);
        }

        if (keyCode == KeyEvent.VK_UP) {
            this.inventory.setCurrentRow(this.inventory.getCurrentRow() - 1);
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            this.inventory.setCurrentCol(this.inventory.getCurrentCol() - 1);
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            this.inventory.setCurrentCol(this.inventory.getCurrentCol() + 1);
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            Display.getInstance().getCanvas().removeKeyListener(this);
            this.inventory.enter();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
