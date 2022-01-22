package com.company.leetcode;

import java.util.List;

//intre
public class TicTacToe {
    static String resolve(String topRow, String middleRow, String bottomRow) {
        int[] check = {0, 1, 2, 3, 4, 5, 6, 7, 8, 0, 3, 6, 1, 4, 7, 2, 5, 8, 0, 4, 8, 2, 4, 6};
        List<Integer> iData = (topRow + middleRow + bottomRow).chars().mapToObj(c -> (char) c == 'X' ? 0 : 1).toList();
        int total = 0;
        for (int i = 0; i < check.length; i += 3) {
            int res = iData.get(check[i]) + iData.get(check[i + 1]) + iData.get(check[i + 2]);
            total = (res == 0) ? total + 1 : res == 3 ? total + 10 : total;
        }
        return total == 0 ? "False" : total <= 8 ? "X" : total % 10 == 0 ? "O" : "False";
    }
}


