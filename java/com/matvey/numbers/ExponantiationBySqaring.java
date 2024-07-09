package com.matvey.numbers;

import java.util.Scanner;

public class ExponantiationBySqaring {

	public static void main(String[] args) {
		System.out.println("Enter integer number: ");
		int a = new Scanner(System.in).nextInt();
		
		System.out.println("Enter exponent: ");
		int exp = new Scanner(System.in).nextInt();
		
		int res = 1;
		
		while (exp>0) {
			
			if(exp%2 > 0) {
				res*=a;
				exp-=1;
			}
			else {
				a*=a;
				exp/=2;
			}
		}
		
		System.out.println(res);
		
	}

}
