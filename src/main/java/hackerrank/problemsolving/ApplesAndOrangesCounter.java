package hackerrank.problemsolving;

import java.util.Scanner;

public class ApplesAndOrangesCounter {

	// Complete the countApplesAndOranges function below.
	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		int applesRangeFrom = s - a;
		int applesRangeTo = t - a;
		int orangesRangeFrom = -(b - s);
		int orangesRangeTo = -(b - t);
		
		int fruitHitHouse = getHitHouseFruitAmount(apples, applesRangeFrom, applesRangeTo);
		System.out.println(fruitHitHouse);
		
		fruitHitHouse = getHitHouseFruitAmount(oranges, orangesRangeFrom, orangesRangeTo);
		System.out.println(fruitHitHouse);
	}

	private static int getHitHouseFruitAmount(int[] fruits, int fruitsRangeFrom, int fruitsRangeTo) {
		int fruitHitHouse = 0;
		for(int i = 0; i < fruits.length; i++) {
			if (fruits[i] >= fruitsRangeFrom && fruits[i] <= fruitsRangeTo) {
				fruitHitHouse++;
			}
		}
		return fruitHitHouse;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// String[] st = scanner.nextLine().split(" ");
		// int s = Integer.parseInt(st[0]);
		// int t = Integer.parseInt(st[1]);
		//
		// String[] ab = scanner.nextLine().split(" ");
		// int a = Integer.parseInt(ab[0]);
		// int b = Integer.parseInt(ab[1]);
		//
		// String[] mn = scanner.nextLine().split(" ");
		// int m = Integer.parseInt(mn[0])
		// int n = Integer.parseInt(mn[1]);
		//
		// int[] apples = new int[m];
		//
		// String[] applesItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		//
		// for (int i = 0; i < m; i++) {
		// int applesItem = Integer.parseInt(applesItems[i]);
		// apples[i] = applesItem;
		// }
		//
		// int[] oranges = new int[n];
		//
		// String[] orangesItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		//
		// for (int i = 0; i < n; i++) {
		// int orangesItem = Integer.parseInt(orangesItems[i]);
		// oranges[i] = orangesItem;
		// }

		countApplesAndOranges(7, 11, 5, 15, new int[] { -2, 2, 1 }, new int[] { 5, -6 });

		scanner.close();
	}
}
