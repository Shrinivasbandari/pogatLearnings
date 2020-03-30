package com.pogat.learnings.java8.samples.predicate;

import java.util.function.Predicate;

public class PredicateEx1 {

	public static void main(String[] args) {
		Predicate<Integer> p = I -> I > 5;
		System.out.println(p.test(10));

	}
}
