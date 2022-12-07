package baseball.controller;

import baseball.controller.services.BaseballGame;
import baseball.model.Computer;
import baseball.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    private BaseballGame baseballGame;

    static Stream<Arguments> createBaseballGameData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), "456", 0, 0),
                Arguments.of(Arrays.asList(1, 2, 3), "451", 1, 0),
                Arguments.of(Arrays.asList(1, 2, 3), "431", 2, 0),
                Arguments.of(Arrays.asList(1, 2, 3), "231", 3, 0),
                Arguments.of(Arrays.asList(1, 2, 3), "134", 1, 1),
                Arguments.of(Arrays.asList(1, 2, 3), "132", 2, 1),
                Arguments.of(Arrays.asList(1, 2, 3), "124", 0, 2),
                Arguments.of(Arrays.asList(1, 2, 3), "123", 0, 3)
        );
    }

    @DisplayName("볼,스트라이크 개수를 정상적으로 세는지 확인.")
    @ParameterizedTest
    @MethodSource("createBaseballGameData")
    void 볼_스트라이크_개수_세기(List<Integer> computerNumbers, String userNumbers, int ball, int strike) {
        User user = new User(userNumbers);

        assertRandomNumberInRangeTest(
                () -> {
                    Computer computer = new Computer();
                    baseballGame = new BaseballGame(computer);
                    GameResult gameResult = baseballGame.compareNumbers(user);

                    assertThat(gameResult.getBall()).isEqualTo(ball);
                    assertThat(gameResult.getStrike()).isEqualTo(strike);
                },
                computerNumbers.get(0), computerNumbers.get(1), computerNumbers.get(2)
        );
    }
}
