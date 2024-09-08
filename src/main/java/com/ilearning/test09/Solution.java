package main.java.com.ilearning.test09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    List<String> getTop3App(List<Process> processes, List<String> sortRules, List<String> selectedUsers) {
        Map<String, Integer> map = new HashMap<>();
        List<Process> list = new ArrayList<>();
        Set<String> set = new HashSet<>(selectedUsers);
        for (int i = 0; i < processes.size(); i++) {
            String userName = processes.get(i).userName;
            String appName = processes.get(i).appName;
            if (set.contains(userName)) {
                if (map.containsKey(appName)) {
                    Process process = list.get(map.get(appName));
                    process.memUsed += processes.get(i).memUsed;
                    process.cpuUsed += processes.get(i).cpuUsed;
                } else {
                    list.add(processes.get(i));
                    map.put(appName, list.size() - 1);
                }
            }
        }
        list.sort(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                for (String rule : sortRules) {
                    if ("cpuUsed".equals(rule)) {
                        if (o1.cpuUsed != o2.cpuUsed) {
                            return o2.cpuUsed - o1.cpuUsed;
                        }
                    }
                    if ("memUsed".equals(rule)) {
                        if (o1.memUsed != o2.memUsed) {
                            return o2.memUsed - o1.memUsed;
                        }
                    }
                }
                return o1.appName.compareTo(o2.appName);
            }
        });
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            ans.add(list.get(i).appName);
        }
        return ans;
    }
}

class Process {
    String appName;
    String userName;
    int cpuUsed;
    int memUsed;
    public String toString() {
        return String.format(java.util.Locale.ROOT, "[\"%s\", \"%s\", %d, %d]", appName, userName, cpuUsed, memUsed);
    }
}
