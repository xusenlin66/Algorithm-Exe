package main.java.com.ilearning.top10.test07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    String recombine(List<DataFragment> dataFragments, int dstType) {
        Map<Integer, DataFragment> dataFragmentMap = new HashMap<>();
        int maxIndex = -1;
        boolean hasEndFlag = false;
        for (DataFragment dataFragment : dataFragments) {
            if (dstType == dataFragment.dataType && !dataFragmentMap.containsKey(dataFragment.index)) {
                dataFragmentMap.put(dataFragment.index, dataFragment);
                if (dataFragment.endFlag == 1) {
                    maxIndex = dataFragment.index;
                    hasEndFlag = true;
                }
            }
        }
        if (!hasEndFlag || dataFragmentMap.size() != maxIndex + 1) {
            return "NA";
        }
        DataFragment[] dataFragmentArray = new DataFragment[maxIndex + 1];
        for (Map.Entry<Integer, DataFragment> entry : dataFragmentMap.entrySet()) {
            int i = entry.getKey();
            dataFragmentArray[i] = entry.getValue();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataFragmentArray.length; i++) {
            sb.append(dataFragmentArray[i].data);
        }
        return sb.toString();
    }
}

class DataFragment {
    int dataType;
    int index;
    int endFlag;
    int len;
    String data;
    public String toString() {
        return String.format(java.util.Locale.ROOT, "[%d, %d, %d, %d, \"%s\"]", dataType, index, endFlag, len, data);
    }
}
