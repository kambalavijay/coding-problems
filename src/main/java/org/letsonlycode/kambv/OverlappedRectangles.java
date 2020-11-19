package org.letsonlycode.kambv;

import java.util.Scanner;

public class OverlappedRectangles {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Rectangle r1 = new Rectangle(new Coordinates(scan.nextInt(), scan.nextInt()), new Coordinates(scan.nextInt(), scan.nextInt()));
		Rectangle r2 = new Rectangle(new Coordinates(scan.nextInt(), scan.nextInt()), new Coordinates(scan.nextInt(), scan.nextInt()));
		
		int t = calculateOverlappedArea(r1, r2);
		
		System.out.println(t);
	}
	
	private static int calculateOverlappedArea(Rectangle r1, Rectangle r2) {
		// TODO Auto-generated method stub
		int xDist = distance(r1.topRight.x, r2.topRight.x, r1.bottomLeft.x, r2.bottomLeft.x);
		int yDist = 0;
		
		if(xDist <= 0) 
			return 0;
		else
			yDist = distance(r1.topRight.y, r2.topRight.y, r1.bottomLeft.y, r2.bottomLeft.y);
		if(yDist <= 0)
			return 0;
		else
			return xDist * yDist;
	}
	
	private static int distance(int p1, int p2, int p3, int p4 /*Rectangle r1, Rectangle r2*/) {
		// TODO Auto-generated method stub
		return Math.min(p1, p2) - Math.max(p3, p4);
	}
}


class Rectangle{
	
	Coordinates bottomLeft;
	Coordinates topRight;
	
	public Rectangle(Coordinates bottomLeft, Coordinates topRight) {
		// TODO Auto-generated constructor stub
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}
}

class Coordinates{
	int x;
	int y;
	
	public Coordinates(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}