package baseball.model;

import baseball.constant.Constant;
import baseball.exception.IllegalArgument;

import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    void validate(List<Integer> numbers){
        validateDuplication(numbers);
        validateInRange(numbers);
        validateSize(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() == numbers.stream().distinct().count()) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS.getMessage());
    }

    private void validateInRange(List<Integer> numbers) {
        if (numbers.stream().allMatch(number -> number >= Constant.MIN_NUMBER && number <= Constant.MAX_NUMBER)) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS.getMessage());
    }

    private void validateSize(List<Integer> numbers){
        if(numbers.size() == Constant.NUMBERS_SIZE){
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_NUMBERS.getMessage());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
