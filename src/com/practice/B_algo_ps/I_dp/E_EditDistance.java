package com.practice.B_algo_ps.I_dp;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

/**
 * Created by prathap on 05/10/17.
 *
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 Insert
 Remove
 Replace
 */
public class E_EditDistance {

  public static void main(String args[]) {
    String str1 = "sunday";
    String str2 = "saturday";
    System.out.println(str1.substring(0, str1.length()));

    int m = str1.length(), n = str2.length();

    //System.out.print(editDistance_recursion(str1, str2, m, n));
    System.out.print(editDistance_dp(str1, str2, m, n));
  }

  private static int editDistance_recursion(String str1, String str2, int m, int n) {
    if(m==0)
      return n;
    if(n==0)
      return m;
    if(str1.charAt(m-1) == str2.charAt(n-1))
      return editDistance_recursion(str1, str2, m-1, n-1);

    return 1 + (Utility.min(
        editDistance_recursion(str1, str2, m-1, n),
        editDistance_recursion(str1, str2, m, n-1),
        editDistance_recursion(str1, str2, m-1, n-1)
    ));
  }

  private int editDistance_topDownDp(String str1, String str2, int m, int n, int[][] data) {
    if(m==0) return n;
    if(n==0) return m;

    if (data[m-1][n-1] != 0) return data[m-1][n-1];

    if(str1.charAt(m-1) == str2.charAt(n-1)) {
      return editDistance_topDownDp(str1, str2, m-1, n-1, data);
    }

    int insert = editDistance_topDownDp(str1, str2, m, n-1, data);
    int remove = editDistance_topDownDp(str1, str2, m-1, n, data);
    int replace = editDistance_topDownDp(str1, str2, m-1, n-1, data);

    data[m-1][n-1] = 1 + Math.min(insert, Math.min(remove, replace));
    return data[m-1][n-1];
  }

  private static int editDistance_dp(String str1, String str2, int m, int n) {
    int dp[][] = new int[m+1][n+1];
    for (int i=0; i<=m; i++) {
      for (int j=0; j<=n; j++) {
        if(i==0)
          dp[i][j] = j;
        else if(j==0)
          dp[i][j] = i;
        else if(str1.charAt(i-1) == str2.charAt(j-1))
          dp[i][j] = dp[i-1][j-1];
        else
          dp[i][j] = 1 + Utility.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);
      }
    }
    return dp[m][n];
  }

}
