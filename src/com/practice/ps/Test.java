package com.practice.ps;
import java.util.*;

/**
 * Created by Prathap on 22 Oct, 2019
 */
public class Test {

    public static void main(String args[]) {

        String str = "test.email+alex";
        int n = str.indexOf("+");
        System.out.println(str.substring(0, n));

        str.replaceAll(".", "");
        System.out.println(str);

        char c = '7';
        //int n = c;
        System.out.println(Integer.parseInt(String.valueOf(c)));

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        System.out.println(list.indexOf(1));

        Map<Integer, Integer> map = new TreeMap<>();
    }

}
