package models.inventorys;

import models.levels.*;
import phases.PhaseLevelGameplay;
import phases.PhaseManager;

public class LevelInventory extends Inventory {
    private Level[][] levels;
    @Override
    public void enter() {
        Level level = this.levels[this.getCurrentCol()][this.getCurrentRow()];
        PhaseManager.setCurrentPhase(new PhaseLevelGameplay(level));
    }

    @Override
    protected void initialization() {
        this.levels = new Level[3][3];
        this.levels[0][0] = new FirstLevel();
        this.levels[0][1] = new SecondLevel();
        this.levels[0][2] = new ThirdLevel();
        this.levels[1][0] = new FourthLevel();
        this.levels[1][1] = new FifthLevel();
        this.levels[1][2] = new SixthLevel();
        this.levels[2][0] = new SeventhLevel();
        this.levels[2][1] = new EigthLevel();
        this.levels[2][2] = new NinthLevel();
        this.addObjectsToInformationalInventory(levels);
    }
}
