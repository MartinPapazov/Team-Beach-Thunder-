package models.menus;


import PlayerData.PlayerRepository;
import models.Player;
import phases.PhaseManager;
import phases.PhaseMenu;

import java.awt.*;


public class LoadMenu extends Menu {

    private final static String title = "Load Game";
    private final static String back = "Back to Main menu";
    private PlayerRepository playerRepo;
    private Player player;

    public LoadMenu() {
        super(title);
        this.playerRepo = new PlayerRepository();
        this.initialization();

    }


    @Override
    public void enter() {

        switch (this.getCurrentRow()) {
            case 1:
                loadPlayer(1);
                break;

            case 2:
                loadPlayer(2);
                break;

            case 3:
                loadPlayer(3);
                break;

            case 4:
                loadPlayer(4);
                break;
            case 5:
                loadPlayer(5);
                break;
            case 6:
                loadPlayer(6);
                break;
            case 7:
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
        for (int i = 1; i <= 6; i++) {
            if (isFileExist(i)) {
                Player currentPlayer = this.playerRepo.getPlayerById(i);
                String currentRow = currentPlayer.getName() + "  "
                        + currentPlayer.getLevelsCompleted() + "  "
                        + currentPlayer.getCurrentSpaceship();
                this.addRows(currentRow);
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

    private void loadPlayer(int currentRow) {
        if (isFileExist(currentRow)) {
            this.player = playerRepo.getPlayerById(currentRow);
            PhaseManager.setCurrentPlayer(this.player);
            PhaseManager.setCurrentPhase((new PhaseMenu(new MainMenu())));
        }
    }
}
