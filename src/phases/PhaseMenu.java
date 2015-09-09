package phases;

import java.awt.*;

public class PhaseMenu extends Phase{
    private int x = 10;
    @Override
    public void update() {
        this.x += 1;
    }

    @Override
    public void render(Graphics graphics) {

    }
}
