package hackerrank.problemsolving;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TheFullCountingSort {

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1)
				System.out.print(" ");
		}
		System.out.println();
	}

	// private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// int n = scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String data = "0 ab\n6 cd\n0 ef\n6 gh\n4 ij\n0 ab\n6 cd\n0 ef\n6 gh\n0 ij\n4 that\n3 be\n0 to\n1 be\n5 question\n1 or\n2 not\n4 is\n2 to\n4 the";

		int n = 20;
		int[] numbers = new int[n];
		String[] strings = new String[n];
		String[] lines = data.split("\n");
		for (int nItr = 0; nItr < n; nItr++) {
			// String[] xs = scanner.nextLine().split(" ");
			String[] xs = lines[nItr].split(" ");

			int x = Integer.parseInt(xs[0]);
			String s = xs[1];
			numbers[nItr] = x;
			strings[nItr] = s;

			System.out.println("X:" + x + ", S:" + s);
		}

		List<List<String>> processedArray = toStringArray(numbers, strings);
		printContent(processedArray);
		// scanner.close();
	}

	private static List<List<String>> toStringArray(int[] numbers, String[] strings) {
		int length = numbers.length / 2 + 1;
		List<List<String>> processed = new ArrayList<List<String>>(length);
		for (int i = 0; i < strings.length; i++) {
			processed.add(new ArrayList<String>());
		}

		List<String> list = null;
		for (int i = 0; i < strings.length; i++) {
			list = processed.get(numbers[i]);
			if (i < length - 1) {
				list.add("-");
			} else {
				list.add(strings[i]);
			}
		}

		return processed;
	}

	private static void printContent(List<List<String>> processed) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < processed.size(); i++) {
			List<String> section = processed.get(i);
			for (int j = 0; j < section.size(); j++) {
				String string = section.get(j);
				sb.append(string);
				if (i > processed.size() - 1 && j > section.size() - 1) continue;
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}
