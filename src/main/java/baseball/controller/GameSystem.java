package baseball.controller;

import baseball.constant.Constant;
import baseball.controller.services.BaseballGame;
import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameSystem {
    private BaseballGame baseballGame;

    public void runGame() {
        OutputView.printRunGameText();

        for (; ; ) {
            boolean menuPick = playGame();

            if (menuPick) {
                return;
            }
        }
    }

    private boolean playGame() {
        loadBaseballGame();
        for (; ; ) {
            GameResult gameResult = baseballGame.compareNumbers(new User(InputView.readNumbers()));
            OutputView.printGameResult(gameResult);

            if (baseballGame.isAnswer(gameResult)) {
                OutputView.printEndGameText();
                return pickMenu(InputView.readCommand());
            }
        }
    }

    private void loadBaseballGame() {
        baseballGame = new BaseballGame(new Computer());
    }

    private boolean pickMenu(String command) {
        if (command.equals(Constant.RETRY)) {
            return false;
        }
        return true;
    }
}
