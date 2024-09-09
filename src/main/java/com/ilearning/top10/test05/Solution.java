package main.java.com.ilearning.top10.test05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    List<MyRecord> getPhoneRecords(List<Operation> operations) {
        Set<String> whiteSet = new HashSet<>();
        Map<String, MyRecord> recordMap = new HashMap<>();
        Map<String, Integer> orderMap = new HashMap<>();
        int index = 0;
        for (Operation operation : operations) {
            char opType = operation.opType;
            String number = operation.number;
            if ('W' == opType) {
                whiteSet.add(number);
            } else {
                if (!recordMap.containsKey(number)) {
                    recordMap.put(number, new MyRecord(number, 0, 0));
                }
                if (!orderMap.containsKey(number)) {
                    orderMap.put(number, index++);
                }
                boolean isMatch = isMatch(whiteSet, number);
                if (isMatch) {
                    recordMap.get(number).accepted++;
                } else {
                    recordMap.get(number).refused++;
                }
            }
        }
        MyRecord[] ans = new MyRecord[orderMap.size()];
        for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
            String number = entry.getKey();
            int i = entry.getValue();
            ans[i] = recordMap.get(number);
        }
        return Arrays.stream(ans).collect(Collectors.toList());
    }

    private boolean isMatch(Set<String> whiteSet, String number) {
        boolean isMatch = false;
        if (whiteSet.contains(number)) {
            return true;
        }
        for (String white : whiteSet) {
            if (white.contains("*")) {
                String s = white.replace("*", ".*");
                if (number.matches(s)) {
                    isMatch = true;
                    break;
                }
            }
        }
        return isMatch;
    }
}

class Operation {
    char opType;
    String number;
    public String toString() {
        return String.format(java.util.Locale.ROOT, "[%c, \"%s\"]", opType, number);
    }
}

class MyRecord {
    String number;
    int accepted;
    int refused;

    public MyRecord(String number, int accepted, int refused) {
        this.number = number;
        this.accepted = accepted;
        this.refused = refused;
    }

    public String toString() {
        return String.format(java.util.Locale.ROOT, "[\"%s\", %d, %d]", number, accepted, refused);
    }
}
