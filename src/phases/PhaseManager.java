package phases;

import models.Player;
import models.menus.MainMenu;
import models.spaceships.Spaceship;
import models.spaceships.playerSpaceships.BlackViper;
import models.spaceships.playerSpaceships.RH5;
import models.spaceships.playerSpaceships.Spacecruiser;

import java.util.ArrayList;

public class PhaseManager {

    private static Phase currentPhase = null;
    private static Player currentPlayer = null;

    public static Phase getCurrentPhase() {
        if (currentPhase == null) {
            currentPhase = new PhaseMenu(new MainMenu());
        }

        return currentPhase;
    }

    public static void setCurrentPhase(Phase phase) {
        currentPhase = phase;
    }

    public static Player getCurrentPlayer() {
        //String nameOfCurrentSpaceship = currentPlayer.getNamesOfOwnedSpaceships().get(0);
        //if (nameOfCurrentSpaceship.equals(null)) {
        //    //TODO: return default spaceship
        //}
        //
        //Spaceship defaultSpaceship = getDefaultSpaceship(nameOfCurrentSpaceship);
        //currentPlayer.setCurrentSpaceship(defaultSpaceship);
        //return currentPlayer;
        return new Player("Gosho", new BlackViper(50, 50), new ArrayList<String>(),5,5);
    }

    public static void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    private static Spaceship getDefaultSpaceship(String nameOfSpaceship) {
        switch (nameOfSpaceship) {
            case "Spacecruiser":
                return new Spacecruiser(10, 100);
            case "RH5":
                return new RH5(10, 100);
            case "Blackviper":
                return new BlackViper(10, 100);
            default:
                return null;
        }
    }
}
