package models.menus;

import models.levels.FirstLevel;
import phases.*;

import java.awt.*;

public class PauseMenu extends Menu {

    private final static String title = "Pause Menu";
    private final static String RESUME = "Resume";
    private final static String SAVE = "Save Game";
    private final static String MAIN_MENU = "Back to Main Menu";
    private final static String QUIT = "Quit";

    private Phase currentPhase;


    public PauseMenu(Phase currentPhase) {
        super(title);
        this.currentPhase = currentPhase;
        ((PhaseLevelGameplay)this.currentPhase).deactivateInputHandler();
        this.initialization();
    }

    @Override
    public void enter() {
        switch (this.getCurrentRow()) {
            case 1:
                ((PhaseLevelGameplay)this.currentPhase).activateInputHandler();
                PhaseManager.setCurrentPhase(this.currentPhase);
                break;
            case 2:
                PhaseManager.setCurrentPhase(new PhaseMenu(new MainMenu()));
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }

    @Override
    protected void initialization() {
        this.addRows(RESUME);
        this.addRows(MAIN_MENU);
        this.addRows(QUIT);
    }
}

