package com.pogat.learnings.oldsamples;

public class C implements I1, I2 {

	public void m1() {
		System.out.println("in C");
		I1.super.m1();
	}

	public static void main(String[] args) {
		C c = new C();
		c.m1();
	}

	@Override
	public void m2() {
		String[] s = new String[10];
		s[1] = "";
		Object[] obj = new Object[10];

	}
	/*
	 * public static void a() { System.out.
	 * println("we can't overload static method with only one difference like static  keyword 1"
	 * ); }
	 * 
	 * public void a() { System.out.println("static method overloading 1"); }
	 */

}
