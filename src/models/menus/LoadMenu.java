package models.menus;


import PlayerData.PlayerRepository;
import models.Player;
import models.levels.FirstLevel;
import models.levels.Level;
import phases.PhaseLevelGameplay;
import phases.PhaseManager;
import phases.PhaseMenu;

import java.awt.*;


public class LoadMenu extends Menu {

    private final static String title = "Load Game";
    private final static int rows = 8;
    private final static String back = "Back";
    private PlayerRepository playerRepo;
    private Player player;

    public LoadMenu() {
        super(rows, title);
        this.playerRepo = new PlayerRepository();
        this.initialization();

    }


    @Override
    public void enter() {
        Level currentPlayerLevel;
        boolean isExistPlayer;
        switch (this.getCurrentRow()) {
            case 1:
                isExistPlayer = isFileExist(1);
                if (isExistPlayer) {
                    this.player = playerRepo.getPlayerById(1);
                    currentPlayerLevel = getCurrentPlayerLevel(this.player);
                    PhaseManager.setCurrentPhase(new PhaseLevelGameplay(currentPlayerLevel));
                }
                break;

            case 2:
                isExistPlayer = isFileExist(2);
                if (isExistPlayer) {
                    this.player = playerRepo.getPlayerById(2);
                    currentPlayerLevel = getCurrentPlayerLevel(this.player);
                    PhaseManager.setCurrentPhase(new PhaseLevelGameplay(currentPlayerLevel));
                }
                break;

            case 3:
                isExistPlayer = isFileExist(3);
                if (isExistPlayer) {
                    this.player = playerRepo.getPlayerById(3);
                    currentPlayerLevel = getCurrentPlayerLevel(this.player);
                    PhaseManager.setCurrentPhase(new PhaseLevelGameplay(currentPlayerLevel));
                }
                break;

            case 4:

                break;
            case 5:

                break;
            case 6:

            case 7:
                break;
            case 8:
                PhaseManager.setCurrentPhase((new PhaseMenu(new MainMenu())));
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
        for (int i = 1; i <= 7; i++) {
            if (isFileExist(i)) {
                this.addRows(this.playerRepo.getPlayerById(i).getName());
            } else {
                this.addRows("empty slot");
            }
        }

        this.addRows(back);

    }

    private boolean isFileExist(int number) {
        try {
            this.playerRepo.getPlayerById(number);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    private Level getCurrentPlayerLevel(Player player) {
        Level levelForLoading = null;
        if (player.getLevelsCompleted() == 1) {
            levelForLoading = new FirstLevel();
        }
        //TODO : For other levels
        return levelForLoading;
    }
}
