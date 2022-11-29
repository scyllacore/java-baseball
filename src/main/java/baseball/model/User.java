package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Numbers numbers;

    public User(String numbers) {
        this.numbers = new Numbers(convertToList(numbers));
    }

    private List<Integer> convertToList(String numbers) {
        return Arrays.stream(numbers.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int pickNumber(int position) {
        return numbers.getNumbers().get(position);
    }
}
