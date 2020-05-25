package com.ngoquyen.game.sdk.algorithms;

public class MyAlgorithms {

    // Thuật toán cháo đổi vị trí các phần tử trong mảng theo một cách lộn xộn
    public static <T> void shuffleArr(T[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int j = (int)Math.random()*len;
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
