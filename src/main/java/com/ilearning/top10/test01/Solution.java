package main.java.com.ilearning.top10.test01;

public class Solution {
    int[] faultPredict(int[] events, int[] traits) {
        // [4, 8, 4, 3, 6, 6, 8]
        // [4, 6, 8]
        int m = events.length;
        int n = traits.length;
        int minLen = m;
        int left = 0;
        int right = events.length;

        for (int i = 0; i <= m - n; i++) {
            // 先左对齐
            int p1 = i;
            int p2 = 0;
            if (events[p1] != traits[0]) {
                continue;
            }

            // 移动指针
            while (p1 < m && p2 < n) {
                if (events[p1] == traits[p2]) {
                    p1++;
                    p2++;
                } else {
                    p1++;
                }
            }

            // 更新答案
            if (p2 == n && p1 -i < minLen) {
                minLen = p1 - i;
                left = i;
                right = p1;
            }
        }
        int[] ans = new int[minLen];
        int j = 0;
        for (int i = left; i < right; i++) {
            ans[j++] = events[i];
        }

        return ans;
    }
}
