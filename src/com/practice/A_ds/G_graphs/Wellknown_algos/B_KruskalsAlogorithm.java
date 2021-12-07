package com.practice.A_ds.G_graphs.Wellknown_algos;

import java.util.*;

/**
 * Created by prathapchowdary on 23/10/21.
 *
 * Its an algorithm to construct min spanning tree of weighted undirected graph.
 *
 * step 1. asc order all edges
 * step 2. Keep adding n-1 edges (skip if it leads to cycle)
 * time complexity : O(E logV) (As we need to sort)
 */
public class B_KruskalsAlogorithm  {
    public static void main(String[] args)
    {
        // `(u, v, w)` triplet represent undirected edge from
        // vertex `u` to vertex `v` having weight `w`
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 7), new Edge(1, 2, 8),
                new Edge(0, 3, 5), new Edge(1, 3, 9),
                new Edge(1, 4, 7), new Edge(2, 4, 5),
                new Edge(3, 4, 15), new Edge(3, 5, 6),
                new Edge(4, 5, 8), new Edge(4, 6, 9),
                new Edge(5, 6, 11)
        );

        // total number of nodes in the graph
        final int N = 7;

        // construct graph
        List<Edge> e = DisjointSet.kruskalAlgo(edges, N);
        System.out.println(e);
    }

    static class DisjointSet {
        Map<Integer, Integer> parent = new HashMap<>();

        // perform MakeSet operation
        public void makeSet(int N) {
            // create `N` disjoint sets (one for each vertex)
            for (int i = 0; i < N; i++) {
                parent.put(i, i);
            }
        }

        // Find the root of the set in which element `k` belongs
        private int Find(int k) {
            // if `k` is root
            if (parent.get(k) == k) {
                return k;
            }

            // recur for the parent until we find the root
            return Find(parent.get(k));
        }

        // Perform Union of two subsets
        private void Union(int a, int b) {
            // find the root of the sets in which elements
            // `x` and `y` belongs
            int x = Find(a);
            int y = Find(b);

            parent.put(x, y);
        }

        // Function to construct MST using Kruskal’s algorithm
        public static List<Edge> kruskalAlgo(List<Edge> edges, int N) {
            // stores the edges present in MST
            List<Edge> MST = new ArrayList<>();

            // Initialize `DisjointSet` class.
            // create a singleton set for each element of the universe.
            DisjointSet ds = new DisjointSet();
            ds.makeSet(N);

            int index = 0;

            // sort edges by increasing weight
            Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

            // MST contains exactly `V-1` edges
            while (MST.size() != N - 1)
            {
                // consider the next edge with minimum weight from the graph
                Edge next_edge = edges.get(index++);

                // find the root of the sets to which two endpoints
                // vertices of the next edge belongs
                int x = ds.Find(next_edge.src);
                int y = ds.Find(next_edge.dest);

                // if both endpoints have different parents, they belong to
                // different connected components and can be included in MST
                if (x != y)
                {
                    MST.add(next_edge);
                    ds.Union(x, y);
                }
            }
            return MST;
        }
    }

    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + src + ", " + dest + ", " + weight + ")";
        }
    }
}
