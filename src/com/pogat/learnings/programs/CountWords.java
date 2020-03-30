package com.pogat.learnings.programs;

import java.util.HashMap;
import java.util.Map;

public class CountWords {

	public static void main(String[] args) {

		String str = "I am Srinivas am doing java programs to learn java";
		String[] arr = str.split(" ");
		Map<String, Integer> map = new HashMap();
		Integer count = 1;

		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], count);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		for (String x : map.keySet()) {
			System.out.println("count of word : " + x + "=  " + map.get(x) + " time");
		}

	}

}
