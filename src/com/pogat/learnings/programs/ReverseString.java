package com.pogat.learnings.programs;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a string : ");
		String str = scan.nextLine();
		reverse1(str);
		reverse2(str);
	}

	// one
	private static void reverse1(String str) {
		String tempStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			tempStr = tempStr + str.charAt(i);
		}
		System.out.println("1) ReverseString: " + tempStr);

	}

	private static void reverse2(String str) {
		System.out.println("2) RecursiveReverseString:" + recursiveReverserecursiveReverse(str));
	}

	private static String recursiveReverserecursiveReverse(String str) {
		if (str.length() == 0)
			return " ";
		return str.charAt(str.length() - 1) + recursiveReverserecursiveReverse(str.substring(0, str.length() - 1));
	}
}
