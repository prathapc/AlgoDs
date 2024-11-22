package com.practice.B_algo_ps.L_puzzles;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by prathapchowdary on 30/01/22.
 */
public class Test {

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, Set<Integer>> data = new TreeMap<>();
        Set<Integer> initialSet = new HashSet<>();
        initialSet.add(0);
        initialSet.add(firstPerson);
        data.put(0, initialSet);
        for (int[] meeting : meetings) {
            Set<Integer> set = new HashSet<>();
            if (data.containsKey(meeting[2])) {
                set = data.get(meeting[2]);
            }
            set.add(meeting[0]);
            set.add(meeting[1]);
            data.put(meeting[2], set);
        }

        Set<Integer> knownSet = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : data.entrySet()) {
            if (entry.getKey() == 0) {
                knownSet.add(0);
                knownSet.addAll(entry.getValue());
            } else {
                Set<Integer> curr = entry.getValue();
                boolean knownFound = false;
                for (int i : curr) {
                    if (knownSet.contains(i)) {
                        knownFound = true;
                        break;
                    }
                }
                if (knownFound) {
                    knownSet.addAll(entry.getValue());
                }
            }
        }
        return knownSet.stream().collect(Collectors.toList());
    }

    public static void main(String args[]) {
        //String s = "bcbcb";
        // String s = "bbbbbbbbbbbbbbbbbbb";
        // int start = 0, end = s.length()-1;
        // while (start < end) {
        //     char charStart = s.charAt(start);
        //     char charEnd = s.charAt(end);
        //     if (charStart != charEnd) break;
        //     while (s.charAt(end) == charStart) end--;
        //     while (s.charAt(start) == charStart) start++;
        // }
        // if (start > end) System.out.println(0);;
        // System.out.println(end - start + 1);

        System.out.println("Hello");

    }

}
