package com.pogat.learnings.oldsamples;

public class IntegerValueTest {
	public static void main(String[] args) {
		System.out.println("Test");

		int i = 999999999; // 9 digits
		int r = 1234567891; // 10 digits
		Integer wi = 999999999;
		long j = 999999999L;
		long k = i * wi;
		System.out.println("i: " + i + "   wi: " + wi + " provideing wrong muliplication(i * wi): " + (i * wi)
				+ "    wi * wi: " + (wi * wi));
		System.out.println("i: " + i + "   wi: " + wi + "   concatinating i+wi: " + i + wi);
		System.out.println("j value: " + j + "   --provideing correct muliplication using Long j * j: " + (j * j)
				+ " --  provideing wrong muliplication (integers into long) k: " + k);

	}
}
