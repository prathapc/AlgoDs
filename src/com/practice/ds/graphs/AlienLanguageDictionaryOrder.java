package com.practice.ds.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class AlienLanguageDictionaryOrder {

	public static void main(String[] args) {
		String str[] = {"baa", "abcd", "abca", "cab", "cad"};
		//String str[] = {"cb", "bc", "bb"};
		//String str[] = {"caa", "aaa", "aab"};
		Graph graph = new Graph(4);
		for(int i=0; i<str.length-1; i++) {
			constructGraph(str[i], str[i+1], graph);
		}
		topologicalSort(graph);
	}

	private static void constructGraph(String string1, String string2, Graph graph) {
		int i = 0;
		int j = 0;
		while(i<= string1.length() && j < string2.length()) {
			if(string1.charAt(i) != string2.charAt(j)) {
				graph.addEdge(string1.charAt(i), string2.charAt(j));
				break;
			}
			i++; j++;
		}
	}
	
	private static void topologicalSort(Graph graph) {
		Stack<Character> sortedCharacters = new Stack<>();
		boolean[] visited = new boolean[4];
		for(int i=0; i<4; i++) {
			if(!!visited[i]) {
				topologicalSortUtil(i, visited, sortedCharacters, graph);
			}
		}
		while(!sortedCharacters.isEmpty()) {
			System.out.println(sortedCharacters.pop() + " ");
		}
	}

	private static void topologicalSortUtil(int i, boolean[] visited, Stack<Character> sortedCharacters, Graph graph) {
		int offset = (int)'a';
		Iterator<Character> iterator = graph.adj[i].iterator();
		visited[i] = true;
		int ch;
		while (iterator.hasNext()) {
			ch = iterator.next()-offset;

			if(!visited[ch]) {
				topologicalSortUtil(ch, visited, sortedCharacters, graph);
			}
		}
		sortedCharacters.push((char) (offset+i));
	}

	static class Graph {
		int v;
		LinkedList<Character> adj[];

		Graph(int v) {
			this.v = v;
			adj = new LinkedList[v];
			for(int i=0; i<v; i++) {
				adj[i] = new LinkedList<>();
			}
		}

		public void addEdge(char v, char w) {
			int offset = (int)'a';
			adj[v-offset].add(w);
		}
	}
}
