package main.java.com.ilearning.top10.test06;

public class Solution {
    int getTheMinWithColMaxs(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int maxValue = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                maxValue = Math.max(maxValue, matrix[j][i]);
            }
            ans = Math.min(ans, maxValue);
        }
        return ans;
    }
}
