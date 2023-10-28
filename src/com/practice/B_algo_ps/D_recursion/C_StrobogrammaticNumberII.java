package com.practice.B_algo_ps.D_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 11/06/22.
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Input: n = 2
 * Output: ["11","69","88","96"]
 *
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 */
public class C_StrobogrammaticNumberII {
    public static char[][] reversiblePairs = {
            {'0', '0'},
            {'1', '1'},
            {'6', '9'},
            {'8', '8'},
            {'9', '6'}
    };

    //Time complexity: N*5^(N/2+1}
    public static List<String> generateStroboNumbers(int n, int finalLength) {
        if (n == 0) {
            // 0-digit strobogrammatic number is an empty string.
            return new ArrayList<>(List.of(""));
        }

        if (n == 1) {
            // 1-digit strobogrammatic numbers.
            return new ArrayList<>(List.of("0", "1", "8"));
        }

        // find n-2 strobonumbers and append reversiblePairs in the beginning and end
        List<String> prevStroboNums = generateStroboNumbers(n - 2, finalLength);
        List<String> currStroboNums = new ArrayList<>();

        for (String prevStroboNum : prevStroboNums) {
            for (char[] pair : reversiblePairs) {
                // We can only append 0's if it is not first digit.
                if (pair[0] != '0' || n != finalLength) {
                    currStroboNums.add(pair[0] + prevStroboNum + pair[1]);
                }
            }
        }

        return currStroboNums;
    }

    public static List<String> findStrobogrammatic(int n) {
        return generateStroboNumbers(n, n);
    }
    public static void main(String args[]) {
        System.out.println(findStrobogrammatic(4));
    }
    /**
     * Explanation of above solution::
     *
     * If the length of the number is 1:
     * The digit will remain at the same position and rotate 180°.
     * Thus, the numbers can only be 0, 1, and 8.
     *
     *
     * If the length is 2:
     * We have two positions (say indices 0 and 1), which will interchange.
     *
     * So we can use,
     * Either two same digits which remain the same after rotation, 11 and 88.
     * Take note that we can't use 0 here because 00 is not a 2 digit number. So we can't place 0 at the 0th
     * index of any number, except for the number 0 itself.
     *
     * Or, two digits that change into one another, 69 and 96.
     * Thus, 2-digit strobogrammatic numbers will be, 11, 69, 88, and 96.
     *
     *
     * If the length is 3:
     * We have three positions (say indices 0, 1, and 2) and out of these three positions, index 0 and index 2 will interchange, but index 1 will remain in the same place.
     *
     * Suppose we have all of the 1-digit strobogrammatic numbers. To find the 3-digit strobogrammatic numbers,
     * we just need to append one extra digit at the beginning and at the end which are reversible.
     * Here, reversible means it will keep the number strobogrammatic.
     * We know that we can use both types of digits (those that change into each other or remain the same after rotation)
     * for this position. But keep in mind that we can't append 0 at the beginning.
     *
     * => '0' + (1-digit strobogrammatic numbers) + '0'
     * '0' + '0' + '0' = '000'  (1-digit number) (not valid)
     * '0' + '1' + '0' = '010' (2-digit number) (not valid)
     * '0' + '8' + '0' = '080' (2-digit number) (not valid)
     *
     * => '1' + (1-digit strobogrammatic numbers) + '1'
     * '1' + '0' + '1' = '101'
     * '1' + '1' + '1' = '111'
     * '1' + '8' + '1' = '181'
     *
     * => '6' + (1-digit strobogrammatic numbers) + '9'
     * '6' + '0' + '9' = '609'
     * '6' + '1' + '9' = '619'
     * '6' + '8' + '9' = '689'
     *
     * => '8' + (1-digit strobogrammatic numbers) + '8'
     * '8' + '0' + '8' = '808'
     * '8' + '1' + '8' = '818'
     * '8' + '8' + '8' = '888'
     *
     * => '9' + (1-digit strobogrammatic numbers) + '6'
     * '9' + '0' + '6' = '906'
     * '9' + '1' + '6' = '916'
     * '9' + '8' + '6' = '986'
     * Thus, these are all of the 3-digit strobogrammatic numbers: 101, 111, 181, 609, 619, 689, 808, 818, 888, 906, 916, and 986.
     *
     *
     * If the length is 44:
     * We have four positions (say indices 0, 1, 2, and 3), and out of these four positions, (index 0, index 3) and (index 1, index 2) will interchange.
     * Suppose we have all of the 2-digit strobogrammatic numbers. To find the 4-digit strobogrammatic numbers, we just need to append one extra digit at the beginning and the end which are reversible (just like previously discussed).
     * But here, in 2-digit strobogrammatic numbers, we can include 00 because after appending a nonzero digit to the beginning and the end, '00' becomes a valid 4-digit number.
     *
     * => '1' + (2-digit strobogrammatic numbers) + '1'
     * '1' + '00' + '1' = '1001'
     * '1' + '11' + '1' = '1111'
     * '1' + '69' + '1' = '1691'
     * '1' + '88' + '1' = '1881'
     * '1' + '96' + '1' = '1961'
     *
     * => '6' + (2-digit strobogrammatic numbers) + '9'
     * '6' + '00' + '9' = '6009'
     * '6' + '11' + '9' = '6119'
     * '6' + '69' + '9' = '6699'
     * '6' + '88' + '9' = '6889'
     * '6' + '96' + '9' = '6969'
     *
     * => '8' + (2-digit strobogrammatic numbers) + '8'
     * '8' + '00' + '8' = '8008'
     * '8' + '11' + '8' = '8118'
     * '8' + '69' + '8' = '8698'
     * '8' + '88' + '8' = '8888'
     * '8' + '96' + '8' = '8968'
     *
     * => '9' + (2-digit strobogrammatic numbers) + '6'
     * '9' + '00' + '6' = '9006'
     * '9' + '11' + '6' = '9116'
     * '9' + '69' + '6' = '9696'
     * '9' + '88' + '6' = '9886'
     * '9' + '96' + '6' = '9966'
     * Thus, 4-digit strobogrammatic numbers will be 1001, 1111, 1691, 1881, 1961, 6009, 6119, 6699, 6889, 6969, 8008, 8118, 8698, 8888, 8968, 9006, 9116, 9696, 9886, and 9966.
     */

