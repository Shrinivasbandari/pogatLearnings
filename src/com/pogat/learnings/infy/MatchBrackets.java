package com.pogat.learnings.infy;

public class MatchBrackets {

	public static int matchBrackets(String brackets) {

		int open = 0;
		int count = 0;

		for (int i = 0; i < brackets.length(); i++) {
			if (brackets.charAt(i) == '(') {
				open++;
			} else if (brackets.charAt(i) == ')') {
				open--;
			}
			if (open < 0) {
				count++;
				//
			}
		}
		return count;
	}

	public static void main(String[] args) {

		System.out.println(matchBrackets("()("));
		System.out.println(matchBrackets("(((())))"));
		System.out.println(matchBrackets("))))"));
		System.out.println(matchBrackets(")("));
	}
}
