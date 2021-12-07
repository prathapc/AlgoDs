package com.practice.B_algo.J_bfs_dfs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Prathap on 01 Dec, 2019
 *
 * https://leetcode.com/problems/frog-jump/
 *
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units.
 *
 * [0,1,3,5,6,8,12,17]
 *
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 *
 * Return true. The frog can jump to the last stone by jumping
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 * 2 units to the 4th stone, then 3 units to the 6th stone,
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 */
public class FrogJump {

    public boolean canCross(int[] stones) {
        for (int i=3; i<stones.length; i++) {
            if (stones[i] > stones[i-1]*2) {
                return false;
            }
        }
        Set<Integer> stonesSet = new HashSet<>();
        for (int i=0; i<stones.length; i++) {
            stonesSet.add(stones[i]);
        }

        int lastStone = stones[stones.length-1];
        //we need to track two things. one current jump position and
        // second no of steps took to reach curr position; hence two stacks
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumpDistances = new Stack<>();
        positions.add(0);
        jumpDistances.add(0);
        while (!positions.isEmpty()) {
            int curPosition = positions.pop();
            int jumpsTookToreachCurr = jumpDistances.pop();
            for (int i=jumpsTookToreachCurr-1; i<=jumpsTookToreachCurr+1; i++) {
                if (i <= 0) {
                    continue;
                }

                int nextPosition = curPosition + i;
                if (nextPosition == lastStone) {
                    return true;
                } else if (stonesSet.contains(nextPosition)) {
                    positions.add(nextPosition);
                    jumpDistances.add(i);
                }

            }
        }
        return false;
    }

}
