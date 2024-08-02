package main.java.com.leetcode.top1000.test567;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        for(int i = 0; i <= len2 - len1; i++) {
            String sub = s2.substring(i, i + len1);
            if(isPermutation(s1, sub)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPermutation(String s1, String sub) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}
