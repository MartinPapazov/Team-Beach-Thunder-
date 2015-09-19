package models.menus;


import PlayerData.PlayerRepository;
import Utilitys.Constants;
import models.Player;
import phases.PhaseManager;
import phases.PhaseMenu;

import java.awt.*;


public class LoadMenu extends Menu {

    private final static String title = "Load Game";
    private final static String back = "Back to Main menu";
    private PlayerRepository playerRepo;
    private Player[] players;


    public LoadMenu() {
        super(title);
        this.playerRepo = new PlayerRepository();
        this.players = new Player[6];
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
        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font("Monospaced", 0, 25));
        String tableTitle = "nickname           level   coins   last time played";
        graphics.drawString(tableTitle,50, 135);
    }

    @Override
    protected void initialization() {
        for (int i = 0; i < players.length; i++) {
            Player player = this.playerRepo.getPlayerById(i + 1);
            this.players[i] = player;
            if (player == null) {
                this.addRows("empty slot");
            } else {
                this.addRows(player.getName());
            }
        }

        this.addRows(back);
    }

    private void loadPlayer(int currentRow) {
            PhaseManager.setCurrentPlayer(this.players[currentRow - 1]);
            PhaseManager.setCurrentPhase((new PhaseMenu(new MainMenu())));
    }
}
