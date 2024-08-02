package main.java.com.ilearning.test01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] events = {4, 8, 4, 3, 6, 6, 8};
        int[] traits = {4, 6, 8};
        int[] ans = solution.faultPredict(events, traits);
        System.out.println(Arrays.toString(ans));
        Arrays.asList();
    }
}
