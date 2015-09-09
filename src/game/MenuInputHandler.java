package game;


import display.Display;
import models.Menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuInputHandler implements KeyListener {

    private Menu menu;

    public MenuInputHandler(Display display, Menu menu){
        display.addKeyListener(this);
        this.menu = menu;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_DOWN){
            this.menu.setCurrentRow(this.menu.getCurrentRow() - 1);
        }

        if (keyCode == KeyEvent.VK_UP){
            this.menu.setCurrentRow(this.menu.getCurrentRow() + 1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
