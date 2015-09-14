import Utilitys.Constants;
import game.Core;

import java.awt.*;

public class Launcher {

    public static void main(String[] args) {
        Core engine = new Core(Constants.Title, Constants.WindowWidth, Constants.WindowHeight);
        engine.start();

    }
}
