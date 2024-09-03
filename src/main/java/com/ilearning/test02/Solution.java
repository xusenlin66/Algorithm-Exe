package main.java.com.ilearning.test02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    char[] commonChars(int count, List<String> strings) {
        int[] minFreq = new int[128];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        for (String s : strings) {
            int[] freq = new int[128];
            for (char c : s.toCharArray()) {
                freq[c]++;
            }
            for (int i = 0; i < minFreq.length; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < minFreq.length; i++) {
            if (minFreq[i] >= count) {
                list.add((char) i);
            }
        }
        char[] result = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
