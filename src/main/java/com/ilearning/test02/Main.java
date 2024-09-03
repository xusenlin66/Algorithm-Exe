package main.java.com.ilearning.test02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 2
        // ["aabbccFFFFx2x2", "aaccddFFFFx2x2", "aabcdFFFFx2x2"]
        // ["2", "F", "a", "x"]
        Solution solution = new Solution();
        List<String> list = new ArrayList<>();
        list.add("aabbccFFFFx2x2");
        list.add("aaccddFFFFx2x2");
        list.add("aabcdFFFFx2x2");
        char[] result = solution.commonChars(2, list);
        System.out.println(result);
    }
}
