package com.pogat.learnings.oldsamples;

import java.util.StringTokenizer;

public class WordCount {

	public static void main(String[] args) {
		System.out
				.println("using Char[] -- no of words: " + count("this is srinivas bandari tesing on words programe"));
		System.out.println("using split the sentence --no of words: "
				+ countWordsUsingSplit("this is srinivas bandari tesing on words programe"));
		System.out.println("Using StirngTokenizer --no of words: "
				+ countWordsUsingStringTokenizer("this is srinivas bandari tesing on words programe"));
		System.out.println("without using char[] and split and stringTokenizer --no of words: "
				+ count_Words("this is srinivas bandari tesing on words programe"));

	}

	public static int countWordsUsingStringTokenizer(String sentence) {
		if (sentence == null || sentence.isEmpty()) {
			return 0;
		}
		StringTokenizer tokens = new StringTokenizer(sentence);
		return tokens.countTokens();
	}

	public static int countWordsUsingSplit(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		String[] words = input.split("\\s+");
		return words.length;
	}

	public static int count(String word) {
		if (word == null || word.isEmpty()) {
			return 0;
		}

		int wordCount = 0;

		boolean isWord = false;
		int endOfLine = word.length() - 1;
		char[] characters = word.toCharArray();

		for (int i = 0; i < characters.length; i++) {

			// if the char is a letter, word = true.
			if (Character.isLetter(characters[i]) && i != endOfLine) {
				isWord = true;

				// if char isn't a letter and there have been letters before,
				// counter goes up.
			} else if (!Character.isLetter(characters[i]) && isWord) {
				wordCount++;
				isWord = false;

				// last word of String; if it doesn't end with a non letter, it
				// wouldn't count without this.
			} else if (Character.isLetter(characters[i]) && i == endOfLine) {
				wordCount++;
			}
		}

		return wordCount;
	}

	public static int count_Words(String str) {
		int count = 0;
		if (!(" ".equals(str.substring(0, 1))) || !(" ".equals(str.substring(str.length() - 1)))) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ' ') {
					count++;
				}
			}
			count = count + 1;
		}
		return count; // returns 0 if string starts or ends with space " ".
	}

}
