package com.matvey.numbers;

import java.util.ArrayList;
import java.util.Scanner;

public class Divisors {
	public static void main(String[] args) {
		
		System.out.println("Enter integer number: ");
		int num = new Scanner(System.in).nextInt();
		
		int sqareRoot = (int)Math.sqrt(num);
		var result = new ArrayList<Integer>();
		
		for (int i = 1; i <= sqareRoot; i++) {
			
			if(num % i == 0) {
				result.add(i);
				result.add(num/i);
			}
		}
		
		if(result.size() == 2) {
			System.out.println(num + " is the Prime number!");
		}
		System.out.println("Divisors: ");
		result.stream()
		.distinct()
		.sorted()
		.forEach(div -> System.out.println(div));
		
	}
}
