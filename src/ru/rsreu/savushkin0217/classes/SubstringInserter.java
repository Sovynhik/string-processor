package ru.rsreu.savushkin0217.classes;

public class SubstringInserter {

	private SubstringInserter() {

	}

	public static String insertSubstringAfterNthOccurrence(String originalString, String oldSubstring,
			String newSubstring, int entry) {
		String[] words = SubstringInserter.splitStringBySpace(originalString);
		StringBuilder result = new StringBuilder();

		int indexOldSubstring = SubstringInserter.getNthOccurrenceIndex(words, oldSubstring, entry);

		SubstringInserter.checkCorrectedResult(originalString, words, result, indexOldSubstring, newSubstring);

		return result.toString().trim();
	}

	private static void checkCorrectedResult(String originalString, String[] words, StringBuilder result,
			int indexOldSubstring, String newSubstring) {
		if (indexOldSubstring != -1) {
			SubstringInserter.createResultString(words, result, indexOldSubstring, newSubstring);
		} else {
			result.append(originalString);
		}
	}

	private static int getNthOccurrenceIndex(String[] words, String oldSubstring, int entry) {
		int occurrenceCount = 0;

		for (int i = 0; i < words.length; i++) {
			if (SubstringInserter.isOldSubstring(words[i], oldSubstring)) {
				occurrenceCount++;
			}
			if (SubstringInserter.isNthOccurrence(occurrenceCount, entry)) {
				return i;
			}
		}
		return -1;
	}

	private static void createResultString(String[] words, StringBuilder result, int indexOldSubstring,
			String newSubstring) {
		SubstringInserter.appendWordsBeforeIndex(words, result, indexOldSubstring);
		result.append(newSubstring).append(" ");
		SubstringInserter.appendWordsAfterIndex(words, result, indexOldSubstring);
	}

	private static void appendWordsBeforeIndex(String[] words, StringBuilder result, int indexOldSubstring) {
		for (int i = 0; i <= indexOldSubstring; i++) {
			result.append(words[i]).append(" ");
		}
	}

	private static void appendWordsAfterIndex(String[] words, StringBuilder result, int indexOldSubstring) {
		for (int i = indexOldSubstring + 1; i < words.length; i++) {
			result.append(words[i]).append(" ");
		}
	}

	private static boolean isOldSubstring(String word, String oldSubstring) {
		return word.equals(oldSubstring);
	}

	private static boolean isNthOccurrence(int occurrenceCount, int entry) {
		return occurrenceCount == entry;
	}

	private static String[] splitStringBySpace(String originalString) {
		return originalString.split(" ");
	}
}