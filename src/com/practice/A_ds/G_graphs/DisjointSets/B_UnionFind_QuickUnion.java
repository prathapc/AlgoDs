package com.practice.A_ds.G_graphs.DisjointSets;

/**
 * Created by prathapchowdary on 18/09/21.
 */
public class B_UnionFind_QuickUnion {

    private int[] data;
    public B_UnionFind_QuickUnion(int size) {
        data = new int[size];
        for (int i=0; i<size; i++) {
            data[i] = i;
        }
    }

    //O(n)
    public int find(int x) {
        while (x != data[x]) {
            x = data[x];
        }
        return x;
    }

    //O(n) only in worst case
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            data[rootY] = rootX; //assigning x as root to y
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static class App {
        public static void main(String[] args) throws Exception {
            B_UnionFind_QuickUnion uf = new B_UnionFind_QuickUnion(10);
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
