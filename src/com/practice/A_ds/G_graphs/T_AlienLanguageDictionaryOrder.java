package com.practice.A_ds.G_graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/alien-dictionary/
 * #alienDictionary #topologySort
 *
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 */
public class T_AlienLanguageDictionaryOrder {

	//https://en.wikipedia.org/wiki/Topological_sorting#Kahn's_algorithm
	public static void main(String[] args) {
		System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
	}

	private static Map<Character, List<Character>> reverseAdjList = new HashMap<>();
	private static Map<Character, Boolean> seen = new HashMap<>();
	private static StringBuilder output = new StringBuilder();

	public static String alienOrder(String[] words) {

		// Step 0: Put all unique letters into reverseAdjList as keys.
		for (String word : words) {
			for (char c : word.toCharArray()) {
				reverseAdjList.putIfAbsent(c, new ArrayList<>());
			}
		}

		// Step 1: Find all edges and add reverse edges to reverseAdjList.
		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			// Check that word2 is not a prefix of word1.
			if (word1.length() > word2.length() && word1.startsWith(word2)) {
				return "";
			}
			// Find the first non match and insert the corresponding relation.
			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
					break;
				}
			}
		}

		// Step 2: DFS to build up the output list.
		for (Character c : reverseAdjList.keySet()) {
			boolean result = dfs(c);
			if (!result) return "";
		}


		if (output.length() < reverseAdjList.size()) {
			return "";
		}
		return output.toString();
	}

	// Return true iff no cycles detected.
	private static boolean dfs(Character c) {
		if (seen.containsKey(c)) {
			return seen.get(c); // If this node was grey (false), a cycle was detected.
		}
		seen.put(c, false); //if you dont do this or mark as true here only, wrong result for ["z","x","z"] which is "zx" actual is ""
		for (Character next : reverseAdjList.get(c)) {
			boolean result = dfs(next);
			if (!result) return false;
		}
		seen.put(c, true);
		output.append(c);
		return true;
	}

	//Time complexity : O(C).
	//Building the adjacency list has a time complexity of O(C) for the same reason as in Approach 1.
	//Again, like in Approach 1, we traverse every "edge", but this time we're using depth-first-search.
}
