package com.practice.A_ds.G_graphs.DisjointSets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 17/04/23.
 *
 * https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/
 */
class A_DisjoinSets
{
    private static Map<Integer, Integer> parent = new HashMap<>();

    public static void makeSet(int[] universe) {
        // create `n` disjoint sets (one for each item)
        for (int i: universe) {
            parent.put(i, i);
        }
    }

    // Find the root of the set in which element `k` belongs
    public static int find(int k) {
        // if `k` is root
        if (parent.get(k) == k) {
            return k;
        }
        // recur for the parent until we find the root
        return find(parent.get(k));
    }

    // Perform Union of two subsets
    public static void union(int a, int b) {
        // find the root of the sets in which elements `x` and `y` belongs
        int x = find(a);
        int y = find(b);

        parent.put(x, y);
    }

    public static void printSets(int[] universe) {
        for (int i: universe) {
            System.out.print(find(i) + " ");
        }
        System.out.println();
    }

    // Disjoint–Set data structure (Union–Find algorithm)
    public static void main(String[] args) {
        // universe of items
        int[] universe = { 1, 2, 3, 4, 5 };

        makeSet(universe);
        printSets(universe);

        union(1,2);
        union(1,3);
        union(3,4);

        union(4, 3);        // 4 and 3 are in the same set
        printSets(universe);

        union(2, 1);        // 1 and 2 are in the same set
        printSets(universe);

        union(1, 3);        // 1, 2, 3, 4 are in the same set
        printSets(universe);
    }
}
