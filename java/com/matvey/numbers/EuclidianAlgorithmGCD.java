package com.matvey.numbers;

public class EuclidianAlgorithmGCD {
	public static void main(String[] args) {
		System.out.println(gcd(8, 6)); // GCD - Grate Common Divider = GCD(a, a%b) for a>b
		System.out.println(lcm(8, 6)); // LCM - Less Common Multiplier = GCD(a,b)*LCM(a,b) = a*b => LCM(a,b) = (a*b) * GCD(a,b)
	}



	private static int gcd(int a, int b) {
		if(a<b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		while (b!=0) {
			a = a%b;
			if(a<b) {
				int temp = a;
				a = b;
				b = temp;
			}
		}
		return a;
	}
	
	private static int lcm(int a, int b) {
		int gcd = gcd(a,b);
		return (a*b) / gcd;
	}
}
