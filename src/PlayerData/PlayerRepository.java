package PlayerData;

import models.Player;
import models.spaceships.Spaceship;

import java.util.*;

public class PlayerRepository {

    private Database playerDatabase;

    public PlayerRepository() {

        this.setPlayerDatabase(new Database());
    }

    public Database getPlayerDatabase() {
        return playerDatabase;
    }

    public void setPlayerDatabase(Database playerDatabase) {
        this.playerDatabase = playerDatabase;
    }

    public Player getPlayerById(int number) {
        String playerInfo;
        playerInfo = this.playerDatabase.readFromTextFile(number);
        String[] tokens = playerInfo.split(";");

        String playerName = tokens[0];
        String namesOfOwnedSpaceshipsAsStrings = tokens[2];
        int coins = Integer.parseInt(tokens[3]);
        int levelsCompleted = Integer.parseInt(tokens[4]);

        ArrayList<String> namesOfOwnedSpaceships = new ArrayList<>(Arrays.asList(namesOfOwnedSpaceshipsAsStrings.split(",")));
        return new Player(playerName, null, namesOfOwnedSpaceships, coins, levelsCompleted);
    }

    public void setPlayerById(int number, Player player) {

        String namesOfOwnedSpaceshipsAsStrings = String.join(",", player.getNamesOfOwnedSpaceships());
        String playerInfo = player.getName() + ";"
                + player.getCurrentSpaceship() + ";"
                + namesOfOwnedSpaceshipsAsStrings + ";"
                + player.getCoins() + ";"
                + player.getLevelsCompleted();
        this.playerDatabase.writeInTextFile(playerInfo, number);
    }
}
