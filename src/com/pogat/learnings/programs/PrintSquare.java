package com.pogat.learnings.programs;

import java.util.Scanner;

public class PrintSquare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int number = sc.nextInt();
		int arr[][] = PrintNumbers(number);
		// for (int[] arr1 : arr) {
		// System.out.println(Arrays.toString(arr1));
		// }
		int k = 0, m = number - 1, n = number;
		int l = 0;
		if (number % 2 == 0)
			m = number - 1;
		else
			m = number;

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[k][j]);
			}
			System.out.println(" ");
			// l = l + 2;
			// k = l;
		}
		k = number - 1;
		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[k][j]);

			}
			// m = m - 2;
			// k = m;
			System.out.println(" ");
		}
	}

	public static int[][] PrintNumbers(int n) {
		int arr[][] = new int[n][n];
		int k = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = k;
				k++;
			}
		}
		return arr;
	}
}
