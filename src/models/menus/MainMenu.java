package models.menus;

import audio.AudioAssets;
import models.levels.EnemySpaceshipsTestLevel;
import models.levels.FirstLevel;
import phases.*;
import sun.audio.AudioData;
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
        super( title);
        this.menuMusic = AudioAssets.getMenuMusic();
        this.initialization();
    }

    @Override
    public void enter() {

        switch (this.getCurrentRow()) {
            case 1:
                AudioPlayer.player.stop(this.menuMusic);
                //if (PhaseManager.getCurrentPlayer() == null){
                //TODO: PhaseManager.setCurrentPhase(LoadPlayerPhase) Load palyer phase need to be created.
                //}
                //else {
                PhaseManager.setCurrentPhase(new PhaseLevelGameplay(new FirstLevel()));
                //}
                break;
            case 2:
                //Testing only
                PhaseManager.setCurrentPhase(new PhaseMenu(new LoadMenu()) {
                });
                break;
            case 3:
                break;
            case 4:
                PhaseManager.setCurrentPhase(new PhaseMenu(new PurchaseSpaceshipMenu()));
                break;
            case 5:
                System.exit(0);
                break;
            case 6:
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
