package com.pogat.learnings.infy;

class Outer {
	void m1() {
		System.out.println("m1");
	}

	static class Inner {
		void method() {
			System.out.println("method called");
		}
	}
}
