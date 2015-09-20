package phases;

import Utilitys.Constants;
import graphics.Assets;
import models.menus.LoadMenu;

import java.awt.*;

public class PhaseLoadMenu extends Phase {

    private LoadMenu loadMenu;

    public PhaseLoadMenu(LoadMenu loadMenu) {
        this.loadMenu = loadMenu;
    }

    @Override
    public void update() {

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
        graphics.drawString(this.loadMenu.getTitle(), 50, 100);
        //Draw all lines

        Font menuItemsFont = new Font("Monospaced", 0, 35);
        graphics.setFont(menuItemsFont);
        int linePosition = 175;
        for (int i = 0; i < this.loadMenu.getRows().size(); i++) {
            String lineText = this.loadMenu.getRows().get(i);
            if (i + 1 == this.loadMenu.getCurrentRow()) {
                graphics.setColor(Color.GREEN);
                graphics.drawString(lineText, 50, linePosition);
            } else {
                graphics.setColor(Color.RED);
                graphics.drawString(lineText, 50, linePosition);
            }
            linePosition += Constants.MenuLineSize + 10;

        }

        this.loadMenu.render(graphics);
    }
}
