package main.java.com.leetcode.top1000.test957;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 错误答案
        int[] cells = new int[]{1, 0, 0, 1, 0, 0, 1, 0};
        int n = 100;
        Solution solution = new Solution();
        int[] result = solution.prisonAfterNDays(cells, n);
        System.out.println(Arrays.toString(result));
    }
}
