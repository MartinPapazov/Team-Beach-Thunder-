import game.Core;

public class Launcher {

    public static void main(String[] args) {
        Core engine = new Core("Game", 200, 200);
        engine.start();

    }
}
