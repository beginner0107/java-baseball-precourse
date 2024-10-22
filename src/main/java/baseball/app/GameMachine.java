package baseball.app;

import baseball.app.enumType.GameType;
import baseball.entity.Computer;
import baseball.entity.Person;
import baseball.service.NumericBaseBallService;

import java.util.List;
import java.util.Scanner;

public class GameMachine implements Game {

    private GameType gameType;
    private NumericBaseBallService numericBaseBallService;

    private GameMachine(){}

    public GameMachine(GameType gameType, NumericBaseBallService numericBaseBallService) {
        this.gameType = gameType;
        this.numericBaseBallService = numericBaseBallService;
    }

    @Override
    public boolean start() {
        try {
            Computer computer = new Computer();
            Person person = new Person();
            List<Integer> computerNumbers = computer.pickNumbers();
            while(true) {
                System.out.println("숫자를 입력해주세요.");
                List<Integer> personNumbers = person.pickNumbers();
                int[] numbers = numericBaseBallService.matchesNumbers(computerNumbers, personNumbers);
                if (numbers[2] == 3) System.out.println("낫싱");
                if (numbers[0] == 0 && numbers[1] != 0) System.out.printf("%d스트라이크%n", numbers[1]);
                if (numbers[0] != 0 && numbers[1] == 0) System.out.printf("%d볼%n", numbers[0]);
                if (numbers[0] != 0 && numbers[1] != 0) System.out.printf("%d볼 %d스트라이크%n", numbers[0],  numbers[1]);

                if (numbers[1] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            return false;
        }
    }

    @Override
    public void end() {
    }
}
