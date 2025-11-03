package ru.rsreu.savushkin0217.classes;

public class ShortestAndLongestWordsCreater {

	private ShortestAndLongestWordsCreater() {

	}

	public static String getOnlyShortestAndLongestWords(String str) {
		String[] words = ShortestAndLongestWordsCreater.splitStringBySpace(str);
		StringBuilder result = new StringBuilder();

		int wordMaxLength = ShortestAndLongestWordsCreater.findMaxLengthWords(words);
		int wordMinLength = ShortestAndLongestWordsCreater.findMinLengthWords(words);

		ShortestAndLongestWordsCreater.appendShortestAndLongestWords(words, wordMaxLength, wordMinLength, result);

		return result.toString().trim();
	}

	private static int findMaxLengthWords(String[] words) {
		int maxLength = words[0].length();

		for (int i = 1; i < words.length; i++) {
			if (words[i].length() > maxLength) {
				maxLength = words[i].length();
			}
		}

		return maxLength;
	}

	private static int findMinLengthWords(String[] words) {
		int minLength = words[0].length();

		for (int i = 1; i < words.length; i++) {
			if (words[i].length() < minLength) {
				minLength = words[i].length();
			}
		}

		return minLength;
	}

	private static void appendShortestAndLongestWords(String[] words, int wordMaxLength, int wordMinLength,
			StringBuilder result) {

		for (String word : words) {
			if (word.length() == wordMaxLength || word.length() == wordMinLength) {
				result.append(word).append(" ");
			}
		}
	}

	private static String[] splitStringBySpace(String str) {
		return str.split(" ");
	}
}