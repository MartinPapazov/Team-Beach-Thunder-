import game.Core;

public class Launcher {

    public static void main(String[] args) {
        Core engine = new Core("Game", 900, 600);
        engine.start();

    }
}
