package playerData;

import models.Player;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class PlayerRepository {

    private Database playerDatabase;

    public PlayerRepository() {

        this.setPlayerDatabase(new Database());
    }

    public void setPlayerDatabase(Database playerDatabase) {
        this.playerDatabase = playerDatabase;
    }

    public Player getPlayerById(int number) {
        String playerInfo = this.playerDatabase.readFromTextFile(number);
        if (playerInfo == null || playerInfo.equals("")) {
            return null;
        }

        String[] tokens = playerInfo.split(";");

        String playerName = tokens[0];
        String namesOfOwnedSpaceshipsAsStrings = tokens[2];
        int coins = Integer.parseInt(tokens[3]);
        int levelsCompleted = Integer.parseInt(tokens[4]);
        String lastSave = tokens[5];

        ArrayList<String> namesOfOwnedSpaceships = new ArrayList<>(Arrays.asList(namesOfOwnedSpaceshipsAsStrings.split(",")));
        return new Player(playerName, null, namesOfOwnedSpaceships, coins, levelsCompleted,lastSave);
    }

    public void setPlayerById(int number, Player player) {

        String namesOfOwnedSpaceshipsAsStrings = String.join(",", player.getNamesOfOwnedSpaceships());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        Date date = new Date();
        String lastPlayerSavedDateAndTime = dateFormat.format(date);
        String playerInfo = player.getName() + ";"
                + player.getCurrentSpaceship().getName() + ";"
                + namesOfOwnedSpaceshipsAsStrings + ";"
                + player.getCoins() + ";"
                + player.getLevelsCompleted() + ";" + lastPlayerSavedDateAndTime;


        this.playerDatabase.writeInTextFile(playerInfo, number);
    }
}
