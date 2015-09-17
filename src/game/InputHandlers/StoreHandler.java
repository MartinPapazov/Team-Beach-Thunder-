package game.InputHandlers;

import display.Display;
import models.menus.Store;

import java.awt.event.KeyEvent;

public class StoreHandler extends InputHandler {

    private Store store;

    public StoreHandler (Store store){
        super();
        this.store=store;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_DOWN){
            this.store.setCurrentRow(this.store.getCurrentRow() + 1);
        }

        if (keyCode == KeyEvent.VK_UP) {
            this.store.setCurrentRow(this.store.getCurrentRow() - 1);
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            this.store.setCurrentCol(this.store.getCurrentCol() - 1);
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            this.store.setCurrentCol(this.store.getCurrentCol() + 1);
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            Display.getInstance().getCanvas().removeKeyListener(this);
            this.store.enter();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
