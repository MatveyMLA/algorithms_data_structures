package com.matvey.sorting;

import java.util.Arrays;

public class BubleSort {
	public static void main(String[] args) {
		int[] arg = {66,8,3,14,2,1};
		
		for(int i = 0; i< arg.length; i++) {
			for(int j = 0; j < arg.length-i-1; j++) {
				if(arg[j] > arg[j+1]) {
					int temp = arg[j];
					arg[j] = arg[j+1];
					arg[j+1] = temp;
				}
			}
		}
		
		Arrays.stream(arg)
		.forEach(elem -> System.out.println(elem));
	}
}
