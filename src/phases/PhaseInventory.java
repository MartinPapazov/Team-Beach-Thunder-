package phases;

import models.inventorys.Inventory;

import java.awt.*;

public class PhaseInventory extends Phase {

    private Inventory inventory;

    public PhaseInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void update() {
        this.inventory.update();
    }

    @Override
    public void render(Graphics graphics) {

        this.inventory.render(graphics);

    }
}
