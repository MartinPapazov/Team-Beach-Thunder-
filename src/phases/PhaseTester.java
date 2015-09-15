package phases;

import PlayerData.PlayerRepository;
import models.Player;

import java.awt.*;

public class PhaseTester extends Phase {

    Player player;

    public PhaseTester() {
        PlayerRepository repo = new PlayerRepository();
        this.player = repo.getPlayerById(1);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawString(player.getName(), 100, 100);
        graphics.drawString(Integer.toString(player.getCoins()), 200, 200);
    }
}
