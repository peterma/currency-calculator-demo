package hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class CountingSort1 {

	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1)
				System.out.print(" ");
		}
		System.out.println();
	}

	// Complete the countingSort function below.
	static int[] countingSort(int[] arr) {
		int[] result = new int[100];

		for (int i = 0; i < arr.length; i++) {
			result[arr[i]] += 1;
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		//
		// int n = scanner.nextInt();
		int n = 100;
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		//
		int[] arr = new int[n];
		//
		// String[] arrItems = scanner.nextLine().split(" ");
		String dataString = "63 25 73 1 98 73 56 84 86 57 16 83 8 25 81 56 9 53 98 67 99 12 83 89 80 91 39 86 76 85 74 39 25 90 59 10 94 32 44 3 89 30 27 79 46 96 27 32 18 21 92 69 81 40 40 34 68 78 24 87 42 69 23 41 78 22 6 90 99 89 50 30 20 1 43 3 70 95 33 46 44 9 69 48 33 60 65 16 82 67 61 32 21 79 75 75 13 87 70 33";
		String[] arrItems = dataString.split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		//
		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int[] result = countingSort(arr);
		printArray(result);
		// for (int i = 0; i < result.length; i++) {
		// bufferedWriter.write(String.valueOf(result[i]));
		//
		// if (i != result.length - 1) {
		// bufferedWriter.write(" ");
		// }
		// }
		//
		// bufferedWriter.newLine();
		//
		// bufferedWriter.close();

		scanner.close();
	}
}
