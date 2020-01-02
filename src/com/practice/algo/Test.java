package com.practice.algo;

import java.util.*;

/**
 * Created by Prathap on 22 Oct, 2019
 */
public class Test {

    public static void main(String args[]) {
        int[] groupSizes = {3,3,3,3,3,1,3};
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i=0; i<groupSizes.length; i++) {
            List<Integer> subGroup = groups.get(groupSizes[i]);
            if (subGroup == null) {
                subGroup = new ArrayList<>();
            }
            subGroup.add(i);
            groups.put(groupSizes[i], subGroup);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
            List<Integer> groupList = new ArrayList<>();
            if (entry.getKey() == entry.getValue().size()) {
                groupList.addAll(entry.getValue());
                result.add(groupList);
            } else {
                List<Integer> temp = entry.getValue();
                for (Integer i : temp) {
                    groupList.add(i);
                    if (groupList.size() == entry.getKey()) {
                        result.add(groupList);
                        groupList = new ArrayList<>();
                    }
                }
            }
        }


    }


}
