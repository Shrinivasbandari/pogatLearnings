package com.pogat.learnings.conceptofday.core;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MapUtils {
	public static void main(String args[]) {
		String[] chars = { "Apple", "Banana", "Pineapple", "Apple", "Pineapple", "Apple" };
		// String[] chars1 = {"Srini","Ravi"};

		Map<String, Long> freq = Stream.of(chars)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(freq);

		String[] strArr = { "rakesh", "bhar", "bhavya", "bhar", "bhavya", "rakesh", "bhavya" };
		System.out.println(Arrays.stream(strArr).filter(s -> s.contains("b")).map(e -> "abc")
				.collect(Collectors.toList()).toString());
		Map<String, Integer> myMap = Arrays.stream(strArr).collect(Collectors.toMap(s -> s, s -> 1, (s, s1) -> s + s1));
		myMap.forEach((k, v) -> System.out.println(k + " " + v));

	}
}