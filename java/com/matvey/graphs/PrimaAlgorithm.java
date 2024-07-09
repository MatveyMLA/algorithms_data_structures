package com.matvey.graphs;

import static com.matvey.graphs.AdjcencyListGraph.getNumOfNodes;

import java.util.ArrayList;

public class PrimaAlgorithm {

	private final static String graphNodesWeighted = "src\\main\\resources\\graph_nodes_weighted.txt";
	private final static int numOfNodes = getNumOfNodes(graphNodesWeighted);
	
	public static void main(String[] args) {

		var visited = new ArrayList<Boolean>();
		var parents = new ArrayList<Integer>();
		var distances = new ArrayList<Integer>();
		
		initialize(numOfNodes, visited, parents);
		initDistances(numOfNodes, distances);
		
		final var adjacencyList = AdjcencyListGraph.fromFileWeightedAdjacencyList();
		for (int i = 0; i < numOfNodes; i++) {
			int v =-1;
			
			for (int j = 0; j < numOfNodes; j++) {
				if ( visited.get(j)==false && (v == -1 || distances.get(j) < distances.get(v))) {
					v = j;	
				}
			}		
		
			visited.set(v, true);
			
			for (int j = 0; j < adjacencyList.get(v).size(); j++) {
				
				var graphPair = adjacencyList.get(v).get(j);
				
				int to = graphPair.getTo();
				int newDistance = graphPair.getWeight();				
				int currentDistanceTo = distances.get(to);
				
				if(newDistance < currentDistanceTo) {
					distances.set(to, newDistance);
					parents.set(to, v);
				}
			}
		
		}
		
		System.out.println("Weighted Adjacency List of Graph: " + adjacencyList);
		//Weighted Adjacency List of Graph: [Node-[to connected node, edge weight]] [0-[to=1, weight=4, to=2, weight=3], 1-[to=0, weight=4, to=3, weight=2], 2-[to=0, weight=3, to=6, weight=10], 3-[to=1, weight=2, to=4, weight=3, to=5, weight=14, to=6, weight=6, to=8, weight=5], 4-[to=3, weight=3, to=6, weight=1], 5-[to=3, weight=14, to=6, weight=2], 6-[to=2, weight=10, to=3, weight=6, to=4, weight=1, to=5, weight=2, to=7, weight=7], 7-[to=6, weight=7], 8-[to=3, weight=5]]
		
		System.out.println("distances: " + distances);  //distances: [0, 2, 3, 2, 1, 2, 1, 7, 5]
		System.out.println("parents: " + parents);		//parents:   [0, 3, 0, 1, 6, 6, 4, 6, 3]
	}

	private static void initialize(int numOfNodes, ArrayList<Boolean> visited, ArrayList<Integer> parents) {
		for (int i = 0; i < numOfNodes; i++) {
			parents.add(i);
			visited.add(false);
		}
	}

	private static void initDistances(int numOfNodes, ArrayList<Integer> distances) {
		distances.add(0);
		for (int i = 1; i < numOfNodes; i++) {
			distances.add(Integer.MAX_VALUE);
		}
	}
}
