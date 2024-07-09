package com.matvey.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFSearch {
	private final static String graphNodes = "src\\main\\resources\\graph_nodes.txt";
	
	public static void main(String[] args) {
		
		int top = 0;	
		final var adjacencyList = AdjcencyListGraph.getSortedAdjcencyList(graphNodes);	
		var BFSResult = bfs(adjacencyList, top);
		
		System.out.println("Adjacency List of Graph: " + adjacencyList);
		//Adjacency List of Graph [Node - [Connected Nodes]]: [0-[1, 2], 1-[0, 3], 2-[0, 6], 3-[1, 4, 5, 6, 8], 4-[3, 6], 5-[3, 6], 6-[2, 3, 4, 5, 7], 7-[6], 8-[3]]
		
		System.out.println("BFS Search Result: " + BFSResult); // BFS Search Result: [0, 1, 2, 3, 6, 4, 5, 8, 7]
	}

	private static ArrayList<Integer> bfs(ArrayList<List<Integer>> adjacencyList, int top) {
		var visited = new ArrayList<Integer>();
		visited.add(top);
		
		var q = new LinkedList<Integer>();
		q.addLast(top);
		
		while(q.isEmpty() == false) {
			top = q.pollFirst();
			for (int i = 0; i < adjacencyList.get(top).size(); i++) {
				int current = adjacencyList.get(top).get(i);
				if (visited.contains(current) == false) {
					visited.add(current);
					q.addLast(current);
				}
			}
		}
		return visited;
	}
}
