package com.matvey.geometry;

public class SegmentsIntersection {
	
	public static void main(String[] args) {
		var segA = new Segment(new Point(1,3), new Point(3,4));
		var segB = new Segment(new Point(5,5), new Point(7,6));
		
		if(isSegmentsIntersect(segA, segB)) {
			 System.out.println("The Segments Are Intersecting");
		} else {
			 System.out.println("The Segments Are Not Intersecting");
		}
	}
	
	private static boolean isSegmentsIntersect(Segment segA, Segment segB) {
		var pointA = segA.getA();
		var pointB = segA.getB();
		var pointC = segB.getA();
		var pointD = segB.getB();
		
		double crossAbBc = vectorsProduct(pointA, pointB, pointC);
		double crossAbBd = vectorsProduct(pointA, pointB, pointD);
		double crossCdDa = vectorsProduct(pointC, pointD, pointA);
		double crossCdDb = vectorsProduct(pointC, pointD, pointB);
		
		if(crossAbBc == 0 && crossAbBd == 0 
				&& crossCdDa == 0 && crossCdDb == 0) {
			return isProjectionsIntersect(segA, segB);
		}
		return crossAbBc * crossAbBd <= 0 && crossCdDa * crossCdDb <= 0;
	}
	
	private static double vectorsProduct(Point a, Point b, Point c) {
		
		// Vectors calculation: vector(X2-X1, Y2-Y1)
		
		double abX = b.getX() - a.getX();
		double abY = b.getY() - a.getY();
		
		double bcX = c.getX() - b.getX();
		double bcY = c.getY() - b.getY();
		
		
		return abX*bcY - bcX*abY;
	}
	
	private static boolean isProjectionsIntersect(Segment segA, Segment segB){
		
		double a = segA.getA().getY();
		double b = segA.getB().getY();
		
		double c = segB.getA().getY();
		double d = segB.getB().getY();
		
		if (a > b) {
			double temp = a;
			a = b;
			b = temp;
		}
		
		if (c > d) {
			double temp = c;
			c = d;
			d = temp;
		}
		
		return Math.max(a, c) <= Math.min(b, d);
	}
}
