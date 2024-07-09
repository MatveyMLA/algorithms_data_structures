package com.matvey.geometry;

import static java.util.Collections.addAll;

import java.util.ArrayList;
import java.util.List;

public class Polygon {

	public static void main(String[] args) {
		var points = new  ArrayList<Point>();
		addAll(points, new Point(1,2),
				new Point(3,9), 
				new Point(10,6), 
				new Point(7,3), 
				new Point(3,4));
		
		System.out.println("The Polygon Area is " + polygonArea(points) + " For Points: " + points);
		//The Polygon Area is 30.0 For Points: [P(x=1.0, y=2.0), P(x=3.0, y=9.0), P(x=10.0, y=6.0), P(x=7.0, y=3.0), P(x=3.0, y=4.0)]
	}
	private static double polygonArea(List<Point> points) {
		double result = 0;
		
		for (int i = 0; i < points.size(); i++) {
			var p1 = points.get(i);
			var p2 = new Point();
			if (points.size()-1 == i) {
				p2 = points.get(0);
			}
			else {
				p2 = points.get(i+1);
			}
			
			result+= (p1.getY() + p2.getY())*(p2.getX() - p1.getX());
		}
	
		return Math.abs(result) / 2;
	}
}
