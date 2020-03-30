package com.pogat.learnings.infy;

public class AutoPromotionEx {

	void m1(String x) {
		System.out.println("in int");
	}

	void m1(StringBuffer c) {
		System.out.println("in char");

	}

	public static void main(String[] args) {
		AutoPromotionEx ae = new AutoPromotionEx();
		// ae.m1(null);
	}

}
