package baseball.model;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final Numbers numbers;

    public Computer() {
        this.numbers = new Numbers(createRandomThreeNumbers());
        //System.out.println(numbers.getNumbers());
    }

    private List<Integer> createRandomThreeNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (; numbers.size() < Constant.NUMBERS_SIZE; ) {
            int number = Randoms.pickNumberInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER);
            if (isNotDuplication(numbers, number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    private boolean isNotDuplication(List<Integer> numbers, int number) {
        return !numbers.contains(number);
    }

    public boolean isSamePositionSameValue(int number, int position) {
        return numbers.getNumbers().get(position) == number;
    }

    public boolean isDifferentPositionSameValue(int number, int position) {
        return numbers.getNumbers().get(position) != number
                && numbers.getNumbers().contains(number);
    }
}