    //bfs solution using queue instead of recurstion::
    /**
     * public char[][] reversiblePairs = {
     *         {'0', '0'}, {'1', '1'},
     *         {'6', '9'}, {'8', '8'}, {'9', '6'}
     *     };
     *
     *     public List<String> findStrobogrammatic(int n) {
     *         Queue<String> q = new LinkedList<>();
     *         int currStringsLength;
     *
     *         // When n is even, it means when decreasing by 2 we will go till 0.
     *         if (n % 2 == 0) {
     *             // We will start with 0-digit strobogrammatic numbers.
     *             currStringsLength = 0;
     *             q.add("");
     *         } else {
     *             // We will start with 1-digit strobogrammatic numbers.
     *             currStringsLength = 1;
     *             q.add("0");
     *             q.add("1");
     *             q.add("8");
     *         }
     *
     *         while (currStringsLength < n) {
     *             currStringsLength += 2;
     *             for (int i = q.size(); i > 0; --i) {
     *                 String number = q.poll();
     *
     *                 for (char[] pair : reversiblePairs) {
     *                     if (currStringsLength != n || pair[0] != '0') {
     *                         q.add(pair[0] + number + pair[1]);
     *                     }
     *                 }
     *             }
     *         }
     *
     *         List<String> stroboNums = new ArrayList<>();
     *         while (!q.isEmpty()) {
     *             stroboNums.add(q.poll());
     *         }
     *
     *         return stroboNums;
     *     }
     */
}
