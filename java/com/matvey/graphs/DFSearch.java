package com.matvey.graphs;

import static com.matvey.graphs.AdjcencyListGraph.getSortedAdjcencyList;

import java.util.ArrayList;
import java.util.List;

public class DFSearch {

	private final static String graphNodes = "src\\main\\resources\\graph_nodes.txt";
	
	public static void main(String[] args) {
		
		final var adjacencyList = getSortedAdjcencyList(graphNodes);	
		var visitedDFS = new ArrayList<Integer>();
		dfs(adjacencyList, visitedDFS, 0);
		
		System.out.println("Adjacency List of Graph: " + adjacencyList);
		//Adjacency List of Graph [Node - [Connected Nodes]]: [0-[1, 2], 1-[0, 3], 2-[0, 6], 3-[1, 4, 5, 6, 8], 4-[3, 6], 5-[3, 6], 6-[2, 3, 4, 5, 7], 7-[6], 8-[3]]
		
		System.out.println("Visited Nodes of graph_nodes.txt by DFS: " + visitedDFS); 
		//Visited Nodes of graph_nodes.txt by DFS: [0, 1, 3, 4, 6, 2, 5, 7, 8]
	}

	public static void dfs(ArrayList<List<Integer>> adjacencyList, ArrayList<Integer> visited, int v) {
		
		visited.add(v);
		for(int i = 0; i < adjacencyList.get(v).size(); i++) {
			int current = adjacencyList.get(v).get(i);
			if(visited.contains(current) == false) {
				dfs(adjacencyList, visited, current);
			}
		}
	}

}
