package com.practice.algo.arrays;

import java.util.*;

/**
 * Created by Prathap on 22 Jan, 2020
 */
public class MatrixInSpiralOrder {

    private static void printMatrixInSpiralOrder() {
        List<ArrayList<Integer>> aList = new ArrayList<>();
        ArrayList<Integer> inner1 = new ArrayList<Integer>();
        inner1.add(1);inner1.add(2);inner1.add(3);
        aList.add(inner1);
        ArrayList<Integer> inner2 = new ArrayList<Integer>();
        inner2.add(4);inner2.add(5);inner2.add(6);
        aList.add(inner2);
        ArrayList<Integer> inner3 = new ArrayList<Integer>();
        inner3.add(7);inner3.add(8);inner3.add(9);
        aList.add(inner3);

        int r = aList.size();
        int c = aList.get(0).size();
        int[][] a = new int[r][c];

        for(int i=0; i<r; i++) {
            for(int j=0; j<r; j++) {
                a[i][j] = aList.get(i).get(j);
                //System.out.print(a[i][j] + " ");
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        int i, k = 0, l = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */
        int m=r, n=c;
        while (k < m && l < n)
        {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i)
            {
                result.add(a[k][i]);
            }
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < m; ++i)
            {
                result.add(a[i][n-1]);
            }
            n--;

            // Print the last row from the remaining rows */
            if ( k < m)
            {
                for (i = n-1; i >= l; --i)
                {
                    result.add(a[m-1][i]);
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (l < n)
            {
                for (i = m-1; i >= k; --i)
                {
                    result.add(a[i][l]);
                }
                l++;
            }

            for(Integer kk : result) {
                System.out.print(kk + " ");
            }
        }
    }

}
