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
        String s = "bbbbbbbbbbbbbbbbbbb";
        int start = 0, end = s.length()-1;
        while (start < end) {
            char charStart = s.charAt(start);
            char charEnd = s.charAt(end);
            if (charStart != charEnd) break;
            while (s.charAt(end) == charStart) end--;
            while (s.charAt(start) == charStart) start++;
        }
        if (start > end) System.out.println(0);;
        System.out.println(end - start + 1);








        String[] logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // split each log into two parts: <identifier, content>
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // case 1). both logs are letter-logs
                if (!isDigit1 && !isDigit2) {
                    // first compare the content
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0)
                        return cmp;
                    // logs of same content, compare the identifiers
                    return split1[0].compareTo(split2[0]);
                }

                // case 2). one of logs is digit-log
                if (!isDigit1 && isDigit2)
                    // the letter-log comes before digit-logs
                    return -1;
                else if (isDigit1 && !isDigit2)
                    return 1;
                else
                    // case 3). both logs are digit-log
                    return 0;
            }
        };

        Arrays.sort(logs, myComp);


    }

}