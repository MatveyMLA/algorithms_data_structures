package com.matvey.numbers;

import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		System.out.println("Enter integer number: ");
		int num = new Scanner(System.in).nextInt();
		var sieve = new boolean[num];
		int sqareRoot = (int)Math.sqrt(num);
		
		for (int i = 0; i < sieve.length; i++) {
			sieve[i] = true;
		}
		
		for (int i = 2; i < sqareRoot; i++) {
			
			if (sieve[i]) {
				int j = i*i;
				while (j < num) {
					sieve[j] = false;
					j = j+i;					
				}
			}
		}
		
		System.out.println("All Prime Numbers till " + num);
		for (int i = 2; i < sieve.length; i++) {
			if(sieve[i]) {
				System.out.println(i);
			}
		}
		
	}

}
