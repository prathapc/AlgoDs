package com.practice.E_java;

import java.util.*;

/**
 * Created by Prathap on 18 Jan, 2020
 */
public class MapWithCustomComparator {

    public static void main(String args[]) {
        //default asc order
        Map<String, Integer> map1 = new TreeMap<>();
        map1.put("a", 1);
        map1.put("z", 2);
        map1.put("c", 1);

        map1.forEach((a, b) -> System.out.println(a));

        //desc order
        /*Map<String, Integer> map2 = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });*/
        Map<String, Integer> map2 = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
        map2.put("a", 1);
        map2.put("z", 2);
        map2.put("c", 1);

        map2.forEach((a, b) -> System.out.println(a));

    }
}
