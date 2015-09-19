package phases;

import Utilitys.Constants;
import graphics.Assets;
import models.menus.SaveMenu;

import java.awt.*;

public class PhaseSaveMenu extends Phase {

    private SaveMenu saveMenu;

    public PhaseSaveMenu (SaveMenu saveMenu){
        this.setSaveMenu(saveMenu);
    }

    public SaveMenu getSaveMenu() {
        return saveMenu;
    }

    public void setSaveMenu(SaveMenu saveMenu) {
        this.saveMenu = saveMenu;
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
        graphics.drawString(this.saveMenu.getTitle(), 50, 100);
        //Draw all lines

        Font menuItemsFont = new Font("Monospaced", 0, 35);
        graphics.setFont(menuItemsFont);
        int linePosition = 175;
        for (int i = 0; i < this.saveMenu.getRows().size(); i++) {
            String lineText = this.saveMenu.getRows().get(i);
            if (i + 1 == this.saveMenu.getCurrentRow()) {
                graphics.setColor(Color.GREEN);
                graphics.drawString(lineText, 50, linePosition);
            } else {
                graphics.setColor(Color.RED);
                graphics.drawString(lineText, 50, linePosition);
            }
            linePosition += Constants.MenuLineSize + 10;

        }

        this.saveMenu.render(graphics);
    }
}
