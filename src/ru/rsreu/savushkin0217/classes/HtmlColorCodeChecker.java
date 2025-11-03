package ru.rsreu.savushkin0217.classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlColorCodeChecker {

	private HtmlColorCodeChecker() {

	}

	public static String getResultCheckHtmlColor(String str) {
		return HtmlColorCodeChecker.generateResultMessage(str);
	}

	private static String generateResultMessage(String str) {
		boolean isColorCode = HtmlColorCodeChecker.isHtmlColor(str);

		if (isColorCode) {
			return HtmlColorCodeChecker.createPositiveMessage(str);
		} else {
			return HtmlColorCodeChecker.createNegativeMessage(str);
		}
	}

	private static String createPositiveMessage(String str) {
		return "YES, { " + str + " } is HTML colors code!";
	}

	private static String createNegativeMessage(String str) {
		return "NO, { " + str + " } isn't HTML colors code!";
	}

	private static boolean isHtmlColor(String str) {
		String regEx = "#[A-F\\d]{6}(?<!#f{6}|0{6})";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);

		return matcher.matches();
	}
}