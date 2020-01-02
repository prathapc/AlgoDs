package com.practice.algo;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by prathap on 05/08/17.
 *
 * https://www.geeksforgeeks.org/count-strings-can-formed-using-b-c-given-constraints/
 *
 */
public class TotalNoOfStringsOfLengthNWithGivenCharacters {
  public static void main(String[] args) {
    int n = 3;
    char[] chars = {'a', 'a', 'a', 'b', 'c', 'c'};
    System.out.println(count(chars, n));
  }

  private static int count(char[] charRepeat, int n) {
    Set<String> result = new LinkedHashSet<>();

    for(int i=0; i<charRepeat.length; i++) {
      for(int j=0; j<charRepeat.length; j++) {
        for(int k=0; k<charRepeat.length; k++) {
          if(i!=j && j!= k && k!=i)
            result.add(charRepeat[i]+""+charRepeat[j]+""+charRepeat[k]+"");
        }
      }
    }

    for(String str : result) {
      System.out.println(str);
    }

    return result.size();
  }

  //dp solution
  static int countStrUtil(int[][][] dp, int n,
                          int bCount, int cCount) {

    // Base cases
    if (bCount < 0 || cCount < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    if (bCount == 0 && cCount == 0) {
      return 1;
    }

    // if we had saw this combination previously
    if (dp[n][bCount][cCount] != -1) {
      return dp[n][bCount][cCount];
    }

    // Three cases, we choose, a or b or c
    // In all three cases n decreases by 1.
    int res = countStrUtil(dp, n - 1, bCount, cCount);
    res += countStrUtil(dp, n - 1, bCount - 1, cCount);
    res += countStrUtil(dp, n - 1, bCount, cCount - 1);

    return (dp[n][bCount][cCount] = res);
  }

  // A wrapper over countStrUtil()
  static int countStr(int n, int bCount, int cCount) {
    int[][][] dp = new int[n + 1][2][3];
    for (int i = 0; i < n + 1; i++)
    {
      for (int j = 0; j < 2; j++)
      {
        for (int k = 0; k < 3; k++)
        {
          dp[i][j][k] = -1;
        }
      }
    }
    return countStrUtil(dp, n,bCount,cCount);
  }

}
