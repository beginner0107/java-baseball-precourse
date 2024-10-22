package baseball.controller;

import baseball.app.GameMachine;
import camp.nextstep.edu.missionutils.Console;

/*
 게임을 시작한다
 */
public class GameController {

    private GameMachine gameMachine;

    public GameController(GameMachine gameMachine) {
        this.gameMachine = gameMachine;
    }

    public void run() {
        while(true) {
            if(!gameMachine.start()) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int command;
                while (true) {
                    try {
                        command = Integer.parseInt(Console.readLine());
                        if (command == 1 || command == 2) break;
                    } catch (NumberFormatException e) {
                        System.out.println("유효한 숫자를 입력하세요.");
                    }
                }
                if (command == 1) continue;
                gameMachine.end();
                break;
            }
        }
    }
}
