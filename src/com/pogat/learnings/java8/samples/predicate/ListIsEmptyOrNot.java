package com.pogat.learnings.java8.samples.predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class ListIsEmptyOrNot {

	public static void main(String[] args) {
		Predicate<Collection> p = c -> c.isEmpty();
		ArrayList al = new ArrayList<>();
		al.add("A");

		System.out.println(p.test(al));
		ArrayList al1 = new ArrayList<>();
		System.out.println(p.test(al1));

	}
}
