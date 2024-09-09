package main.java.com.ilearning.top20.test11;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    List<CurTable> SyncNeInfo(List<CurTable> curTable, List<BakTable> bakTable) {
        Map<Integer, Integer> curTableMap = new HashMap<>();     // id -- index
        for (int i = 0; i < curTable.size(); i++) {
            CurTable curItem = curTable.get(i);
            curTableMap.put(curItem.neId, i);
        }
        for (BakTable bakItem : bakTable) {
            int neId = bakItem.neId;
            String neName = bakItem.neName;
            int defaultFlag = 0;
            if (!curTableMap.containsKey(neId)) {
//                curTable.add(new CurTable(neId, neName, defaultFlag));
                CurTable curItem = new CurTable();
                curItem.neId = neId;
                curItem.neName = neName;
                curItem.neFlag = defaultFlag;
                curTable.add(curItem);
            } else {
                CurTable curItem = curTable.get(curTableMap.get(neId));
                curItem.neName = neName;
            }
        }
        curTable.sort(new Comparator<CurTable>() {
            @Override
            public int compare(CurTable o1, CurTable o2) {
                return o1.neId - o2.neId;
            }
        });
        return curTable;
    }
}

class BakTable {
    int neId;
    String neName;
    public String toString() {
        return String.format(java.util.Locale.ROOT, "[%d, \"%s\"]", neId, neName);
    }
}

class CurTable {
    int neId;
    String neName;
    int neFlag;

//    public CurTable(int neId, String neName, int neFlag) {
//        this.neId = neId;
//        this.neName = neName;
//        this.neFlag = neFlag;
//    }

    public String toString() {
        return String.format(java.util.Locale.ROOT, "[%d, \"%s\", %d]", neId, neName, neFlag);
    }
}
