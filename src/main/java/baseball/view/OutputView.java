package baseball.view;

import baseball.constant.Constant;
import baseball.controller.GameResult;

public class OutputView {
    private static String RUN_GAME_TEXT = "숫자 야구 게임을 시작합니다.";
    private static String END_GAME_TEXT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static String NOTHING_TEXT = "낫싱";
    private static String BALL_TEXT = "볼";
    private static String STRIKE_TEXT = "스트라이크";

    public static void printGameResult(GameResult gameResult) {
        int ball = gameResult.getBall();
        int strike = gameResult.getStrike();
        System.out.println(createResultText(ball, strike));
    }

    private static String createResultText(int ball, int strike) {
        if (isNothing(ball, strike)) {
            return NOTHING_TEXT;
        }
        if (isOnlyBall(ball, strike)) {
            return String.format("%d%s", ball, BALL_TEXT);
        }
        if (isOnlyStrike(ball, strike)) {
            return String.format("%d%s", strike, STRIKE_TEXT);
        }
        return String.format("%d%s %d%s", ball, BALL_TEXT, strike, STRIKE_TEXT);
    }

    private static boolean isNothing(int ball, int strike) {
        return ball == Constant.COUNT_FAIL && strike == Constant.COUNT_FAIL;
    }

    private static boolean isOnlyBall(int ball, int strike) {
        return ball > Constant.COUNT_FAIL && strike == Constant.COUNT_FAIL;
    }

    private static boolean isOnlyStrike(int ball, int strike) {
        return ball == Constant.COUNT_FAIL && strike > Constant.COUNT_FAIL;
    }

    public static void printRunGameText() {
        System.out.println(RUN_GAME_TEXT);
    }

    public static void printEndGameText() {
        System.out.println(END_GAME_TEXT);
    }
}
