package com.matvey.graphs;

public class Bridge {
	
	private int from;
	private int to;
	
	public Bridge(int from, int to) {
		this.to = to;
		this.from = from;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	@Override
	public String toString() {
		return "Bridge [from=" + from + ", to=" + to + "]";
	}	
}
