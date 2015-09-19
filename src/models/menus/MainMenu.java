package models.menus;

import audio.AudioAssets;
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
    private final static String fifthLine = "EXIT";
    private final static String testingSpaceships = "Testing enemy spaceships";


    private InputStream menuMusic;

    public MainMenu() {
        super(title);
        this.menuMusic = AudioAssets.getMenuMusic();
        this.initialization();
    }

    @Override
    public void enter() {

        switch (this.getCurrentRow()) {
            case 1:
                AudioPlayer.player.stop(this.menuMusic);

                //TODO: need to be changed! Testing only!
                PhaseManager.setCurrentPhase(new PhaseLevelGameplay(new ThirdLevel()));
                break;
            case 2:
                AudioPlayer.player.stop(this.menuMusic);
                //Testing only
                PhaseManager.setCurrentPhase(new PhaseLoadMenu(new LoadMenu()) {
                });
                break;
            case 3:
                AudioPlayer.player.stop(this.menuMusic);
                PhaseManager.setCurrentPhase(new PhaseSaveMenu(new SaveMenu()));
                break;
            case 4:
                AudioPlayer.player.stop(this.menuMusic);
                PhaseManager.setCurrentPhase(new PhaseMenu(new PurchaseSpaceshipMenu()));
                break;
            case 5:
                AudioPlayer.player.stop(this.menuMusic);
                System.exit(0);
                break;
            case 6:
                AudioPlayer.player.stop(this.menuMusic);
                PhaseManager.setCurrentPhase(new PhaseLevelGameplay(new EnemySpaceshipsTestLevel()));
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

        AudioPlayer.player.start(this.menuMusic);
        this.addRows(firstLine);
        this.addRows(secondLine);
        this.addRows(thirdLine);
        this.addRows(forthLine);
        this.addRows(fifthLine);
        this.addRows(testingSpaceships);
    }
}
