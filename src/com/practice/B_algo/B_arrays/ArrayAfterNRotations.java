package com.practice.B_algo.B_arrays;

import java.util.*;

/**
 * Created by Prathap on 22 Jan, 2020
 */
public class ArrayAfterNRotations {

    private static void arrayAfterNRotations() {
        int B = 18;
        Integer a[] = {44, 41, 12, 42, 71, 45, 28, 65, 75, 93, 66, 66, 37, 6, 24, 59 };
        ArrayList<Integer> A = new ArrayList<>();
        for(int i : a) {
            A.add(i);
        }
        ArrayList<Integer> ret = new ArrayList<>();
        if(B > A.size())
            B = B%A.size();
        for (int i = 0; i < A.size(); i++) {
            if(i+B >= A.size())
                break;
            ret.add(A.get(i + B));
        }
        for(int j=0; j<B; j++) {
            ret.add(A.get(j));
        }
        ret.forEach(System.out::println);
    }


}
