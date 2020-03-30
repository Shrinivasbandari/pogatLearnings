package com.pogat.learnings.programs;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) throws java.lang.Exception {
		// Given input array
		int[] inputArray = { 3, 7, 9, 6, 4, 7 };
		// Print array before reverse
		System.out.println("Array without reverse" + Arrays.toString(inputArray));
		// Calling method to swap elements
		reverseArray(inputArray);
	}

	public static void reverseArray(int[] inputArray) {
		for (int left = 0, right = inputArray.length - 1; left < right; left++, right--) {
			// swap the values at the left and right indices
			int temp = inputArray[left];
			inputArray[left] = inputArray[right];
			inputArray[right] = temp;
		}
		// Printing the Array after reverse
		System.out.print("Reverse Array :");
		for (int val : inputArray)
			System.out.print(" " + val);
	}

}
