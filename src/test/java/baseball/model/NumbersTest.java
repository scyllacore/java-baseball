package baseball.model;

import baseball.exception.IllegalArgument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력받은 3자리 숫자를 Numbers 객체에 담을 때 필요한 유효성 검사를 진행한다.")
public class NumbersTest {
    static Stream<Arguments> createDuplicatedNumbers() { // static 붙어야함.
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 2)),
                Arguments.of(Arrays.asList(4, 4, 1))
        );
    }

    static Stream<Arguments> createOutOfRangeNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(0, 1, 2)),
                Arguments.of(Arrays.asList(1, 10, 3))
        );
    }

    static Stream<Arguments> createWrongLengthNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(0, 1, 2, 3)),
                Arguments.of(Arrays.asList(1, 1, 3, 2))
        );
    }


    @DisplayName("중복되는 자릿수에 대해 예외가 발생하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("createDuplicatedNumbers")
    void 중복이_존재하는_숫자로_Numbers_객체_생성(List<Integer> numbers) {
        assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgument.WRONG_NUMBERS.getMessage());
    }

    @DisplayName("범위를 벗어나는 자릿수에 대해 예외가 발생하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("createOutOfRangeNumbers")
    void 범위를_벗어나는_숫자로_Numbers_객체_생성(List<Integer> numbers) {
        assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgument.WRONG_NUMBERS.getMessage());
    }

    @DisplayName("잘못된 길이를 가진 수에 대해 예외가 발생하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("createWrongLengthNumbers")
    void 길이를_벗어난_숫자로_Numbers_객체_생성(List<Integer> numbers) {
        assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgument.WRONG_NUMBERS.getMessage());
    }
}
