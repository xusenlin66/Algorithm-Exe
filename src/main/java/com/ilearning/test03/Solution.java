package main.java.com.ilearning.test03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int calculate(String message) {
        // "11@2$3@14"
        // "11@2 $ 3@14"
        String[] strings = message.split("\\$");
        List<String> list = new ArrayList<>();
        for (String string : strings) {
            if (string.contains("@")) {
                String[] substrings = string.split("@");
                list.add(calculateSum(Arrays.asList(substrings), true).toString());
            } else {
                list.add(string);
            }
        }
        return calculateSum(list, false);
    }

    private static Integer calculateSum(List<String> list, boolean flag) {
        int left = Integer.parseInt(list.get(0));
        for (int i = 0; i < list.size() - 1; i++) {
            if (flag) {
                left = calculateA(left, Integer.parseInt(list.get(i + 1)));
            } else {
                left = calculateB(left, Integer.parseInt(list.get(i + 1)));
            }
        }
        return left;
    }

    private static int calculateA(int left, int right) {
        // x@y = 2*x+y+3
        return 2 * left + right + 3;
    }

    private static int calculateB(int left, int right) {
        // x$y = 3*x+2*y+1
        return 3 * left + 2 * right + 1;
    }
}
