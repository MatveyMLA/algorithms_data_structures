package com.matvey.graphs;

import static com.matvey.graphs.AdjcencyListGraph.getNumOfNodes;
import static com.matvey.graphs.AdjcencyListGraph.getSortedAdjcencyList;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BridgesSearch {
	private static final String filePath = "src\\main\\resources\\graph_nodes_bridges.txt";

	private static List<Boolean> visited = new ArrayList<Boolean>();
	private static List<Integer> timeIn = new ArrayList<Integer>();
	private static List<Integer> fUp = new ArrayList<Integer>();
	private static List<Bridge> bridges = new ArrayList<Bridge>();
	private static int timer = 0;
	
	public static void main(String[] args) {
		initialize();	
		int start = 1, parent =0;
		final var adjacencyList = getSortedAdjcencyList(filePath);
		
		bridgeSearch(adjacencyList, start, parent);
		
		System.out.println("Adjacency List of graph_nodes.txt Graph: " + adjacencyList);
		//Adjacency List of graph_nodes.txt Graph: [parent-[children]] => [0-[1, 2], 1-[0, 3], 2-[0, 3], 3-[1, 2, 4], 4-[3, 5, 6], 5-[4, 6, 7, 8], 6-[4, 5, 8], 7-[5], 8-[5, 6]]
		
		System.out.println("Bridges: " + bridges.size()+ " = " + bridges);
		//Bridges: 2 = [Bridge [from=5, to=7], Bridge [from=3, to=4]]
	}

	private static void bridgeSearch(ArrayList<List<Integer>> adjacencyList, int v, int parent) {
	
		visited.set(v, true);
		timeIn.set(v, timer);
		fUp.set(v, timer);
		timer++;
	
		for (int i = 0; i < adjacencyList.get(v).size(); i++) {
			int to = adjacencyList.get(v).get(i);
			if(to == parent) {
				continue;
			}
			if(visited.get(to)) {
				fUp.set(v, min(fUp.get(v), timeIn.get(to)));
			}
			else {
				bridgeSearch(adjacencyList, to, v);
				fUp.set(v, min(fUp.get(v), fUp.get(to)));
				if(fUp.get(to) > timeIn.get(v)) {
					bridges.add(new Bridge(v, to));
				}
			}
		}
	}

	private static void initialize() {
		final int numOfNodes = getNumOfNodes(filePath);
		for (int i = 0; i < numOfNodes; i++) {	
			visited.add(false);
			fUp.add(-1);
			timeIn.add(-1);
		}
	}
}
