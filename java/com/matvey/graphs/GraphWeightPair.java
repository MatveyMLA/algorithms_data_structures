package com.matvey.graphs;

public class GraphWeightPair {
	private int to;
	private int weight;

	public GraphWeightPair(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
	
	public GraphWeightPair() {
	}
	
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "to=" + to + ", weight=" + weight;
	}
}
