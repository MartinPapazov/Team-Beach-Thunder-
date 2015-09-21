package models.menus;

import audio.AudioAssets;
import graphics.Assets;
import models.inventorys.SpaceshipInventory;
import models.levels.*;
import phases.*;
import sun.audio.AudioPlayer;

import java.awt.*;
import java.io.InputStream;

public class MainMenu extends Menu {

    private final static String title = "Main menu";
    private final static String firstLine = "Play";
    private final static String secondLine = "Load game";
    private final static String thirdLine = "Save game";
    private final static String forthLine = "Profile";
    private final static String fifthLine = "Quit";
    private final static String testingSpaceships = "Testing enemy spaceships";



    public MainMenu() {
        super(title);
        this.initialization();
    }

    @Override
    public void enter() {

        switch (this.getCurrentRow()) {
            case 1:
                PhaseManager.setCurrentPhase(new PhaseInventory(new SpaceshipInventory()));
                break;
            case 2:

                //Testing only
                PhaseManager.setCurrentPhase(new PhaseMenu(new LoadMenu()) {
                });
                break;
            case 3:

                PhaseManager.setCurrentPhase(new PhaseMenu(new SaveMenu()));
                break;
            case 4:

                PhaseManager.setCurrentPhase(new PhaseInventory(new SpaceshipInventory()));
                break;
            case 5:
                System.exit(0);
                break;
            case 6:

                PhaseManager.setCurrentPhase(new PhaseMenu(new PauseMenu()));
            default:
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
        AudioPlayer.player.stop(AudioAssets.menuStream);
        AudioPlayer.player.start(AudioAssets.menuStream);
        this.addRows(firstLine);
        this.addRows(secondLine);
        this.addRows(thirdLine);
        this.addRows(forthLine);
        this.addRows(fifthLine);
        this.addRows(testingSpaceships);
    }
}
