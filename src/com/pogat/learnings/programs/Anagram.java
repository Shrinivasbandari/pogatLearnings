package com.pogat.learnings.programs;

import java.util.function.Predicate;

public class Anagram {

	public static void main(String[] args) {
		Predicate<Integer> p = i -> i > 5;
		System.out.println(p.test(10));

	}

}
