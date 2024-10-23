package baseball.app;

import java.util.Arrays;

public enum Command {
    RESTART(1),
    TERMINATE(2);

    private final int command;

    Command(int command) {
        this.command = command;
    }


    public static Command find(String com) {
        int number = checkNumber(com);
        return Arrays.stream(Command.values())
                .filter(c -> c.command == number)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static int checkNumber(String com) {
        try {
            return Integer.parseInt(com);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

}
