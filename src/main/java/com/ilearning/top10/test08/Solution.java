package main.java.com.ilearning.top10.test08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    String characterSort(String inputStr) {
        // "a2CB1c"
        // "a1cB2C"
        List<Character> digitList = new ArrayList<>();
        List<Character> letterList = new ArrayList<>();
        for (char c : inputStr.toCharArray()) {
            if (Character.isDigit(c)) {
                digitList.add(c);
            } else {
                letterList.add(c);
            }
        }
        Character[] digitArray = digitList.toArray(new Character[0]);
        Character[] letterArray = letterList.toArray(new Character[0]);
        Arrays.sort(digitArray);
//        Arrays.sort(letterArray);
        Arrays.sort(letterArray, (a, b) -> {
            if (Character.isLowerCase(a) && Character.isLowerCase(b)) {
                return a - b;
            }
            if (Character.isUpperCase(a) && Character.isUpperCase(b)) {
                return a - b;
            }
            if (Character.isLowerCase(a) && Character.isUpperCase(b)) {
                return -1;
            }
            return 1;
        });
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : inputStr.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(digitArray[i++]);
            } else {
                sb.append(letterArray[j++]);
            }
        }
        return sb.toString();
    }
}
