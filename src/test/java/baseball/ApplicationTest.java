package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;


class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_입력시_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12a"))  // 숫자가 아닌 값 입력
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("잘못된 값을 입력하였습니다.")
        );
    }

    @Test
    void 중복된_숫자_입력시_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))  // 중복된 숫자 입력
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("중복되지 않은 숫자를 입력해야 합니다.")
        );
    }

    @Test
    void 첫_시도에_정답_맞추기() {
        assertRandomNumberInRangeTest(
                () -> {
                    try (MockedStatic<Console> consoleMock = mockStatic(Console.class)) {
                        // 첫 시도에 "135"을 입력하고, 게임 종료 후 "2"를 입력하여 종료 시뮬레이션
                        consoleMock.when(Console::readLine).thenReturn("135", "2");

                        run("135");  // 첫 시도에 3스트라이크
                        assertThat(output()).contains("3스트라이크", "게임 종료");
                    }
                },
                1, 3, 5  // 컴퓨터가 선택한 랜덤 값
        );
    }

    @Test
    void 잘못된_숫자_길이_입력시_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12345"))  // 4자리 입력 (잘못된 길이)
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("잘못된 값을 입력하였습니다.")
        );
    }

    @Test
    void 여러번의_시도후_게임_종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "456", "789", "135", "2");  // 여러 번의 시도 후 종료
                    assertThat(output()).contains("낫싱", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5  // 컴퓨터가 선택한 랜덤 값
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
