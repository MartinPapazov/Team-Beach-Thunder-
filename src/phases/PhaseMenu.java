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
        //Background image drawn
        graphics.drawImage(Assets.backgroundImage, 0, 0, Constants.WindowWidth, Constants.WindowHeight, null);

        //Title font and color properties
        graphics.setColor(Color.yellow);
        Font titleFont = new Font("Serif", 1, Constants.MenuTitleSize);
        graphics.setFont(titleFont);
        //Draw title
        graphics.drawString(this.menu.getTitle(), 50, 100);
        //Draw all lines

        Font menuItemsFont = new Font("Monospaced", 0, Constants.MenuLineSize);
        graphics.setFont(menuItemsFont);
        int linePosition = 175;
        for (int i = 0; i < this.menu.getRows().size(); i++) {
            String lineText = this.menu.getRows().get(i);
            if (i + 1 == this.menu.getCurrentRow()) {
                graphics.setColor(Color.GREEN);
                graphics.drawString(lineText, 50, linePosition);
            } else {
                graphics.setColor(Color.RED);
                graphics.drawString(lineText, 50, linePosition);
            }
           linePosition += Constants.MenuLineSize + 10;

        }
        this.menu.render(graphics);

    }
}
