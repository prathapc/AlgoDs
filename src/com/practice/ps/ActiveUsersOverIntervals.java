package com.practice.ps;

import java.util.Scanner;

/**
 * Created by prathap on 13/07/17.
 */
public class ActiveUsersOverIntervals {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //int currAgents = Integer.parseInt(scanner.nextLine());
    int n = Integer.parseInt(scanner.nextLine());
    int[] start = new int[n];
    int[] end = new int[n];
    int startIndex = 0, endIndex = 0;
    for(int i=0; i<n; i++) {
      String input[] = scanner.nextLine().split(" ");

      start[startIndex++] = Integer.parseInt(input[0].trim());
      end[endIndex++] = Integer.parseInt(input[1].trim());

    }
    quickSort(start, 0, start.length-1);
    quickSort(end, 0, end.length-1);
    findExecutivesRequired(start, end);
    }

    private static void findExecutivesRequired(int[] start, int[] end) {
      int requiredAgents = 1, result = 1;
      int i=1, j=0;
      while(i<start.length && j<end.length) {
        if(start[i] <= end[j]) {
          requiredAgents++;
          i++;
          if(requiredAgents > result) {
            result = requiredAgents;
          }
        } else {
          requiredAgents--;
          j++;
        }
      }
      System.out.println(result);

    }

    private static void quickSort(int[] a, int start, int end) {
      if(start < end) {
        int pIndex = quicksortPartition(a, start, end);
        quickSort(a, start, pIndex-1);
        quickSort(a, pIndex+1, end);
      }
    }

    private static int quicksortPartition(int[] a, int start, int end) {
      int pivot = a[end];
      int pIndex = start;
      for(int i=start; i<end; i++) {
        if(a[i] <= pivot) {
          swapElementsInArray(a, i, pIndex);
          pIndex++;
        }
      }
      swapElementsInArray(a, pIndex, end);
      return pIndex;
    }

    private static void swapElementsInArray(int[] a, int i, int j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }


}
