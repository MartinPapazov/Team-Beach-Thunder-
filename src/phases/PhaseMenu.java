package phases;

import Utilitys.Constants;
import graphics.Assets;
import models.menus.Menu;

import java.awt.*;


public class PhaseMenu extends Phase{

    private Menu menu;

    public PhaseMenu(Menu menu){
        this.menu = menu;
    }


    @Override
    public void update() {
        this.menu.update();
    }

    @Override
    public void render(Graphics graphics) {
        this.menu.render(graphics);
    }
}
