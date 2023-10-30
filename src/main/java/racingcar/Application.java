package racingcar;

public class Application {
    public static void main(String[] args) {
        GameInterface game = new RacingCarGame();

        game.initialize();
        game.start();
    }
}
