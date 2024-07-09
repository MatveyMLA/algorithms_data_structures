package com.matvey.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] arg = initArray();
		
		quickSort(arg, 0, arg.length - 1);
		
		printArray(arg);
	}
	
	private static void quickSort(int[] arr, int start, int end) {
		
		if(start >= end) return;
		
		int pivot = pivot(arr, start, end); 
		
		int leftPointer = hoarePartition(arr, start, end, pivot); 
			
		quickSort(arr, start, leftPointer - 1);
		quickSort(arr, leftPointer +1, end);
	
	}

	private static int pivot(int[] arr, int start, int end) {
		int pivotIndex = new Random().nextInt(end - start) + start;
		int pivot = arr[pivotIndex];
		swap(arr, pivotIndex, end);
		return pivot;
	}

	private static int hoarePartition(int[] arr, int start, int end, int pivot) {
		int leftPointer = start;
		int rightPointer = end;
		
		while (leftPointer<rightPointer) {
			while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}
			while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			swap(arr, leftPointer, rightPointer); 
		}
		swap(arr, leftPointer, end);
		return leftPointer;
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
