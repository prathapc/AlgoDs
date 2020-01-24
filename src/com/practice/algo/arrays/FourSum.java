package com.practice.algo.arrays;

import java.util.*;

/**
 * Created by Prathap on 22 Jan, 2020
 */
public class FourSum {

    public static void main(String[] args) throws Exception {
        find4ElementsWithSumEqualToK();
    }

    private static void find4ElementsWithSumEqualToK() {
        //int a[] = new int[]{10, 2, 3, 4, 5, 9, 7, 8};
        int a[] = new int[]{3,2,1,6,4,5};
        int x = 12;

        find4ElementsWithSumEqualToKUtil(a, x);
    }

    private static void find4ElementsWithSumEqualToKUtil(int[] a, int x) {
        int n = a.length;
        int auxArraySize = n*(n-1)/2;

        PairSum aux[] = new PairSum[auxArraySize];
        for(int i=0; i<auxArraySize; i++) {
            PairSum ps = new PairSum();
            aux[i] = ps;
        }
        int k = 0;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                aux[k].sum = a[i]+a[j];
                aux[k].i = a[i];
                aux[k].j = a[j];
                k++;
            }
        }
        quickSort(aux, 0, auxArraySize);
        int i=0;
        int j=auxArraySize-1;
        while(i<auxArraySize && j>=0) {
            if(aux[i].sum + aux[j].sum == x && noCommon(aux[i], aux[j])) {
                System.out.println(aux[i].i + " " + aux[i].j + " " + aux[j].i + " " + aux[j].j);
                i++;
                j--;
            } else if(aux[i].sum + aux[j].sum < x) {
                i++;
            } else {
                j--;
            }
        }
    }

    private static void quickSort(PairSum[] aux, int start, int end) {
        if(start < end) {
            int pIndex = quickSortPartition(aux, start, end);
            quickSort(aux, start, pIndex-1);
            quickSort(aux, pIndex+1, end);
        }
    }

    private static int quickSortPartition(PairSum[] aux, int start, int end) {
        int pIndex = start;
        int pivot = aux[end-1].sum;
        for(int i=start; i<end; i++) {
            if(aux[i].sum < pivot) {
                swap(aux, i, pIndex);
                pIndex++;
            }
        }
        swap(aux, pIndex, end-1);
        return pIndex;
    }

    private static boolean noCommon(PairSum pairSum1, PairSum pairSum2) {
        if(pairSum1.i == pairSum2.i || pairSum1.i == pairSum2.j || pairSum1.j == pairSum2.j || pairSum1.j == pairSum2.i) {
            return false;
        }
        return true;
    }

    private static void swap(PairSum[] aux, int i, int pIndex) {
        PairSum temp = aux[i];
        aux[i] = aux[pIndex];
        aux[pIndex] = temp;
    }

    static class PairSum {
        int i;
        int j;
        int sum;

    }

}
