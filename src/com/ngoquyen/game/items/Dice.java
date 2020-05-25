package com.ngoquyen.game.items;

import java.util.Arrays;
import java.util.Random;

public class Dice {

    // List các mặt chấm

    private final int[] diceFace = {
            1, 2, 3, 4, 5, 6
    };

    // Xác suất mặc định
    private final int[] probability = {
            20, 16, 16, 16, 16, 16
    };

    public Dice(){

    }

    // Hàm kiểm tra xem xác suất đã đúng chưa
    private boolean isDice() {
        return (diceFace.length == 6 && probability.length == 6) && (Arrays.stream(probability).sum() == 100);
    }

    // Hàm xoay xúc sắc
    public int roll() throws Exception {
        if (!isDice()) throw new Exception("Mảng probability cài đặt không hợp lệ");
        // giá trị random
        int temp = (int) (Math.random() * 100) + 1;
        int start = 1, end = probability[0];

        // Đưa các kết quả xuất hiện mặt vào các khoảng tương ứng để phù hợp với xác xuất
        int result = -1;
        for (int i = 0; i < diceFace.length; i++) {
            if (start <= temp && temp <= end) result = diceFace[i];
            start = end + 1;
            // Không xảy lỗi ArrayIndexOutOfBoundsException vì lệnh break đã chấm dứt
            if (i == 5) break;
            end = start - 1 + probability[i+1];
        }
        if (result == -1) throw new Exception("Có lỗi trong việc cài đặt roll()");
        return result;
    }


}
