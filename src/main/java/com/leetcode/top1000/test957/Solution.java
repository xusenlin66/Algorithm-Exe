package main.java.com.leetcode.top1000.test957;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<Integer, Object> resultMap = new HashMap<>();
        Map<Integer, Integer> preMap = new HashMap<>();
        preMap = setPreMap(preMap, cells);
        cells[0] = 0;
        cells[7] = 0;
        int index = 0;
        for(int i = 1; i <= n; i++) {
            if(resultMap.containsValue(cells)) {
                index = i - 1;
                break;
            }
            for(int j = 1; j <= 6; j++) {
                if(preMap.get(j - 1) == preMap.get(j + 1)) {
                    cells[j] = 1;
                } else {
                    cells[j] = 0;
                }
            }
            preMap = setPreMap(preMap, cells);
            resultMap.put(i, cells);
        }
        System.out.println(resultMap.get(n % index));
        return (int[])resultMap.get(n % index);
    }

    private Map<Integer, Integer> setPreMap(Map<Integer, Integer> preMap, int[] cells) {
        for(int i = 0; i < 8; i++) {
            preMap.put(i, cells[i]);
        }
        return preMap;
    }
}
