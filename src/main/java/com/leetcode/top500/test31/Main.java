package main.java.com.leetcode.top500.test31;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4,2,0,2,3,2,0};
        Solution solution = new Solution();
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
