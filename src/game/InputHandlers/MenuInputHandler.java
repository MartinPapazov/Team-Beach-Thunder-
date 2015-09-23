package game.InputHandlers;


import display.Display;
import models.menus.Menu;

import java.awt.event.KeyEvent;

public class MenuInputHandler extends InputHandler {

    private Menu menu;

    public MenuInputHandler(Menu menu) {
        super();
        this.menu = menu;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_DOWN){
            this.menu.setCurrentRow(this.menu.getCurrentRow() + 1);
        }

        if (keyCode == KeyEvent.VK_UP) {
            this.menu.setCurrentRow(this.menu.getCurrentRow() - 1);
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            Display.getInstance().getCanvas().removeKeyListener(this);
            this.menu.enter();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
