package baseball.view.valueobject;

import baseball.exception.IllegalArgument;

import java.util.regex.Pattern;

public class NumbersInput {
    private static final Pattern isThreeNumbersInRange = Pattern.compile("[1-9]{3}");

    private final String numbers;

    public NumbersInput(String numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(String numbers) {
        if (isThreeNumbersInRange.matcher(numbers).matches()) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_INPUT.getMessage());
    }

    public String getNumbers() {
        return numbers;
    }
}
