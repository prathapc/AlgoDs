package com.practice.A_ds.G_graphs.DisjointSets;

/**
 * Created by prathapchowdary on 18/09/21.
 *
 * Complexitywise QucikUnion is better than QuickFind
 * QuickFind complexity for connecting n elements is n*unionComplexity which is n => overall n^2
 * QuickFind complexity for connecting n elements is n*unionComplexity which is less than n => overall < n^2
 *
 * Neither approaches are efficient for worst case when our set is skewed input: 1 - 2 - 3 - 4 - 5
 *
 * Somehow if reduce height of tree then it will be efficient and we can do this by selecting right root out of x,y
 * How do you find which one is right root? whichever has more height already
 * suppose there are two sets as below and we want to connect then (0, 5)
 *
 * 0 - 1 - 2 - 3 - 4
 * 5 - 6
 *
 * here select root as 0 instead of 5 because root 0 height is 5 where as root 5 height is 2
 *
 * Overall complexity will be O(log n) for union and find and isConnected
 * Note: this union by rank technique applicable for QuickUnion only
 */
public class C_UnionByRank {
    private int[] data;
    private int[] rank;
    public C_UnionByRank(int size) {
        data = new int[size];
        rank = new int[size];
        for (int i=0; i<size; i++) {
            data[i] = i;
            rank[i] = i;
        }
    }

    //O(logN)
    public int find(int x) {
        while (x != data[x]) {
            x = data[x];
        }
        return x;
    }

    //O(logN)
    public void union(int x, int y) {
        //same as QuickUnion but identify height and select root accordingly
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                data[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                data[rootX] = rootY;
            } else {
                //if same select any and increment height
                data[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static class App {
        public static void main(String[] args) throws Exception {
            C_UnionByRank uf = new C_UnionByRank(10);
            // 1-2-5-6-7 3-8-9 4
            uf.union(1, 2);
            uf.union(2, 5);
            uf.union(5, 6);
            uf.union(6, 7);
            uf.union(3, 8);
            uf.union(8, 9);
            System.out.println(uf.isConnected(1, 5)); // true
            System.out.println(uf.isConnected(5, 7)); // true
            System.out.println(uf.isConnected(4, 9)); // false
            // 1-2-5-6-7 3-8-9-4
            uf.union(9, 4);
            System.out.println(uf.isConnected(4, 9)); // true
        }
    }
}
