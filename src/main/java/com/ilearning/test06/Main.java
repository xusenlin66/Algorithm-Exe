package main.java.com.ilearning.test06;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}, {2, 4}};
        Solution solution = new Solution();
        int ans = solution.getTheMinWithColMaxs(matrix);
        System.out.println(ans);
    }
}
