package main.java.com.ilearning.test10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    List<String> getAllFault(List<String> arrayA, List<String> arrayB) {
        Map<String, Integer> faultMap = new HashMap<>();
        List<Fault> faultList = new ArrayList<>();
        List<String> idList = new ArrayList<>();
        for (String s : arrayA) {
            faultMap.put(s, faultMap.getOrDefault(s, 0) + 1);
        }
        for (String s : arrayB) {
            faultMap.put(s, faultMap.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : faultMap.entrySet()) {
            String id = entry.getKey();
            int count = entry.getValue();
            Fault fault = new Fault(id, count);
            faultList.add(fault);
        }
        faultList.sort(new Comparator<Fault>() {
            @Override
            public int compare(Fault o1, Fault o2) {
                return o1.id.compareTo(o2.id);
            }
        });
        for (Fault fault : faultList) {
            idList.add(fault.id);
        }
        return idList;
    }
}

class Fault{
    String id;

    int count;

    public Fault(String id, int count) {
        this.id = id;
        this.count = count;
    }
}
