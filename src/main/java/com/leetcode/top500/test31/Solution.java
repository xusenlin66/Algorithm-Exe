package main.java.com.leetcode.top500.test31;

public class Solution {
    public void nextPermutation(int[] nums) {
        /**
         * 从左往右找到第一个开始下降的数字x,
         * x右边存在一个最小的大于x的数字y,
         * 从左往右遍历找到y，交换x、y
         * 此时y右边所有数字递减,反转使其递增
         */
        // [4,2,0,2,3,2,0]
        int n = nums.length;
        int i = n - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if(i >= 0) {
            int j = n - 1;
            while(j > i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left) {
        int right = nums.length - 1;
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
