package com.practice.ds;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {

	private int v;  //no of vertices
	private List<Integer> adj[];  //adjacency list
	
	Graph(int v) {
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
		Graph g = new Graph(6);
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
		
		g.topologicalSort(g);
	}

	private void topologicalSort(Graph g) {
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

}
