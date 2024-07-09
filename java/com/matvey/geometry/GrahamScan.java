package com.matvey.geometry;

import static java.util.Collections.addAll;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GrahamScan {

	public static void main(String[] args) {

		var points = new  ArrayList<Point>();
		addAll(points, new Point(3,4),
				new Point(3,9), 
				new Point(10,6), 
				new Point(7,3), 
				new Point(1,2),
				new Point(6,4),
				new Point(3,5), 
				new Point(5,6), 
				new Point(4,3),
				new Point(4,7));
		
		var pointO = getTheSmallestPoint(points);
		points.remove(pointO);

		points.sort(getComporator(pointO));
		
		points.add(0, pointO);
		
		System.out.println(points);
		System.err.println(grahamScan(points)); 
	}

	private static List<Point> grahamScan(ArrayList<Point> points) {
		var results = new LinkedList<Point>();
		
		if(points.size() > 2) {

			Point nextToTop = points.get(1);
			Point top = points.get(2);
			
			results.addLast(points.get(0));
			results.addLast(nextToTop);
			results.addLast(top);
			
			for (int i = 3; i < points.size(); i++) {
				while (crossProduct(nextToTop, top, points.get(i)) <= 0) {
					results.pollLast();
					int nextToTopInd = results.size()-2;
					int topInd = results.size()-1;
					top = results.get(topInd);
					nextToTop = results.get(nextToTopInd);		
				}
				results.addLast(points.get(i));
			}
		}
		return results;
	}

	private static Point getTheSmallestPoint(ArrayList<Point> points) {
		var result = points.get(0);
		for(Point point: points) {
			if(result.getY() == point.getY() && result.getX() > point.getX()) {
				result = point;				
			}
			else if (result.getY() > point.getY()) {
				result = point;	
			}
		}	
		return result;
	}
	
	private static double crossProduct(Point a, Point b, Point o) {
		
		double abX = b.getX() - a.getX();
		double abY = b.getY() - a.getY();
		
		double boX = o.getX() - b.getX();
		double boY = o.getY() - b.getY();
		
		return abX*boY - boX*abY;
	}
	
	private static Comparator<Point> getComporator(Point pointO){
		
		return new Comparator<Point>() {
			
			@Override
			public int compare(Point pointA, Point pointB) {
				int res = -1;
				double prod = crossProduct(pointO, pointA, pointB);
				if(prod == 0) {
					if(dstance(pointO, pointA) < dstance(pointO, pointA)) {
						res = 1;					
					}	
				}
				else if(prod > 0) {
					res = 1;
				}
				return res;
			}
			
			private double dstance(Point a, Point b) {
				double abX = b.getX() - a.getX();
				double abY = b.getY() - a.getY();
				
				abX = Math.pow(abX, 2);
				abY = Math.pow(abY, 2);
				
				return Math.sqrt(abX+abY);				
			}
		};
		
	};
}
