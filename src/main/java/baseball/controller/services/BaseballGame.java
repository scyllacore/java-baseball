package baseball.controller.services;

import baseball.constant.Constant;
import baseball.controller.GameResult;
import baseball.model.Computer;
import baseball.model.User;

public class BaseballGame {
    private final Computer computer;

    public BaseballGame(Computer computer) {
        this.computer = computer;
    }

    public GameResult compareNumbers(User user) {
        int ball = 0;
        int strike = 0;

        for (int position = 0; position < Constant.NUMBERS_SIZE; position++) {
            ball += countBall(user, position);
            strike += countStrike(user, position);
        }
        return new GameResult(ball, strike);
    }

    private int countBall(User user, int position) {
        if (computer.isDifferentPositionSameValue(user.pickNumber(position), position)) {
            return Constant.COUNT_SUCCESS;
        }
        return Constant.COUNT_FAIL;
    }

    private int countStrike(User user, int position) {
        if (computer.isSamePositionSameValue(user.pickNumber(position), position)) {
            return Constant.COUNT_SUCCESS;
        }
        return Constant.COUNT_FAIL;
    }

    public boolean isAnswer(GameResult gameResult) {
        return gameResult.getStrike() == Constant.ANSWER_COUNT;
    }
}
