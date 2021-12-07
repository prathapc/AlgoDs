package com.practice.B_algo.B_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 16/10/21.
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * k == 0
 * [1]
 * k == 1
 * [11]
 * k == 2
 * [111]  add 1
 * [121]  calculate jth spot
 * k == 3
 * [1211]  add 1
 * [1331]   calculate jth spot
 * k == 4
 * [13311]  add 1
 * [14641]  calculate jth spot
 */
public class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            res.add(1);
            for(int j = i-1; j > 0; j--) {
                res.set(j, res.get(j-1) + res.get(j));
            }
        }
        return res;
    }
}
