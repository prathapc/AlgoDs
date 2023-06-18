package com.practice.B_algo_ps.A_arrays;

import java.util.*;

/**
 * Created by Prathap on 22 Jan, 2020
 */
public class L_NearestSmallerElement {

    /**
     * find nearest smaller element for every element such that the smaller element is on left side.
     * i/p:- {1,6,4,10,2,5}
     * o/p:- {-,1,1,4,1,2}
     */
    public static ArrayList<Integer> nearestSmallerElement() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(34);arr.add(35);arr.add(27);arr.add(42);arr.add(5);arr.add(28);arr.add(39);arr.add(20);arr.add(28);

        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.size(); i++) {
            while(!st.empty() && st.peek()>=arr.get(i)) {
                st.pop();
            }
            if(st.empty()) {
                result.add(-1);
            } else if(st.peek() < arr.get(i)) {
                result.add(st.peek());
            }
            st.push(arr.get(i));
        }
        return result;
    }

}
