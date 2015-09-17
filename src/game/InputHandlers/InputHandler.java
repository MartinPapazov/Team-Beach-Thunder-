package game.InputHandlers;

import display.Display;
import models.menus.Menu;

import java.awt.event.KeyListener;

public abstract class InputHandler implements KeyListener {

    public InputHandler() {

        Display.getInstance().getCanvas().addKeyListener(this);
    }
}
