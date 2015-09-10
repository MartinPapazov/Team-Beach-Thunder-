package phases;

import models.menus.MainMenu;

public class PhaseManager {

    private static Phase currentPhase = null;

    public static Phase getCurrentPhase(){
        if (currentPhase == null){
            currentPhase = new PhaseMenu(new MainMenu());
        }
        
        return currentPhase;
    }

    public static void setCurrentPhase(Phase phase){
        currentPhase = phase;
    }
}
