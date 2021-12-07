package com.practice.B_algo.D_recursion;

/**
 * Given a positive number, find out all combinations of positive numbers that adds upto that number.
 * The program should print only combinations, not permutations.
 *
 * For example, for input 3, either 1, 2 or 2, 1 should be printed.
 */
public class E_CombinationsAddUptoGivenNumber {

  public static void main (String[] args) {
    findCombinations(6);
  }

  /* Function to find out all combinations of positive numbers that add upto given number. It uses findCombinationsUtil() */
  private static void findCombinations(int n) {
    // array to store the combinations It can contain max n elements
    int arr[] = new int [n];

    // find all combinations
    findCombinationsUtil(arr, 0, n, n);
  }

  static void findCombinationsUtil(int arr[], int index, int num, int reducedNum) {
    // Base condition
    if (reducedNum < 0)
      return;
    // If combination is found, print it
    if (reducedNum == 0) {
      for (int i = 0; i < index; i++)
        System.out.print (arr[i] + " ");
      System.out.println();
      return;
    }

    // Find the previous number stored in arr[]. It helps in maintaining increasing order
    int prev = (index == 0) ? 1 : arr[index - 1];

    // note loop starts from previous number i.e. at array location index - 1
    for (int k = prev; k <= num ; k++) {
      // next element of array is k
      arr[index] = k;

      // call recursively with reduced number
      findCombinationsUtil(arr, index + 1, num,
          reducedNum - k);
    }
  }
}
