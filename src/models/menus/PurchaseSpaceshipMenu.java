package models.menus;

import phases.*;

import java.awt.*;

public class PurchaseSpaceshipMenu extends Menu {

    private final static String title = "Store";
    private final static String firstSpaceship = "Test - picture";
    private final static String back = "BACK";

    public PurchaseSpaceshipMenu () {

        super(title);
        this.initialization();
    }

    @Override
    public void enter() {
        switch (this.getCurrentRow()){
            case 1:

                break;
            case 2:
                PhaseManager.setCurrentPhase(new PhaseMenu(new MainMenu()));
                break;
        }

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {

    }

    @Override
    protected void initialization() {
        this.addRows(firstSpaceship);
        this.addRows(back);

    }
}
