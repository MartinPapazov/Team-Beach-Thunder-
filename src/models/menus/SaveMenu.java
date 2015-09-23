package models.menus;

import PlayerData.PlayerRepository;
import models.Player;
import phases.PhaseManager;
import phases.PhaseMenu;

import javax.swing.*;
import java.awt.*;

public class SaveMenu extends Menu {

    private final static String TITLE = "Save Menu";
    private final static String BACK = "Back to Main menu";
    private PlayerRepository playerRepository;
    private Player[] players;

    public SaveMenu() {
        super(TITLE);
        this.playerRepository = new PlayerRepository();
        this.players = new Player[6];
        this.initialization();
    }

    @Override
    public void enter() {

        switch (this.getCurrentRow()) {
            case 1:
                savePlayer(1);
                break;

            case 2:
                savePlayer(2);
                break;

            case 3:
                savePlayer(3);
                break;

            case 4:
                savePlayer(4);
                break;

            case 5:
                savePlayer(5);
                break;

            case 6:
                savePlayer(6);
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
        super.render(graphics);
        graphics.setColor(Color.YELLOW);
        //graphics.setFont(new Font("Monospaced", 0, 25));
        String nickname = "NICKNAME";
        String level = "LEVEL";
        //String coins = "COINS";
        String lastPlayed = "LAST SAVE";
        String tableTitle = String.format("%-12s%-7s%s", nickname, level, lastPlayed);
        graphics.drawString(tableTitle, 50, 135);

    }

    @Override
    protected void initialization() {
        for (int i = 0; i < players.length; i++) {
            Player player = this.playerRepository.getPlayerById(i + 1);
            this.players[i] = player;
            if (player == null) {
                this.addRows("empty slot");
            } else {

                String playerInfo = String.format("%-12s%-7s%s",
                        player.getName(),
                        player.getLevelsCompleted(),
                        player.getLastSave()
                );
                this.addRows(playerInfo);
            }
        }
        this.addRows(BACK);
    }

    private void savePlayer(int currentRow) {
        Player currentPlayer = PhaseManager.getCurrentPlayer();
        String name = currentPlayer.getName();

        if (name.equals(null) || name.trim().equals("")) {
            currentPlayer.setName(getNameFromUser());
            if (name == null || name.trim() == "") {
                PhaseManager.setCurrentPhase(new PhaseMenu(new MainMenu()));
                return;
            }
        }

        this.playerRepository.setPlayerById(currentRow, currentPlayer);
        PhaseManager.setCurrentPhase((new PhaseMenu(new MainMenu())));
    }

    private String getNameFromUser() {
        String name = JOptionPane.showInputDialog(
                null,
                "Please, enter your nickname",
                "Nickname",
                JOptionPane.INFORMATION_MESSAGE);

        return name;
    }
}
