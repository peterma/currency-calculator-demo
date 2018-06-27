package hackerrank;

import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

	public static void main(String[] args) {

		String regex = "\\b(\\w+)(\\b\\W+\\b\\1\\b)+";
//		String regex = "\\b(\\w+)\\s+(\\1\\b)+";
//		String regex = "(\\b\\S+\\b)\\s+\\b\\1\\b";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		//
		// Scanner in = new Scanner(System.in);
		// int numSentences = Integer.parseInt(in.nextLine());
		//
		String[] tests = { "Goodbye bye bye world world world", "Sam went went to to to his business",
				"Reya is is the the best player in eye eye game", "in inthe", "Hello hello Ab aB" };
		int numSentences = 5;
		// while (numSentences-- > 0) {
		for (int i = 0; i < numSentences; i++) {
			// String input = in.nextLine();
			String input = tests[i];
			Matcher m = p.matcher(input);

			// Check for subsequences of input that match the compiled pattern
			while (m.find()) {
				input = input.replaceAll(m.group(0), m.group(1));
			}

			// Prints the modified sentence.
			System.out.println(input);
		}
		//
		// in.close();
	}
}