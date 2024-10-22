package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Player{
    @Override
    public List<Integer> pickNumbers() {
        // 랜덤으로 숫자 3개를 뽑는다.
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return numbers;
    }
}
