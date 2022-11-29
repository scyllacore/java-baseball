package baseball.exception;

import baseball.constant.Constant;

public enum IllegalArgument {

    WRONG_NUMBERS(String.format("잘못된 숫자들 입니다.", Constant.MIN_NUMBER, Constant.MAX_NUMBER)),
    WRONG_INPUT(String.format("잘못된 형태의 입력입니다."));

    private String message;
    private final String error = "[ERROR] ";

    IllegalArgument(String message) {
        this.message = error + message;
    }

    public String getMessage() {
        return message;
    }

    public static void handleException(String message) throws IllegalArgumentException{
        throw new IllegalArgumentException(message);
    }

}
