package com.practice.ds.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_DistFromCapitalCity {

	public static void main(String[] args) {
		int a[] = {9,1,4,9,0,4,8,9,0,1};
		int res[] = solution(a);
		for(int i=0; i<res.length; i++) {
			System.out.print(res[i]+" ");
		}
	}

	public static int[] solution(int[] T) {
		int n = T.length;
		int result[] = new int[n-1];
		
		int capital = -1;
		Node node;
		Node adjNode;
		Map<Integer,Node> map=new HashMap<>(); 
		for(int k=0; k<n; k++) {
			if(!map.containsKey(T[k])){
				node = new Node();
				node.d = T[k];
				map.put(T[k], node);
			}else{
				node=map.get(T[k]);
			}
			if(!map.containsKey(k)){
				adjNode = new Node();
				adjNode.d = k;
				map.put(k, adjNode);
			}else{
				adjNode=map.get(k);
			}
			
			node.adj.add(adjNode);
			
			if(k==T[k]) {
				capital = k;
			}
		}
		
		Node capitalNode = map.get(capital);
		capitalNode.adj.remove(capitalNode);
		List<Node> listOfLevelNodes = capitalNode.adj;
		result[0] = listOfLevelNodes.size();
		int resCount = 1;
		while (listOfLevelNodes.size()>0) {
			listOfLevelNodes=getCitiesCountOfTheLevel(listOfLevelNodes);
			 result[resCount++] = listOfLevelNodes.size();
		}
		return result;
	}
	
	public static List<Node>  getCitiesCountOfTheLevel(List<Node> listOfLevelNodes){
		List<Node> node= new ArrayList<Node>();
		for(Node levelNode : listOfLevelNodes) {
			node.addAll(levelNode.adj);
		}
		return node;
	}

	static class Node {
		int d;
		List<Node> adj= new ArrayList<Node>();

	}
}
