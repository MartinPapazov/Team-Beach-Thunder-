import Utilitys.Constants;
import game.Core;

public class Launcher {

    public static void main(String[] args) {
        Core engine = new Core(Constants.Title, Constants.WindowWidth, Constants.WindowHeight);
        engine.start();

    }
}
