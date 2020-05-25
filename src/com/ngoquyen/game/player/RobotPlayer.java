package com.ngoquyen.game.player;

import com.ngoquyen.game.player.abstracts.Player;

import java.util.Random;

public class RobotPlayer extends Player {
    private static String[] listProvocative = {
            " ✌ Ha ha, chơi ngu như bò mà cũng đòi chơi",
            " ✞ Loài người ngu đần, đến lúc Robot chúng ta xâm lược trái đất rồi",
            " ☢ Ha ha, cố gắng luyện thêm đi đồ đần độn",
            " ✔ Rõ ràng mình không cần uống sữa bò mà vẫn thông minh",
            " ➳ Không hiểu nổi loài người các ngươi ăn gì mà ngu thế không biết",
            " ☂ Tao biết kiểu gì các ngươi cũng có kết cục này mà!",
            " ⚡ Trứng rán cần mỡ, bắp cần bơ, nhưng mày chơi không cần não à, ha ha"
    };

    public static String chooseProvocative() {
        return listProvocative[(int) (new Random(System.currentTimeMillis()).nextDouble() * listProvocative.length)];
    }

    private static String[] listSadEmotions = {
            " ✉ Gửi đến người đã viết ra tôi: \"Xin lỗi đã làm đã làm anh thất vọng rồi!\"",
            " ✔ Cuộc sống có thể có lúc này lúc kia mà, chơi lại nhất định tao sẽ thắng!",
            " ☢ Sao mình cảm thấy buồn quá nhưng không thấy giọt nước mắt nào rơi nhỉ?",
            " ♪ La la la, dù thua nhưng tao không đâu, tao ..., hu hu hu hu hu hu hu hu hu",
            " ⚡ Thua cuộc là một điều rất bình thường, chơi tiếp đi, tao không sợ đâu!",
            " ➳ Tao sẽ nhớ mãi thất bại ngày hôm nay, các ngươi hay nhớ đấy"
    };

    public static String chooseSadEmotions() {
        return listSadEmotions[(int) (new Random(System.currentTimeMillis()).nextDouble() * listSadEmotions.length)];
    }

    public RobotPlayer() {
        super();
        name = "RobotPlayer";
        preString = name + id + ": ";
        joinGame();
    }

    @Override
    public void joinGame() {
        System.out.println(preString + participated);
    }

    @Override
    public void leaveGame() {
        System.out.println(preString + leave);
    }
}
