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
        //if (currentPlayer == null) {
        //    currentPlayer = new Player();
        //}

<<<<<<< HEAD
        return new Player("Gosho", new Spacecruiser(50, 50), new ArrayList<>(),5,5,"-");
=======
        return new Player("", new BlackViper(50, 50), new ArrayList<>(),5,5,"-");
>>>>>>> 5ac92e8b468bb9054c7890d8be964e74751406b2
        //TODO: return currentPlayer;
    }

    public static void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }
}
