package baseball.view.valueobject;

import baseball.exception.IllegalArgument;

import java.util.regex.Pattern;

public class CommandInput {
    private static final Pattern isOneOrTwo = Pattern.compile("[1-2]");

    private final String command;

    public CommandInput(String command) {
        validateCommand(command);
        this.command = command;
    }

    private void validateCommand(String command){
        if(isOneOrTwo.matcher(command).matches()){
            return;
        }
        IllegalArgument.handleException(IllegalArgument.WRONG_INPUT.getMessage());
    }

    public String getCommand() {
        return command;
    }
}
