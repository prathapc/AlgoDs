package com.practice.A_ds.G_graphs;

import java.util.*;

/**
 * Created by prathapchowdary on 30/10/22.
 *
 * https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
 */
public class B3_ColoringGraph {
    public static void main(String args[]) {
        int n = 4;
        int[][] graph = {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 1, 0, 1, 0 } };
        int m = 3; // Number of colors

        ArrayList<Node> nodes = new ArrayList<Node>();

        for (int i = 0; i < n + 1; i++) {
            nodes.add(new Node());
        }

        // Add edges to each node as per given input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] > 0) {
                    // Connect the undirected graph
                    nodes.get(i).edges.add(i);
                    nodes.get(j).edges.add(j);
                }
            }
        }

        System.out.println(canPaint(nodes, n, m));
    }

    static int canPaint(ArrayList<Node> nodes, int n, int m) {

        ArrayList<Integer> visited = new ArrayList<Integer>();
        for (int i = 0; i < n + 1; i++) {
            visited.add(0);
        }

        int maxColors = 1;

        // Do a full BFS traversal from all unvisited starting points
        for (int sv = 1; sv <= n; sv++) {
            if (visited.get(sv) > 0) {
                continue;
            }

            // If the starting point is unvisited, mark it visited and push it in queue
            visited.set(sv, 1);
            Queue<Integer> q = new LinkedList<>();
            q.add(sv);

            // BFS Travel starts here
            while (!q.isEmpty()) {
                int top = q.peek();
                q.remove();

                // Checking all adjacent nodes to "top" edge in our queue
                for (int it : nodes.get(top).edges) {

                    // IMPORTANT: If the color of the adjacent node is same, increase it by 1
                    if (nodes.get(top).color
                            == nodes.get(it).color) {
                        nodes.get(it).color += 1;
                    }

                    // If number of colors used shoots m, return 0
                    maxColors = Math.max(maxColors, Math.max(nodes.get(top).color, nodes.get(it).color));
                    if (maxColors > m)
                        return 0;

                    // If the adjacent node is not visited, mark it visited and push it in queue
                    if (visited.get(it) == 0) {
                        visited.set(it, 1);
                        q.add(it);
                    }
                }
            }
        }
        return 1;
    }

    static class Node {
        // A node class which stores the color and the edges
        // connected to the node
        int color = 1;
        Set<Integer> edges = new HashSet<>();
    }
}
