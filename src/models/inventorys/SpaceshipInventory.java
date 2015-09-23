package models.inventorys;

import display.Display;
import models.Player;
import models.menus.MainMenu;
import models.spaceships.Spaceship;
import models.spaceships.playerSpaceships.*;
import phases.PhaseInventory;
import phases.PhaseManager;
import phases.PhaseMenu;

import javax.swing.*;


public class SpaceshipInventory extends Inventory {

    private static final int defaultX = 50;
    private static final int defaultY = 250;
    private Spaceship[][] spaceships;


    public SpaceshipInventory() {
        super();

    }
    @Override
    public void enter() {
        Spaceship spaceship = this.spaceships[this.getCurrentCol()][this.getCurrentRow()];
        PhaseManager.getCurrentPlayer().setCurrentSpaceship(spaceship);
        if (this.getLocks()[this.getCurrentCol()][this.getCurrentRow()]) {
            PhaseManager.setCurrentPhase(new PhaseInventory(new LevelInventory()));
            Display.getInstance().getCanvas().removeKeyListener(this.getHandler());
            return;
        }

        this.buySpaceship(spaceship);

    }

    @Override
    public void getBack() {
        PhaseManager.setCurrentPhase(new PhaseMenu(new MainMenu()));
        Display.getInstance().getCanvas().removeKeyListener(this.getHandler());
    }

    @Override
    protected void initialization() {
        this.spaceships = new Spaceship[3][3];
        boolean[][] locks = new boolean[3][3];
        Player player = PhaseManager.getCurrentPlayer();
        this.spaceships[0][0] = new Spacecruiser(defaultX,defaultY);
        locks[0][0] = player.getNamesOfOwnedSpaceships().contains("Spacecruiser");
        this.spaceships[1][0] = new BlackViper(defaultX,defaultY);
        locks[1][0] = player.getNamesOfOwnedSpaceships().contains("Black Viper");
        this.spaceships[2][0] = new RH5(defaultX, defaultY);
        locks[2][0] = player.getNamesOfOwnedSpaceships().contains("RH5");
        this.spaceships[0][1] = new DownFighter(defaultX, defaultY);
        locks[0][1] = player.getNamesOfOwnedSpaceships().contains("DownFighter");
        this.spaceships[1][1] = new Slayer(defaultX, defaultY);
        locks[1][1] = player.getNamesOfOwnedSpaceships().contains("Slayer");
        this.spaceships[2][1] = new MoonStalker(defaultX, defaultY);
        locks[2][1] = player.getNamesOfOwnedSpaceships().contains("Moon Stalker");
        this.spaceships[0][2] = new RedHover(defaultX, defaultY);
        locks[0][2] = player.getNamesOfOwnedSpaceships().contains("RedHover");

        this.addObjectsToInformationalInventory(spaceships, locks);
    }

    private void buySpaceship(Spaceship spaceship) {
        String question = "Do you want to buy " + spaceship.getName() + "?";
        int answer = JOptionPane.showConfirmDialog(null, question, "Confirm payment.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (answer == JOptionPane.YES_OPTION) {
            Player player = PhaseManager.getCurrentPlayer();
            boolean isPlayerHaveEnoughMoney = player.getCoins() < spaceship.getCoins();
            if (isPlayerHaveEnoughMoney) {
                JOptionPane.showMessageDialog(null, "You don't have enough money!", "Not enough money!", 1);
            } else {
                int playerLeftCoins = player.getCoins() - spaceship.getCoins();
                player.addNewSpaceShip(spaceship.getName());
                player.setCoins(playerLeftCoins);
                this.getLocks()[this.getCurrentCol()][this.getCurrentRow()] = true;
            }
        }
    }

}
