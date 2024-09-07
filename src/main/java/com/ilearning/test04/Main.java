package main.java.com.ilearning.test04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("2020-12-01|192.168.218.001|/login.do|success");
        logs.add("2020-12-01|192.168.218.1|/login.do|success");
        logs.add("2020-12-01|192.168.218.2|/to_login.do|success");
//        [1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        Solution solution = new Solution();
        int[] ans = solution.getActiveUserNum(logs);
        System.out.println(ans.length);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
