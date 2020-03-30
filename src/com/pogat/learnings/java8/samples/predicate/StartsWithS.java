package com.pogat.learnings.java8.samples.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StartsWithS {

	public static void main(String[] args) {
		String[] names = { "Sri1231", "Rak", "Rav", "Bha", "Uma" };
		Predicate<String> p = s -> s.charAt(0) == 'S';
		for (String s : names) {
			if (p.test(s)) {
				System.out.println(s);
			}
		}
		test();

	}

	public static void test() {
		int[] values = { 1, 2, 3, 1, 2, 1, 1, 2, 1 };
		List<Integer> st = Arrays.stream(values).boxed().collect(Collectors.toList());
		st = st.stream().filter(i -> i == 1).collect(Collectors.toList());
		System.out.println(st.size());
	}

}
