package com.practice.B_algo_ps.K_sort_search_math.math_geometry;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 13/11/23.
 *
 * https://leetcode.com/problems/detect-squares/
 */
public class M_DetectSquares {
    Map<String, Integer> pointCountMap = null;
    public M_DetectSquares() {
        pointCountMap = new HashMap<>();
    }

    public void add(int[] point) {
        String key = point[0] + ":" + point[1];
        pointCountMap.put(key, pointCountMap.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int res = 0;
        for (String key : pointCountMap.keySet()) {
            String[] existingPoint = key.split(":");
            int x = Integer.parseInt(existingPoint[0]);
            int y = Integer.parseInt(existingPoint[1]);
            if (Math.abs(px-x) == Math.abs(py-y) && px != x && py != y) {
                String diagonalPoint1 = px + ":" + y;
                String diagonalPoint2 = x + ":" + py;
                if (pointCountMap.containsKey(diagonalPoint1) && pointCountMap.containsKey(diagonalPoint2)) {
                    res += pointCountMap.get(key) * pointCountMap.get(diagonalPoint1) * pointCountMap.get(diagonalPoint2);
                }
            }
        }
        return res;
    }

    /**
     Intuition: We keep track of points along with the counter in a hashmap during the add method.
     Every time count method is called, we iterate through each of the points in the hashmap.
     We consider each point from the HashMap (say (x,y)) as a diagonal point to the query
     point (say (px, py)).
     Since it is given the square needs to be axis-aligned , the condition for two points to
     form a axis-aligned square is that, the absolute distance between the x and y coordinates
     distances should be equal. If they are not equal it means they will form a rectangle instead
     of a square. This is a typical geometry property. Try to visualize it with couple of examples.
     Eg: Valid square diagonals are : (3,2) and (11,10) . The absolute coordinate distance
     differences are (11 - 3) and (10 - 2) which is 8 is both cases . So these points can form a square.
     So assuming these two diagonal points form a square , we construct two other diagonal points for eg:
     for diagonal points (x , y) , (px, py) other two diagonal points will be (x, py) , (px, y)
     So we check if these two diagonal points are present in map . If they are present we just
     count the total squares that can be formed by usign product of each of the diagonal points counts.

     Time Complexity: O(N)
     Space Complexity: O(N)
     */
}
