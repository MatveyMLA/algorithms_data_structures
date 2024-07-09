package com.matvey.graphs;

import static com.matvey.graphs.AdjcencyListGraph.getNumOfNodes;
import static com.matvey.graphs.AdjcencyListGraph.getSortedAdjcencyList;
import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPointsSearch {
	private static final String graphNodesBridges = "src\\main\\resources\\graph_nodes_bridges.txt";

	private static List<Boolean> visited = new ArrayList<Boolean>();
	private static List<Integer> timeIn = new ArrayList<Integer>();
	private static List<Integer> fUp = new ArrayList<Integer>();
	private static int timer = 0;
	private static int childrens = 0;
	
private static List<Integer> articulationPoints = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		initialize();		
		int start = 0, parent = -1;
		final var adjacencyList = getSortedAdjcencyList(graphNodesBridges);
		articulationPointsSearch(adjacencyList, start, parent);
		
		System.out.println("Adjacency List of graph_nodes.txt Graph: " + adjacencyList);
		//Adjacency List of graph_nodes.txt Graph: [parent-[children]] => [0-[1, 2], 1-[0, 3], 2-[0, 3], 3-[1, 2, 4], 4-[3, 5, 6], 5-[4, 6, 7, 8], 6-[4, 5, 8], 7-[5], 8-[5, 6]]
		System.out.println("articulationPoint: " + articulationPoints.size()+ " = " + articulationPoints);
	}
	
	private static void articulationPointsSearch(List<List<Integer>> adjacencyList, int v, int parent) {
		visited.set(v, true);
		timeIn.set(v, timer);
		fUp.set(v, timer);
		timer++;
		childrens ++;
		
		for (int i = 0; i < adjacencyList.get(v).size(); i++) {
			int to = adjacencyList.get(v).get(i);
			if(to == parent) {
				continue;
			}
			if(visited.get(to)) {
				fUp.set(v, min(fUp.get(v), timeIn.get(to)));
			}
			else {
				articulationPointsSearch(adjacencyList, to, v);
				fUp.set(v, min(fUp.get(v), fUp.get(to)));
				if((fUp.get(to) >= timeIn.get(v)) && parent != -1) {
					articulationPoints.add(v);
				}
			}
		}
		if(parent == -1 && childrens >= 2) {
			articulationPoints.add(v);
		}	
	}

	private static void initialize() {
		final int numOfNodes = getNumOfNodes(graphNodesBridges);
		for (int i = 0; i < numOfNodes; i++) {	
			visited.add(false);
			fUp.add(-1);
			timeIn.add(-1);
		}
	}

}
