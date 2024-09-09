package main.java.com.ilearning.top20.test12;

public class Main {
    public static void main(String[] args) {
        String expression = "9,3,5,-,2,*,+";
        Solution solution = new Solution();
        int ans = solution.calc(expression);
        System.out.println(ans);
    }
}
