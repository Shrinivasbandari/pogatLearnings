package com.pogat.learnings.oldsamples;

@FunctionalInterface
public interface I1 {
	void m2();

	default void m1() {
		System.out.println("in I1");
	}

}
