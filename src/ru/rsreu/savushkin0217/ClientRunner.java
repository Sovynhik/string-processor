package ru.rsreu.savushkin0217;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.savushkin0217.classes.HtmlColorCodeChecker;
import ru.rsreu.savushkin0217.classes.SubstringInserter;
import ru.rsreu.savushkin0217.classes.ShortestAndLongestWordsCreater;

import java.util.Locale;
import java.util.Scanner;

public class ClientRunner {

	private ClientRunner() {

	}

	private static Resourcer resourcer = ProjectResourcer.getInstance();

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);

		System.out.print(resourcer.getString("message.startProgram"));
		System.out.print(resourcer.getString("message.startEnterStrings"));
		System.out.print(resourcer.getString("message.inputNumberOfStrings"));
		int stringCount = Integer.parseInt(in.next());
		in.nextLine();

		String[] strings = new String[stringCount];
		for (int i = 0; i < strings.length; i++) {
			System.out.printf(resourcer.getString("message.enterString"), i + 1);
			strings[i] = in.nextLine();
		}

		System.out.print(resourcer.getString("message.finishEnterStrings"));

		for (int i = 0; i < stringCount; i++) {
			System.out.printf(resourcer.getString("message.startEnterAddDataForString"), i + 1);
			System.out.print(resourcer.getString("message.enterOldSubstring"));
			String oldSubstring = in.nextLine();
			System.out.print(resourcer.getString("message.enterNewSubstring"));
			String newSubstring = in.nextLine();
			System.out.print(resourcer.getString("message.enterCountOldSubstring"));
			int counterSubstring = in.nextInt();
			in.nextLine();
			System.out.printf(resourcer.getString("message.finishEnterAddDataForString"), i + 1);

			System.out.printf(resourcer.getString("message.printResultTaskForStringNumber"), i + 1);

			System.out.print(resourcer.getString("message.resultFirstTask") + SubstringInserter
					.insertSubstringAfterNthOccurrence(strings[i], oldSubstring, newSubstring, counterSubstring) + "\n");
			System.out.print(resourcer.getString("message.resultSecondTask")
					+ ShortestAndLongestWordsCreater.getOnlyShortestAndLongestWords(strings[i]) + "\n");
			System.out.print(resourcer.getString("message.resultThirdTask")
					+ HtmlColorCodeChecker.getResultCheckHtmlColor(strings[i]) + "\n");
		}

		System.out.print(resourcer.getString("message.finishProgram"));

		in.close();
	}
}