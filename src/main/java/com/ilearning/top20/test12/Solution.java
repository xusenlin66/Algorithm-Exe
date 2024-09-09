package main.java.com.ilearning.top20.test12;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    int calc(String expression) {
        // "9,3,5,-,2,*,+"
        String[] strings = expression.split(",");
        Deque<Integer> numStack = new ArrayDeque<>();
        for (String s : strings) {
            if ("+".equals(s)) {
                int temp = numStack.pop();
                int add = numStack.pop();
                numStack.push(add + temp);
            } else if ("-".equals(s)) {
                int temp = numStack.pop();
                int sub = numStack.pop();
                numStack.push(sub - temp);
            } else if ("*".equals(s)) {
                int temp = numStack.pop();
                int multi = numStack.pop();
                numStack.push(multi * temp);
            } else if ("/".equals(s)) {
                int temp = numStack.pop();
                int div = numStack.pop();
                numStack.push(div / temp);
            } else {
                numStack.push(Integer.parseInt(s));
            }
        }
        return numStack.pop();
    }
}
