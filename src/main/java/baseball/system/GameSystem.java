package baseball.system;


import baseball.player.*;

public class GameSystem {

    public void runGame() {

        printRunGameText();

        for (; ; ) {

            startGame();

            if (!selectMenu()) {
                break;
            }

        }


    }

    private void printRunGameText() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private boolean selectMenu() {

        MenuSelection menuSelection = new MenuSelection();
        return menuSelection.startMenuSelection();

    }

    private void startGame() {

        Computer computer = new Computer();
        User user = new User();

        GamePlay gamePlay = new GamePlay(computer,user);
        gamePlay.playGame();

        //TODO : printAnswerText 구현

    }



}
