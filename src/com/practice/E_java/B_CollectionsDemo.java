package com.practice.E_java;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by prathapchowdary on 18/06/22.
 */
public class B_CollectionsDemo {
    public static void main(String args[]) {
        // iterate over map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "abc");
        map.put(3, "def");
        map.put(2, "aaa");
        for(Map.Entry me : map.entrySet()) { // java 7
            System.out.println(me.getKey() + " " + me.getValue());
        }
        map.forEach((key, value) -> { // java 8
            System.out.println(key+" : "+ value);
        });
        for (var entry : map.entrySet()) { // java 10+
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        //sort by map value
        Comparator<Map.Entry<Integer, String>> byValue = (entry1, entry2) ->
                entry1.getValue().compareTo(entry2.getValue());
        map = map
                .entrySet()
                .stream()
                .sorted(byValue.reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        map.forEach((k, v) -> System.out.println(k + ":" + v));

    }


}
