package baseball;

import baseball.app.NumericBaseball;

public class Application {
    public static void main(String[] args) {
        NumericBaseball game = NumericBaseball.getInstance();
        game.start();
    }
}
