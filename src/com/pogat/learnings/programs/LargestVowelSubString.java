package com.pogat.learnings.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LargestVowelSubString {

	public static void main(String[] args) {
		determineNumberOfSubstring("threatreaiutoutsae");
	}

	public static void determineNumberOfSubstring(String str) {
		List<String> s = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {

			if (isVowel(str.charAt(i))) {
				flag = true;
				if (flag) {
					sb.append(str.charAt(i));
				}
			} else {
				if (sb.length() > 0) {
					s.add(sb.toString());
				}
				sb = new StringBuilder();
				System.out.println("terminated subString at index: " + i + "char at: " + str.charAt(i));
				flag = false;
			}

		}
		System.out.println("list: " + s);
		Optional<String> op = s.stream().max(Comparator.comparingInt(String::length));
		System.out.println("op: " + op.get());

		List<String> strArr = Arrays
				.asList("the words are greatest wallmountainoftheyear in the world sagregation".split(" "));
		Optional<String> opt = strArr.stream().max(Comparator.comparingInt(String::length));
		System.out.println("max lenth string: " + opt.get());

	}

	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U' ? true : false;
	}

}
