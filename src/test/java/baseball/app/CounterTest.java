package baseball.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    private Counter counter;

    @BeforeEach
    void setUp() {
        counter = new Counter();
    }

    @Test
    @DisplayName("스트라이크가 정상적으로 증가한다")
    void increaseStrike() {
        counter.increaseStrike();

        assertEquals(1, counter.getStrike());
    }

    @Test
    @DisplayName("볼이 정상적으로 증가한다")
    void increaseBall() {
        counter.increaseBall();

        assertEquals(1, counter.getBall());
    }

    @Test
    @DisplayName("3 스트라이크가 되면 true를 반환한다")
    void isThreeStrike() {
        counter.increaseStrike();
        counter.increaseStrike();

        counter.increaseStrike();

        assertTrue(counter.isThreeStrike());
    }

    @Test
    @DisplayName("스트라이크와 볼이 모두 0일 때 낫싱을 반환한다")
    void isNothing() {
        assertTrue(counter.isNothing());
    }
}
