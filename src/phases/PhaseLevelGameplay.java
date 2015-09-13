package phases;

import models.levels.Level;
import models.spaceships.Spaceship;

import java.awt.*;

/**
 * Created by Martin home on 9/13/2015.
 */
public class PhaseLevelGameplay extends Phase {

    private Level level;
    //TODO: Player field
    private Spaceship playerSpaceShip;



    public PhaseLevelGameplay(Level level) {
        this.level = level;
        //TODO: Player Spaceship need to be added to PlayerInputHandler
        //TODO:
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {

    }
}
