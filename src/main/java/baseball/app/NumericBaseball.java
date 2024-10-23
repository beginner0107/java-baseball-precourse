package baseball.app;

import camp.nextstep.edu.missionutils.Console;

import static baseball.app.Command.*;
import static baseball.app.Constant.*;

public class NumericBaseball implements Game {

    private NumericBaseball() {}

    public static NumericBaseball getInstance() {
        return new NumericBaseball();
    }

    @Override
    public void start() {
        HumanPlayer human = new HumanPlayer();
        ComputerPlayer computer = new ComputerPlayer();
        CounterMachine machine = new CounterMachine(human, computer);
        playGame(machine, human);
        promptReplay();
    }

    // 게임을 진행하는 메서드 분리
    private void playGame(CounterMachine machine, HumanPlayer human) {
        boolean isReplay = false;
        while (!isReplay) {
            System.out.println(ENTER_NUMBERS_PROMPT);
            human.play();
            isReplay = machine.isEnd();
            machine.getResult();
        }
    }

    // 재시작 여부를 묻는 메서드 분리
    private void promptReplay() {
        System.out.println(THREE_STRIKE_SUCCESS);
        System.out.println(RESTART_OR_END);
        Command command = find(Console.readLine());
        if (command.equals(RESTART)) {
            start(); // 재귀적으로 게임을 다시 시작
        }
    }
}
