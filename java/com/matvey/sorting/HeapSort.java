package com.matvey.sorting;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
	
	public static void main(String[] args) {
		var originArr = initArray();
		
		heapSort(originArr);
		
		printArray(originArr);
		
	}

	private static void heapSort(int[] originArr) {
		buildMaxHeap(originArr);
		for (int i =  originArr.length-1; i >= 0; i--) {
			swap(originArr, 0, i);
			heapify(originArr, i, 0);
		}
	}

	private static void buildMaxHeap(int[] originArr) {
		int originalLength = originArr.length;
		for (int i = originalLength/2-1; i >= 0 ; i--) {
			heapify(originArr, originalLength, i);
		}
	}

	private static void heapify(int[] originArr, int sizeOfHeap, int parentIndex) {
		
		int maxValueIndex = parentIndex;
		int leftChildIndex = parentIndex*2+1;
		int rightChildIndex = parentIndex*2+2;
		
		
		if(leftChildIndex < sizeOfHeap &&
				originArr[leftChildIndex] > originArr[parentIndex]) {
			
			maxValueIndex = leftChildIndex;
		}
		else {
			
			maxValueIndex = parentIndex;
		}
		
		if(rightChildIndex < sizeOfHeap && 
				originArr[rightChildIndex] > originArr[maxValueIndex]) {
			
			maxValueIndex = rightChildIndex;
		}
		
		if(maxValueIndex != parentIndex) {
			
			swap(originArr, maxValueIndex, parentIndex);
			heapify(originArr, sizeOfHeap, maxValueIndex);
		}
	}
	
	private static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
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
