package com.ngoquyen.game.player;

import com.ngoquyen.game.MyGame;
import com.ngoquyen.game.player.abstracts.Player;
import com.ngoquyen.game.player.interfaces.GameCharacter;
import com.ngoquyen.game.sdk.algorithms.MyAlgorithms;
import com.ngoquyen.game.sdk.utils.MyUtils;

public class Referee implements GameCharacter {
    private String name = "Referee";

    public String getPreString() {
        return preString;
    }

    private String preString = name + ": ";

    // Đưa đối tượng game vào để trọng tài có thể gọi đến
    private MyGame game;
    public Referee(MyGame game) {
        super();
        this.game = game;
        joinGame();
    }

    // Đổi tên cho trọng tài
    public void setName(String name) {
        this.name = name;
        preString = name + ": ";
        System.out.println("Trọng tài đã đặt lại tên là " + name);
    }

    @Override
    public void joinGame() {
        System.out.println(preString + participated);
    }

    @Override
    public void leaveGame() {
        System.out.println(preString + leave);
    }

    // Các nhiệm vụ của trọng tài

    // 1. Khởi tạo thứ tự lượt chơi
    public void initialTurnOrder() {
        System.out.println();
        MyAlgorithms.shuffleArr(MyGame.listId);
        System.out.print(preString + "☑ Thứ tự của các bạn sẽ là: ");
        for (Integer i : MyGame.listId) {
            System.out.print(i + " → ");
        }
        System.out.println("...");
        System.out.println();
    }

    // Trả về lượt của người tiếp theo với id
    private int temp = 0;
    public Player chooseTurn() {
        int id = MyGame.listId[temp];
        temp = (temp + 1) % MyGame.listId.length;
        return MyUtils.getPlayer(game.getPlayers(), id);
    }


    public void computeScore(Player player) {
        if (player.getScore() > MyGame.SET_POINT) player.setScore(0);
        System.out.println(player.getPreString() + "→ Điểm hiện tại của tôi là " + player.getScore());
    }
    public void notifyWinner(Player player) {
        if (player.getScore() == MyGame.SET_POINT) {
            System.out.println();
            System.out.println(preString + " ➤ Chúc mừng, " + player.getPreString() + "là người chiến thắng!");
            game.quit();
        }
    }

}
