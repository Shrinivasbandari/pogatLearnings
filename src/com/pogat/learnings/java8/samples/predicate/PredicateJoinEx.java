package com.pogat.learnings.java8.samples.predicate;

import java.util.function.Predicate;

public class PredicateJoinEx {

	public static void main(String[] args) {
		int[] x = { 0, 5, 10, 15, 20, 25, 30, 35, 40 };
		Predicate<Integer> p1 = i -> i > 25;
		Predicate<Integer> p2 = i -> i % 2 == 0;
		System.out.println("The numbers greaterthan 25 are ");
		m1(p1, x);

		System.out.println("The even numbers are ");
		m1(p2, x);

		System.out.println("The numbers not greaterthan 25 are ");
		m1(p1.negate(), x);

		System.out.println("The numbers greaterthan 25 and even are ");
		m1(p1.and(p2), x);

		System.out.println("The numbers greaterthan 25 Or even are ");
		m1(p1.or(p2), x);

	}

	static void m1(Predicate<Integer> p, int[] x) {
		for (int x1 : x) {
			if (p.test(x1))
				System.out.println(x1);
		}
	}

}
