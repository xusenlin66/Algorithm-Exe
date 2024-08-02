package main.java.com.leetcode.top500.test43;

public class Solution {
    public String multiply(String num1, String num2) {
        int number1 = toNumber(num1);
        int number2 = toNumber(num2);
        int mult = number1 * number2;
        return toStr(mult);
    }

    private int toNumber(String s) {
        int n = s.length();
        int number = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            number = number * 10 + (c - '0');
        }
        return number;
    }

    private String toStr(int number) {
        StringBuilder sb = new StringBuilder();
        if(number == 0) {
            return "0";
        }
        while(number > 0) {
            int mod = number % 10;
            sb.insert(0, mod);
            number /= 10;
        }
        return sb.toString();
    }
}
