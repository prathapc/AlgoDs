package com.practice.E_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by prathapchowdary on 17/06/23.
 */
public class JavaCollectionTransformations {
    public static void main(String args[]) {
        //list to array
        List<Integer> list = new ArrayList<>();
        int[] arr = list.stream().mapToInt(i->i).toArray();


    }
}
