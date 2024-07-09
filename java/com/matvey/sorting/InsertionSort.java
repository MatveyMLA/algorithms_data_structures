package com.matvey.sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arg = initArray();
		
		for(int j = 1; j < arg.length; j++) {
			int key = arg[j];
			int i = j-1;
			
			while(i > -1 && arg[i] > key) {
				arg[i+1] = arg[i];
				arg[i] = key;
				i--;
			}
		}
		
		printArray(arg);
	}
	
	private static void printArray(int[] originArr) {
		Arrays.stream(originArr)
		.forEach(elem -> System.out.println(elem));
	}

	private static int[] initArray() {
		var random = new Random();
		var originArr = new int[10];
			
		for (int i = 0; i < originArr.length; i++) {
			originArr[i] = random.nextInt(10);
		}
		return originArr;
	}

}
