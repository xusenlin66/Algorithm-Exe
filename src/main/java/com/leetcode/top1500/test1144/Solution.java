package main.java.com.leetcode.top1500.test1144;

public class Solution {
    public int movesToMakeZigzag(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int evenTimes = makeSmall(nums, 0);
        int oddTimes = makeSmall(nums, 1);
        return Math.min(evenTimes, oddTimes);
    }

    private int makeSmall(int[] nums, int start) {
        int times = 0;
        int n = nums.length;
        for (int i = start; i < n; i += 2) {
            if (i == 0 && nums[i] >= nums[i + 1]) {
                times += nums[i] - nums[i + 1] + 1;
            } else if (i == n - 1 && nums[i] >= nums[i - 1]) {
                times += nums[i] - nums[i - 1] + 1;
            } else if (i > 0 && i < n - 1) {
                if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                    continue;
                } else {
                    int smaller = Math.min(nums[i - 1], nums[i + 1]);
                    times += nums[i] - smaller + 1;
                }
            }
        }
        return times;
    }
}
