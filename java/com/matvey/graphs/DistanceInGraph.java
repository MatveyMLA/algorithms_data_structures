package com.matvey.graphs;

import static com.matvey.graphs.AdjcencyListGraph.getNumOfNodes;

import java.util.ArrayList;
import java.util.LinkedList;

public class DistanceInGraph {

	private final static String graphNodes = "src\\main\\resources\\graph_nodes.txt";
	private final static int numOfNodes = getNumOfNodes(graphNodes);
	
	public static void main(String[] args) {
		
		final var adjacencyList = AdjcencyListGraph.getSortedAdjcencyList(graphNodes);
		var parents = new ArrayList<Integer>();
		var distances = new ArrayList<Integer>();
		for (int i = 0; i < numOfNodes; i++) {
			parents.add(i);
			distances.add(0);
		}
		
		var visited = new ArrayList<Integer>();
		var helper = new LinkedList<Integer>();
		int start = 0;
		visited.add(start);
		helper.addLast(start);
		
		while(helper.isEmpty() == false) {
			start = helper.pollFirst();
			for (int i = 0; i < adjacencyList.get(start).size(); i++) {
				int current = adjacencyList.get(start).get(i);
				if (visited.contains(current) == false) {
					int distance = distances.get(start);
					distances.set(current, distance+1);
					parents.set(current, start);
					visited.add(current);
					helper.addLast(current);
				}
			}
		}
		
		//Adjacency List of Graph [Node - [Connected Nodes]]: [0-[1, 2], 1-[0, 3], 2-[0, 6], 3-[1, 4, 5, 6, 8], 4-[3, 6], 5-[3, 6], 6-[2, 3, 4, 5, 7], 7-[6], 8-[3]]
		System.out.println("Adjacency List of Graph: " + adjacencyList);
		
		System.out.println("Parents: " + parents);   // For start=0:  Parents:   [0, 0, 0, 1, 3, 3, 2, 6, 3]				
		System.out.println("Distances: " + distances);// 			  Distances: [0, 1, 1, 2, 3, 3, 2, 3, 3]
	}

}
