package com.practice.F_companyQA.fb;

/**
 * Created by Prathap on 18 Jan, 2020
 *
 * https://leetcode.com/problems/friends-of-appropriate-ages/
 *
 * Algorithm
 * ---------
 *
 * For each pair (ageA, countA), (ageB, countB), if the conditions are satisfied with respect to age,
 * then countA * countB pairs of people made friend requests.
 *
 * If ageA == ageB, then we overcounted:
 * we should have countA * (countA - 1) pairs of people making friend requests instead, as you cannot friend request yourself.
 */
public class FriendsOfAppropriateAges {

    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) count[age]++;

        int ans = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 0; ageB <= 120; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) continue;
                if (ageA < ageB) continue;
                if (ageA < 100 && 100 < ageB) continue;
                ans += countA * countB;
                if (ageA == ageB) ans -= countA;
            }
        }

        return ans;
    }

}
