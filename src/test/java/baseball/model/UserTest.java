package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력받은 3자리 숫자를 가지고 User 객체가 정상적으로 만들어지는지 확인.")
public class UserTest {

    private User user;

    static Stream<Arguments> createUserNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(4, 5, 7))
        );
    }

    @BeforeEach
    void 유저_객체_생성() {
        user = new User("457");
    }

    /*
    4(value) -> 4, 5, 7(assertThat) (5에서 오류 남)
    expected: 4 (value)
    but was: 5(assertThat)
    5 -> 4, 5, 7
    7 -> 4, 5, 7
    @DisplayName("유저 객체의 Numbers 확인")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 7})
    void 유저_Numbers_검사(int value) {
        for (int i = 0; i < 3; i++) {
            assertThat(user.pickNumber(i)).isEqualTo(value);
        }
    }
    */

    @DisplayName("유저 객체의 Numbers 확인")
    @ParameterizedTest
    @MethodSource("createUserNumbers")
    void 유저_Numbers_검사(List<Integer> numbers) {
        for (int i = 0; i < 3; i++) {
            assertThat(user.pickNumber(i)).isEqualTo(numbers.get(i));
        }
    }
}
