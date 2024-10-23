package baseball.app;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class ComputerPlayer implements Player {
    private final int[] numbers;
    private final Set<Integer> numberSet;

    public ComputerPlayer() {
        this.numbers = new int[3];
        this.numberSet = new HashSet<>();
    }

    @Override
    public void play() {
        int startIndex = 0;
        while (numberSet.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (numberSet.add(number)) {
                numbers[startIndex++] = number;
            }
        }
    }

    @Override
    public int[] getNumbers() {
        return numbers;
    }

    public Map<Integer, Integer> getNumbersByMap() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            map.put(number, 0);
        }
        return map;
    }
}