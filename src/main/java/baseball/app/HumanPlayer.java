package baseball.app;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

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

        checkNumberFormat(splitNumbers);  // 숫자 형식 확인
        checkForDuplicateNumbers();  // 중복 여부 확인
    }

    private void checkNumberFormat(String[] splitNumbers) {
        try {
            for (int i = 0; i < limit; i++) {
                numbers[i] = Integer.parseInt(splitNumbers[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    private void checkForDuplicateNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("중복되지 않은 숫자를 입력해야 합니다.");
            }
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
