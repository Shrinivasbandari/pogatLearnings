package com.pogat.learnings.java8.samples.predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class RemoveNull {

	public static void main(String[] args) {
		String[] names = { "Sri", "Rak", "Rav", "", "Bha", null, "Uma" };
		Predicate<String> p = s -> s != null && s.length() != 0;
		ArrayList al = new ArrayList<>();
		for (String str : names) {
			if (p.test(str)) {
				al.add(str);
			}

		}
		System.out.println(al);

	}

}
