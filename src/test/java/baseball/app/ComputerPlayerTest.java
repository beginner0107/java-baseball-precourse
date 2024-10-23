package baseball.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    private ComputerPlayer computerPlayer;

    @BeforeEach
    void setUp() {
        computerPlayer = new ComputerPlayer();
    }

    @Test
    @DisplayName("컴퓨터가 3개의 랜덤 숫자를 생성한다")
    void play() {
        computerPlayer.play();
        int[] numbers = computerPlayer.getNumbers();

        assertEquals(3, numbers.length);
        assertTrue(numbers[0] > 0 && numbers[0] < 10);
        assertTrue(numbers[1] > 0 && numbers[1] < 10);
        assertTrue(numbers[2] > 0 && numbers[2] < 10);
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자는 Map 형태로 반환된다")
    void getNumbersByMap() {
        computerPlayer.play();

        Map<Integer, Integer> numberMap = computerPlayer.getNumbersByMap();

        assertEquals(3, numberMap.size());
    }
}
