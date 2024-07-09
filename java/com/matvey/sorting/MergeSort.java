package com.matvey.sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	public static void main(String[] args) {
		var originArr = initArray();
	
		mergeSort(originArr);
		
		printArray(originArr);
		
	}

	private static void mergeSort(int[] originArr) {
		
		if(originArr.length < 2) return;
		
		int originalLength = originArr.length;
		int midIndex = originArr.length/2;
		
		var leftArr = new int[midIndex];
		var rightArr = new int[originalLength-midIndex];
		
		for (int i = 0; i < midIndex; i++) {
			leftArr[i] = originArr[i];
		}
		
		for (int i = midIndex; i < originalLength; i++) {
			rightArr[i-midIndex] = originArr[i];			
		}
		
		mergeSort(leftArr);
		mergeSort(rightArr);
		
		merge(originArr, leftArr, rightArr);
	}

	private static void merge(int[] originArr, int[] leftArr, int[] rightArr) {
		int i = 0,  j = 0, k = 0;
		int leftSize =leftArr.length;
		int rightSize =rightArr.length;
		
		while (i < leftSize && j < rightSize) {
			if(leftArr[i] <= rightArr[j] ) {
				originArr[k] = leftArr[i];
				i++;
			}
			else {
				originArr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while(i<leftSize) {
			originArr[k] = leftArr[i];
			i++;
			k++;
		}
		while(j<rightSize) {
			originArr[k] = rightArr[j];
			j++;
			k++;
		}
	}
	
	private static void printArray(int[] originArr) {
		Arrays.stream(originArr)
		.forEach(elem -> System.out.println(elem));
	}

	private static int[] initArray() {
		var random = new Random();
		var originArr = new int[10];
			
		for (int i = 0; i < originArr.length; i++) {
			originArr[i] = random.nextInt(1000);
		}
		return originArr;
	}
}
