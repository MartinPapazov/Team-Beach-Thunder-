package models.menus;

import models.levels.TestLevel;
import phases.*;

import java.awt.*;

public class MainMenu extends Menu {

    private final static String title = "Main menu";
    private final static String firstLine = "Play";
    private final static String secondLine = "Profile";
    private final static String thirdLine = "EXIT";
    private final static int rows = 3;

    public MainMenu() {
        super(rows, title);
        this.initialization();
    }

    @Override
    public void enter() {
        switch (this.getCurrentRow()){
            case 1:
                PhaseManager.setCurrentPhase(new PhaseLevelGameplay(new TestLevel()));
                break;
            case 2:
                break;
            case 3:
                break;
                default: return;
        }
    }

    @Override
    public void update() {}

    @Override
    public void render(Graphics graphics) {}

    @Override
    protected void initialization() {

        this.addRows(firstLine);
        this.addRows(secondLine);
        this.addRows(thirdLine);
    }
}
