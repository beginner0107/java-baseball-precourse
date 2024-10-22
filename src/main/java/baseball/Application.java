package baseball;

import baseball.app.GameMachine;
import baseball.app.enumType.GameType;
import baseball.controller.GameController;
import baseball.service.NumericBaseBallService;

/*
엔티티:
- 게임, 컴퓨터, 플레이어

요구사항:
- 1부터 9까지의 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임

- 스트라이크: 같은 수가 같은 자리에 있으면
- 볼: 다른 자리에 있으면 볼
- 포볼(낫싱): 같은 수가 전혀 없으면 -> 힌트

- 상대 역할: 컴퓨터
- 컴퓨터는 3자리 수 수자를 뽑는다
- 플레이어는 컴퓨터가 뽑은 3자리 숫자를 입력
- 컴퓨터는 입력한 숫자에 대해 결과를 출력
- 다 맞추면 게임 종료

- 게임을 종료한 후에 다시 시작하거나 완전히 종료할 수 있음
- 사용자가 잘못된 값을 입력한 경우: IllegalArgumentException을 발생 시킨 후 애플리케이션 종료
 */
public class Application {
    public static void main(String[] args) {
        GameMachine machine = new GameMachine(GameType.NUMERIC_BASEBALL, new NumericBaseBallService());
        GameController controller = new GameController(machine);
        controller.run();
    }
}
