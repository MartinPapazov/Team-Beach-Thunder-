package phases;

import models.Player;
import models.menus.MainMenu;
import models.spaceships.playerSpaceships.BlackViper;
import models.spaceships.playerSpaceships.Spacecruiser;

import java.util.ArrayList;

public class PhaseManager {

    private static Phase currentPhase = null;
    private static Player currentPlayer = null;

    public static Phase getCurrentPhase(){
        if (currentPhase == null){
            currentPhase = new PhaseMenu(new MainMenu());
        }
        
        return currentPhase;
    }

    public static void setCurrentPhase(Phase phase){
        currentPhase = phase;
    }

    public static Player getCurrentPlayer() {
        return new Player("Gosho", new BlackViper(50, 50), new ArrayList<String>(),5,5);
    }

    public static void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }
}
