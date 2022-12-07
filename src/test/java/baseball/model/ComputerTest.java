package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("무작위로 만들어지는 컴퓨터 Numbers와 public 메소드가 정상적인지 확인한다.")
public class ComputerTest {
    private Computer computer;
    private List<Integer> computerNumbers;

    void 컴퓨터_숫자_생성() {
        computer = new Computer();
        computerNumbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 10; j++) {
                if (computer.isSamePositionSameValue(i, j)) {
                    computerNumbers.add(j);
                    break;
                }
            }
        }
    }

    @DisplayName("자릿수 중복없이 숫자가 만들어지는지 확인한다.")
    @RepeatedTest(50)
    void 중복없는_3자리_숫자인지_검사() {
        컴퓨터_숫자_생성();
        assertThat(computerNumbers.size() == computerNumbers.stream().distinct().count()).isTrue();
    }

    @DisplayName("같은 위치에 같은 값(스트라이크)인지 검사한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "2:3"}, delimiter = ':')
    void 스트라이크_검사(int position,int number) {
        assertRandomNumberInRangeTest(
                () -> {
                    컴퓨터_숫자_생성();
                    assertThat(computer.isSamePositionSameValue(position, number)).isTrue();
                },
                1, 2, 3
        );
    }

    @DisplayName("다른 위치에 같은 값(볼)인지 검사한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:3", "2:1"}, delimiter = ':')
    void 볼_검사(int position,int number) {
        assertRandomNumberInRangeTest(
                () -> {
                    컴퓨터_숫자_생성();
                    assertThat(computer.isDifferentPositionSameValue(position, number)).isTrue();
                },
                1, 2, 3
        );
    }
}
