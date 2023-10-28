package com.practice.A_ds.G_graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prathapchowdary on 07/09/23.
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
 * you must take course ai first if you want to take course bi.
 *
 * For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
 * Prerequisites can also be indirect.
 * If course a is a prerequisite of course b, and course b is a prerequisite of course c,
 * then course a is a prerequisite of course c.
 *
 * You are also given an array queries where queries[j] = [uj, vj].
 * For the jth query, you should answer whether course uj is a prerequisite of course vj or not.
 *
 * Return a boolean array answer, where answer[j] is the answer to the jth query.
 *
 * https://leetcode.com/problems/course-schedule-iv/
 */
public class S_CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean adjMatrix[][] = new boolean[n][n];
        for (int[] i : prerequisites){
            adjMatrix[i[0]][i[1]] = true;
        }

        for (int k = 0; k < n; ++k){
            for (int i = 0; i < n ; ++i){
                for (int j = 0; j < n ; ++j){
                    adjMatrix[i][j] = adjMatrix[i][j] || (adjMatrix[i][k] && adjMatrix[k][j]);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; ++i){
            ans.add(adjMatrix[queries[i][0]][queries[i][1]]);
        }
        return ans;
    }

    /**
     **************IMPORTANT READ ON TRANSITIVE CLOSURE*******
     * *****(the one i have implemented in arcesium for lookthrough investments)*****
     *
     * Brute force :
     * for each i th query
     * start dfs from queries[i][0]
     * if you reach queries[i][1] return True
     * else False
     *
     * Since there can be 10^4 queries, we cannot do dfs every time for each query to
     * find if there is a path between queries[i][0] and queries[i][1]
     *
     * We must answer each query in O(1) time
     *
     * What is transitive closure of a graph
     *
     * It is a matrix m in which
     * m[i][j] is True if there j is reachable from i (can be a more than 1 edge path)
     * m[i][j] is False if j cannot be reached from i
     *
     * Once we get the matrix of transitive closure, each query can be answered in O(1) time
     * eg: query = (x,y) , answer will be m[x][y]
     *
     * To compute the matrix of transitive closure we use Floyd Warshall's algorithm which takes O(n^3) time and O(n^2) space.
     */
}
