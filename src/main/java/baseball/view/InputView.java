package baseball.view;

import baseball.view.valueobject.CommandInput;
import baseball.view.valueobject.NumbersInput;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static String READ_NUMBERS_TEXT = "숫자를 입력해주세요 : ";
    private static String READ_COMMAND_TEXT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String readNumbers() {
        printReadNumbersText();
        return new NumbersInput(input()).getNumbers();
    }

    public static void printReadNumbersText() {
        System.out.print(READ_NUMBERS_TEXT);
    }

    public static String readCommand() {
        printReadCommandText();
        return new CommandInput(input()).getCommand();
    }

    public static void printReadCommandText() {
        System.out.println(READ_COMMAND_TEXT);
    }

    public static String input() {
        return Console.readLine();
    }
}
