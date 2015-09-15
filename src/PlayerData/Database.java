package PlayerData;

import java.io.*;

public class Database {

    public String readFromTextFile(int fileNumber) {
        String filePath = String.format("resources\\PlayerFiles\\" + fileNumber + ".txt");
        File file = new File(filePath);

        String line = "";
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            line = bufferedReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public void writeInTextFile(String playerInfo, int fileNumber) {

        String filePath = String.format("resources\\PlayerFiles\\" + fileNumber + ".txt");
        try {
            PrintWriter writer;
            writer = new PrintWriter(filePath);
            writer.print(playerInfo);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

