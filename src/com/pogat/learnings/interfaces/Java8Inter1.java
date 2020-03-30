package com.pogat.learnings.interfaces;

public class Java8Inter1 implements Java8Inter2, Java8Inter3 {

	public static void main(String[] args) {

		Java8Inter1 ji = new Java8Inter1();
		ji.a();
		Java8Inter2.a();

	}

}

interface Java8Inter2 {
	// if you make it default there is a compile time duplicate issue
	static void a() {
		System.out.println("Java8Inter2 a method");
	}
}

interface Java8Inter3 {
	default void a() {
		System.out.println("Java8Inter3 a method");
	}
}