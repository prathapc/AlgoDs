package com.practice.A_ds.G_graphs.DisjointSets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prathapchowdary on 17/04/23.
 *
 * The above approach is no better than the linked list approach because the tree it creates
 * can be highly unbalanced; however, we can enhance it in two ways.
 *
 * 1. The first way, called union by rank, is to always attach the smaller tree to the root of the
 * larger tree. Since it is the depth of the tree that affects the running time, the tree with a
 * smaller depth gets added under the root of the deeper tree, which only increases
 * the depth of the depths were equal. Single element trees are defined to have a rank of zero,
 * and whenever two trees of the same rank r are united, the result has the rank of r+1.
 * The worst-case running-time improves to O(log(n)) for the Union or Find operation.
 *
 * 2. The second improvement, called path compression, is a way of flattening the tree’s structure whenever
 * Find is used on it. The idea is that each node visited heading to a root node may as well be attached
 * directly to the root node; they all share the same representative. To effect this, as Find recursively
 * traverses up the tree, it changes each node’s parent reference to point to the root that is found.
 * The resulting tree is much flatter, speeding up future operations not only on these elements but
 * on those referencing them, directly or indirectly.
 *
 */
class B_DisjoinSets_Optimized
{
    private static Map<Integer, Integer> parent = new HashMap<>();
    // stores the depth of trees
    private static Map<Integer, Integer> rank = new HashMap<>();

    public static void makeSet(int[] universe) {
        // create `n` disjoint sets (one for each item)
        for (int i: universe) {
            parent.put(i, i);
            rank.put(i, 0);
        }
    }

    // Find the root of the set in which element `k` belongs
    public static int find(int k) {
        // if `k` is not the root
        if (parent.get(k) != k) {
            // path compression
            parent.put(k, find(parent.get(k)));
        }
        return parent.get(k);
    }

    // Perform Union of two subsets
    public static void union(int a, int b)
    {
        // find the root of the sets in which elements `x` and `y` belongs
        int x = find(a);
        int y = find(b);

        // if `x` and `y` are present in the same set
        if (x == y) {
            return;
        }

        // Always attach a smaller depth tree under the root of the deeper tree.
        if (rank.get(x) > rank.get(y)) {
            parent.put(y, x);
        }
        else if (rank.get(x) < rank.get(y)) {
            parent.put(x, y);
        }
        else {
            parent.put(x, y);
            rank.put(y, rank.get(y) + 1);
        }
    }

    public static void printSets(int[] universe) {
        for (int i: universe) {
            System.out.print(find(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // universe of items
        int[] universe = { 1, 2, 3, 4, 5 };

        // create a singleton set for each element of the universe
        makeSet(universe);
        printSets(universe);

        union(4, 3);        // 4 and 3 are in the same set
        printSets(universe);

        union(2, 1);        // 1 and 2 are in the same set
        printSets(universe);

        union(1, 3);        // 1, 2, 3, 4 are in the same set
        printSets(universe);
    }
}
