package com.pogat.learnings.oldsamples;

@FunctionalInterface
public interface I2 {
	default void m1() {
		System.out.println("in I2");
	}

	void m2();
}
