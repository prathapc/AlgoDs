package com.practice.A_ds.G_graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class R_TopologicalSort {

	//https://en.wikipedia.org/wiki/Topological_sorting#Kahn's_algorithm
	private void topologicalSort(R_TopologicalSort g) {
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[v];

		for(int i=0; i<v; i++) {
			if(!visited[i])
				topologicalSortUtil(i, visited, stack);
		}

		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		Iterator<Integer> itr = adj[v].iterator();
		Integer i;
		while(itr.hasNext()) {
			i = itr.next();
			if(!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		stack.push(v);
	}

	private int v;  //no of vertices
	private List<Integer> adj[];  //adjacency list
	
	R_TopologicalSort(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public static void main(String[] args) {
		/*GraphTopologicalSort g = new GraphTopologicalSort(6);
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);*/

		R_TopologicalSort g = new R_TopologicalSort(3);
		g.addEdge(0, 1);
		g.addEdge(1, 2);

		g.topologicalSort(g);
	}

}
