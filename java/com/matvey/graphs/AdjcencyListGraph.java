package com.matvey.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdjcencyListGraph {
	private final static String graphNodes = "src\\main\\resources\\graph_nodes.txt";
	private final static String graphNodesWeighted = "src\\main\\resources\\graph_nodes_weighted.txt";
			
	public static void main(String[] args) {
		
			final var adjcencyList = getSortedAdjcencyList(graphNodes);			
			final var adjcencyWeightList = fromFileWeightedAdjacencyList();
			
			System.out.println(adjcencyList); 
			System.out.println(adjcencyWeightList); 
			//Weighted Adjacency List of Graph: [[1, 4, 2, 3], [0, 4, 3, 2], [0, 3, 6, 10], [1, 2, 4, 3, 5, 14, 6, 6, 8, 5], [3, 3, 6, 1], [3, 14, 6, 2], [2, 10, 3, 6, 4, 1, 5, 2, 7, 7], [6, 7], [3, 5]]
			//Weighted Adjacency List of GraphWeightPair: [[to=1, weight=4, to=2, weight=3], [to=0, weight=4, to=3, weight=2], [to=0, weight=3, to=6, weight=10], [to=1, weight=2, to=4, weight=3, to=5, weight=14, to=6, weight=6, to=8, weight=5], [to=3, weight=3, to=6, weight=1], [to=3, weight=14, to=6, weight=2], [to=2, weight=10, to=3, weight=6, to=4, weight=1, to=5, weight=2, to=7, weight=7], [to=6, weight=7], [to=3, weight=5]]
		
	}
	
	public static ArrayList<List<Integer>> getSortedAdjcencyList(String filePath) {
		var adjcencyList = fromFileAdjacencyList(filePath);
		return sortAdjcencyList(adjcencyList);
	}

	private static ArrayList<List<Integer>> fromFileAdjacencyList(String filePath) {
		final var file = new File(filePath);
		Scanner fileReader = null;
		
		try {
			fileReader = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		var adjacencyList = new ArrayList<List<Integer>>();
		
		int numOfNodes = fileReader.nextInt();
		int numOfEdges = fileReader.nextInt();
		
		for(int i = 0; i < numOfNodes; i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
		
		while(fileReader.hasNext()) {
			int start = fileReader.nextInt();
			int end = fileReader.nextInt();
			
			adjacencyList.get(start).add(end);
			adjacencyList.get(end).add(start);
		}
		
		fileReader.close();
		return adjacencyList;
	}
	
	public static ArrayList<List<GraphWeightPair>> fromFileWeightedAdjacencyList() {
		final var file = new File(graphNodesWeighted);
		Scanner fileReader = null;
		 	
		try {
			fileReader = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		var adjacencyList = new ArrayList<List<GraphWeightPair>>();
		
		int numOfNodes = fileReader.nextInt();
		int numOfEdges = fileReader.nextInt();
		
		for(int i = 0; i < numOfNodes; i++) {
			adjacencyList.add(new ArrayList<GraphWeightPair>());
		}
		
		while(fileReader.hasNext()) {
			int start = fileReader.nextInt();
			int end = fileReader.nextInt();
			int weight = fileReader.nextInt();
			

			adjacencyList.get(start).add(new GraphWeightPair(end, weight));
		}
		fileReader.close();	
		
		return adjacencyList;
	}

	public static ArrayList<List<Integer>> fromKeyBoardAdjcencyList() {
		System.out.println("Enter Num Of nodes");
		int numOfNodes = new Scanner(System.in).nextInt();
		System.out.println("Enter Num Of Edges");
		int numOfEdges = new Scanner(System.in).nextInt();
		var adjcencyList = new ArrayList<List<Integer>>();
		for(int i = 0; i < numOfNodes; i++) {
			adjcencyList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < numOfEdges; i++) {
			System.out.println("Enter Start Of The Edge");
			int start = new Scanner(System.in).nextInt();
			System.out.println("Enter End Of The Edge");
			int end = new Scanner(System.in).nextInt();
			
			adjcencyList.get(start).add(end);
			adjcencyList.get(end).add(start);
		}
		return adjcencyList;
	}

	public static ArrayList<List<Integer>> sortAdjcencyList(ArrayList<List<Integer>> adjcencyList) {
		for (List<Integer> list : adjcencyList) {
			var temp = list.stream()
					.sorted()
					.collect(Collectors.toList());
			list.clear();
			list.addAll(temp);
		}
		return adjcencyList;
	}
	
	public static int getNumOfNodes(String filePath) {
		var file = new File(filePath);
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int numOfNodes = fileReader.nextInt();
		return numOfNodes;
	}
}
