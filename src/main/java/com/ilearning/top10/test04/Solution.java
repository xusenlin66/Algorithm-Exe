package main.java.com.ilearning.top10.test04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    int[] getActiveUserNum(List<String> logs) {

//        ["2020-12-01|192.168.218.001|/login.do|success",
//        "2020-12-01|192.168.218.1|/login.do|success",
//        "2020-12-01|192.168.218.2|/to_login.do|success"]
//        [1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        int monthActive = 0;
        int[] dayActive = new int[31];
        Set<String> monthSet = new HashSet<>();
        Map<Integer, Set<String>> map = new HashMap<>();
        for (String log : logs) {
            String[] split = log.split("\\|");
            if ("/login.do".equals(split[2]) && "success".equals(split[3])) {
                String ip = removePreZero(split[1]);
                monthSet.add(ip);
                int day = Integer.parseInt(split[0].split("-")[2]);
                map.putIfAbsent(day, new HashSet<>());
                map.get(day).add(ip);
            }
        }
        monthActive = monthSet.size();
        int[] ans = new int[32];
        ans[0] = monthActive;
        for (int i = 1; i <= 31; i++) {
            ans[i] = map.getOrDefault(i, new HashSet<>()).size();
        }
        return ans;
    }

    private String removePreZero(String ip) {
        String[] nums = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(Integer.parseInt(nums[i]));
            sb.append(nums[i]);
            if (i < nums.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
