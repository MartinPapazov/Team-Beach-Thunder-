package phases;

import models.Player;
import models.menus.MainMenu;

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
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }
}
