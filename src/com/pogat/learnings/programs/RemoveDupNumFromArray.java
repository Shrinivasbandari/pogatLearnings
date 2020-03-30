package com.pogat.learnings.programs;

public class RemoveDupNumFromArray {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 3, 2, 1 };
		for (int i = 0; i < a.length; i++) {
			System.out.println("a.length " + "i= " + i + ": " + a.length + "a[i]= " + a[i]);
			for (int j = i + 1; j < a.length; j++) {
				System.out.println("a.length " + "j= " + j + ": " + a.length + "a[j]= " + a[j]);
				if (a[i] == a[j]) {

					System.out.println("a[i] 1:" + a[i]);
					a[i] = -1;
					System.out.println("a[i] 2:" + a[i]);
				}
			}

		}
		System.out.println("----" + a.length);
		for (int k = 0; k < a.length; k++) {
			if (a[k] != -1) {
				System.out.println(a[k]);
			}
		}
	}

}
