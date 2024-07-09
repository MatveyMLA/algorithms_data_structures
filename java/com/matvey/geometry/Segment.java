package com.matvey.geometry;

public class Segment {
	private Point a;
	private Point b;
	
	public Segment(Point a, Point b) {
		this.a = a;
		this.b = b;
	}

	public Segment() {}

	public Point getA() {
		return a;
	}
	public void setA(Point a) {
		this.a = a;
	}
	public Point getB() {
		return b;
	}
	public void setB(Point b) {
		this.b = b;
	}
	
	
}
