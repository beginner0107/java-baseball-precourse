package baseball.app;

import camp.nextstep.edu.missionutils.Console;

public class HumanPlayer implements Player {
    private final int[] numbers;
    private Counter counter;
    private final static int limit = 3;

    public HumanPlayer() {
        this.numbers = new int[limit];
    }

    @Override
    public void play() {
        counter = new Counter();
        String[] splitNumbers = Console.readLine().trim().split("");
        if (splitNumbers.length != limit) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }

        isCheckNumbers(splitNumbers);
    }

    private void isCheckNumbers(String[] splitNumbers) {
        try {
            for (int i = 0; i < limit; i++) {
                numbers[i] = Integer.parseInt(splitNumbers[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    @Override
    public int[] getNumbers() {
        return numbers;
    }

    public Counter getCounter() {
        return counter;
    }
}
