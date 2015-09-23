package models.inventorys;

import display.Display;
import models.levels.*;
import phases.PhaseInventory;
import phases.PhaseLevelGameplay;
import phases.PhaseManager;

import javax.swing.*;

public class LevelInventory extends Inventory {
    private Level[][] levels;

    @Override
    public void enter() {
        Level level = this.levels[this.getCurrentCol()][this.getCurrentRow()];
        if (this.getLocks()[this.getCurrentCol()][this.getCurrentRow()]) {
            PhaseManager.setCurrentPhase(new PhaseLevelGameplay(level));
            Display.getInstance().getCanvas().removeKeyListener(this.getHandler());
        } else {
            JOptionPane.showMessageDialog(null,
                    "You have to complete previous level to unlock this level.",
                    "Level locked!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void getBack() {
        PhaseManager.setCurrentPhase(new PhaseInventory(new SpaceshipInventory()));
        Display.getInstance().getCanvas().removeKeyListener(this.getHandler());
    }

    @Override
    protected void initialization() {
        this.levels = new Level[3][3];
        boolean[][] locks = this.getLockedLevels();
        this.levels[0][0] = new FirstLevel();
        this.levels[1][0] = new SecondLevel();
        this.levels[2][0] = new ThirdLevel();
        this.levels[0][1] = new FourthLevel();
        this.levels[1][1] = new FifthLevel();
        this.levels[2][1] = new SixthLevel();
        this.levels[0][2] = new SeventhLevel();
        this.levels[1][2] = new EigthLevel();
        this.levels[2][2] = new NinthLevel();
        this.addObjectsToInformationalInventory(levels, locks);
    }

    private boolean[][] getLockedLevels() {
        boolean[][] locks = new boolean[3][3];
        int levelsCompleted = PhaseManager.getCurrentPlayer().getLevelsCompleted();
        int count = 1;
        for (int i = 0; i < locks.length; i++) {
            for (int j = 0; j < locks[i].length; j++) {
                if (count <= levelsCompleted) {
                    locks[j][i] = true;
                    count++;
                } else {
                    return locks;
                }
            }
        }
        return locks;
    }
}
