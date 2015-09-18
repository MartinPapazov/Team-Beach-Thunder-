package models.menus;

import contracts.Informational;

import java.awt.*;

public class SpaceshipStoreMenu extends Store  {

    private Informational[][] shipsInStore;

    protected SpaceshipStoreMenu(int rowsInMenu, int colsInMenu, String title,Informational[][] aviableShips) {
        super(rowsInMenu, colsInMenu, title);
        StoreShipsInit(aviableShips);
    }

    @Override
    public void enter() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {

    }

    @Override
    protected void initialization() {

    }

    private void StoreShipsInit(Informational[][] aviableShips){
        int rows = aviableShips.length;
        int cols = aviableShips[rows].length;

        this.shipsInStore = new Informational[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols ; col++) {
                this.shipsInStore[row][col] = aviableShips[row][col];
            }
        }
    }
}
