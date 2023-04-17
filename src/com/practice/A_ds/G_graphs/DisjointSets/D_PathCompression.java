package com.practice.A_ds.G_graphs.DisjointSets;

/**
 * Created by prathapchowdary on 19/09/21.
 *
 * In QuickUnion, find has worst complexity when its skewed
 * To make it efficient we can store all roots on the pass so that next time we can simply return root of any element
 */
public class D_PathCompression {
    private int[] root;

    public D_PathCompression(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    //O(logN)
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]); //this is the optimization; storing prev results like in DP => we are changing root for all elements in the process so that in the subsequent find will be faster
    }

    //O(logN)
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    //O(logN)
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static class App {
        public static void main(String[] args) throws Exception {
            D_PathCompression uf = new D_PathCompression(10);
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
