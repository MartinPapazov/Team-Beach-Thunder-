package PlayerData;

import models.Player;

import java.util.*;

public class PlayerRepository {

    private Database playerDatabase;

    public PlayerRepository() {

        this.playerDatabase = new Database();
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
        String[] tokens = playerInfo.split("$");

        String playerName = tokens[0];
        String namesOfOwnedSpaceshipsAsStrings = tokens[1];
        int coins = Integer.parseInt(tokens[3]);
        int levelsCompleted = Integer.parseInt(tokens[4]);

        ArrayList<String> namesOfOwnedSpaceships = new ArrayList<>(Arrays.asList(namesOfOwnedSpaceshipsAsStrings.split(",")));
        Player player = new Player(playerName, null, namesOfOwnedSpaceships, coins, levelsCompleted);
        return player;
    }
}
