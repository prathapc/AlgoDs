package com.practice.algo.bfs_dfs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Prathap on 01 Dec, 2019
 *
 * https://leetcode.com/problems/frog-jump/submissions/
 *
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
        //we need to track two things. one current jump position and second
        //no of stemps took to reach curr position; hence two stacks
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
