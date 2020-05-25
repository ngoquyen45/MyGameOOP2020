package com.ngoquyen.game.sdk.utils;

import com.ngoquyen.game.player.abstracts.Player;

import java.util.Scanner;

public class MyUtils {
    private final static String invalid = "⚠ Bạn vừa nhập dữ liệu không hợp lệ!";
    public static int getInputInt(String description) {
        int data = -1;
        boolean temp = true;
        while (temp) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(description);
                data = Integer.parseInt(scanner.nextLine().trim());
                // Điều kiện kết thúc chương trình
                if (data <= 0) {
                    System.out.println(invalid);
                    continue;
                } else {
                    temp = false;
                    scanner.reset();
                }
            } catch (Exception e) {
                System.out.println(invalid);
            }
        }
        return data;
    }

    // Khi nhận vào một id và trả về xem đấy là object nào
    public static Player getPlayer(Player[] players, int id)  {
        for (Player player : players) {
            if (id == player.getId()) {
                return player;
            }
        }
        return null;
    }
}
