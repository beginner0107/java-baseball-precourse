package baseball.app;

import java.util.Map;

// 1. 숫자를 카운트
// 2. 숫자야구가 끝났는지 확인
// 1. 숫자를 카운트
// 2. 숫자야구가 끝났는지 확인
public class CounterMachine {
    private final HumanPlayer human;
    private final ComputerPlayer computer;

    public CounterMachine(HumanPlayer human, ComputerPlayer computer) {
        this.human = human;
        this.computer = computer;
        computer.play();
    }

    public boolean isEnd() {
        int[] humanPickNumbers = human.getNumbers();
        int[] computerPickNumbers = computer.getNumbers();
        Map<Integer, Integer> computerPickNumbersMap = computer.getNumbersByMap();

        for (int i = 0; i < humanPickNumbers.length; i++) {
            updateCounter(humanPickNumbers[i], computerPickNumbers[i], computerPickNumbersMap);
        }

        return human.getCounter().isThreeStrike();
    }

    private void updateCounter(int humanNumber, int computerNumber, Map<Integer, Integer> computerPickNumbersMap) {
        Counter counter = human.getCounter();
        if (humanNumber == computerNumber) {
            counter.increaseStrike();
        } else if (computerPickNumbersMap.containsKey(humanNumber)) {
            counter.increaseBall();
        }
    }


    public void getResult() {
        Counter counter = human.getCounter();
        String result = calculateResult(counter);
        System.out.println(result);
    }

    String calculateResult(Counter counter) {
        if (counter.isThreeStrike()) {
            return String.format(Constant.OUTPUT_STRIKE_COUNT, counter.getStrike());
        }
        if (counter.isThreeBall()) {
            return String.format(Constant.OUTPUT_BALL_COUNT, counter.getBall());
        }
        if (counter.isNothing()) {
            return Constant.OUTPUT_NOTHING;
        }
        if (counter.getBall() == 0 && counter.getStrike() != 0) {
            return String.format(Constant.OUTPUT_STRIKE_COUNT, counter.getStrike());
        }
        if (counter.getBall() != 0 && counter.getStrike() == 0) {
            return String.format(Constant.OUTPUT_BALL_COUNT, counter.getBall());
        }
        return String.format(Constant.OUTPUT_BALL_COUNT + " " + Constant.OUTPUT_STRIKE_COUNT, counter.getBall(), counter.getStrike());
    }

}
