package com.matvey.graphs;

import static com.matvey.graphs.AdjcencyListGraph.getNumOfNodes;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
	private final static String graphNodes = "src\\main\\resources\\graph_nodes.txt";
	private final static int numOfNodes = getNumOfNodes(graphNodes);
	
	public static void main(String[] args) {
		
		final var adjacencyList = getSplitedGraph();
		var visited = new ArrayList<Integer>();
		int components =0;	
		
		for (int i = 0; i < numOfNodes; i++) {
			if(visited.contains(i) == false) {
				components++;
				DFSearch.dfs(adjacencyList, visited, i);
			}
		}
		
		System.out.println("A splitted adjacency List of Graph: " + adjacencyList); // A splitted adjacency List of Graph: [[1, 2], [0], [0], [1, 4, 5, 6], [3, 6], [3, 6], [2, 3, 4, 5, 7], [6], [3]]
		System.out.println("The raph contains " + components + " components"); // The graph contains 3 components, or 3 sub graphs
	}

	private static ArrayList<List<Integer>> getSplitedGraph() {	
		final var adjacencyList = AdjcencyListGraph.getSortedAdjcencyList(graphNodes);
		
		//Splitting for components:
		adjacencyList.get(1).remove(1);//remove connection between Node 1 and node 3 in the graph. Changed Adjacency List: [Node - [Connected Nodes]] [ 0 - [1, 2], 1 -[0, *3*],  2- [0, 6], [1, 4, 5, 6, 8], [3, 6], [3, 6], [2, 3, 4, 5, 7], [6], [3]]
		adjacencyList.get(2).remove(1);//remove connection between Node 2 and node 6 in the graph. Changed Adjacency List: [Node - [Connected Nodes]] [ 0 - [1, 2], 1 -[0],  2- [0, *6*], [1, 4, 5, 6, 8], [3, 6], [3, 6], [2, 3, 4, 5, 7], [6], [3]]
		adjacencyList.get(3).remove(4);//remove connection between Node 3 and node 8 in the graph. Changed Adjacency List: [Node - [Connected Nodes]] [ 0 - [1, 2], 1 -[0],  2- [0], 3-[1, 4, 5, 6, *8*], 4-[3, 6], 5-[3, 6], 6-[2, 3, 4, 5, 7], 7-[6], 8-[3]]
		return adjacencyList;
	}

}
