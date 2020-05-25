package com.ngoquyen.game;

import com.ngoquyen.game.player.HumanPlayer;
import com.ngoquyen.game.player.Referee;
import com.ngoquyen.game.player.RobotPlayer;
import com.ngoquyen.game.player.abstracts.Player;
import com.ngoquyen.game.player.interfaces.GameCharacter;
import com.ngoquyen.game.sdk.utils.MyUtils;

import java.util.Scanner;

public class MyGame {
    // set Point
    public static int SET_POINT = 21;

    // List các id của người chơi
    public static Integer[] listId;

    // Số lượng người (con người thật)
    private int numberOfHuman;

    // Toàn bộ người chơi kể cả robot
    private int maxNumberOfPlayer;

    private MyGame() {
    }

    public static MyGame newInstance() {
        return new MyGame();
    }

    private void initialGameParameter() {
        System.out.println("----> Chào mừng đến thế giới game hay nhất vũ trụ này <----");
        String promptMaxNumberOfPlayer = "⌘ Nhập số lượng người chơi tối đa: ";
        maxNumberOfPlayer = MyUtils.getInputInt(promptMaxNumberOfPlayer);

        String promptNumberOfHuman = "⌘ Nhập số lượng human: ";
        do {
            numberOfHuman = MyUtils.getInputInt(promptNumberOfHuman);
            if (maxNumberOfPlayer < numberOfHuman)
                System.out.println("⚠ Số lượng người chơi tối đa phải lớn hơn hoặc bằng số lượng human");
        } while (maxNumberOfPlayer < numberOfHuman);

        System.out.println();
    }


    // Các nhân vật game
    private Referee referee;


    private Player[] players;
    public Player[] getPlayers() {
        return players;
    }

    // Vòng lặp game
    private boolean myGameLoop = true;
    private Player currentPlayer;

    // Robot là có tham gia game
    private boolean robotParticipated;

    public void start() {
        initialGameParameter();
        // Tạo ra listId
        listId = new Integer[maxNumberOfPlayer];
        for (int i = 0; i < maxNumberOfPlayer; i++) {
            listId[i] = i + 1;
        }

        // Tạo ra trọng tài
        referee = new Referee(this);


        // Tạo ra list human
        players = new Player[maxNumberOfPlayer];
        for (int i = 0; i < numberOfHuman; i++) {
            players[i] = new HumanPlayer();
        }

        // Tạo ra list robot nếu bọn nó có thm gia
        robotParticipated = (maxNumberOfPlayer - numberOfHuman) != 0;
        if (robotParticipated) {
            for (int i = numberOfHuman; i < maxNumberOfPlayer; i++) {
                players[i] = new RobotPlayer();
            }
        }

        // Trọng tài đặt thứ tự lượt chơi
        referee.initialTurnOrder();

        System.out.println("Bắt đầu game");
        while (myGameLoop) {

            // Trọng tài chọn ra được người chơi
            currentPlayer = referee.chooseTurn();
            // Cho người chơi nhập enter

            // Nếu đến lượt Human
            if (currentPlayer instanceof HumanPlayer) {
                System.out.print(referee.getPreString() + "Ê, " + currentPlayer.getPreString() + "nhấn enter để tung xúc sắc");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
                scanner.reset();
                currentPlayer.rollDice();
            } else {
                // Người chơi thực hiện roll xúc xắc
                currentPlayer.rollDice();
            }
            // Trọng tài tính điểm cho người chơi
            referee.computeScore(currentPlayer);
            // Trọng tài đưa ra thông báo người thắng cuộc nếu có
            referee.notifyWinner(currentPlayer);
        }
    }

    public void restart() {

    }

    public void reset() {

    }

    public void quit() {
        System.out.println();
        myGameLoop = false;
        // Bọn robot có cần bầy tỏ cảm xúc gì không?

        // Nếu bọn robot có tham gia
        if (robotParticipated) {
            // Nếu robot thắng
            if (currentPlayer instanceof RobotPlayer) {
                System.out.println("RobotPlayer:" + RobotPlayer.chooseProvocative());
            } else { // Robot thua
                System.out.println("RobotPlayer:" + RobotPlayer.chooseSadEmotions());
            }
        }

        System.out.println();
        referee.leaveGame();
        for (Player player : players) {
            player.leaveGame();
        }
    }
}
