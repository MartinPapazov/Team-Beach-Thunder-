package phases;

public class PhaseManager {

    private static Phase currentPhase = null;

    public static Phase getCurrentPhase(){
        if (currentPhase == null){
            currentPhase = new TestingPhase();
        }
        
        return currentPhase;
    }

    public static void setCurrentPhase(Phase phase){
        currentPhase = phase;
    }
}
