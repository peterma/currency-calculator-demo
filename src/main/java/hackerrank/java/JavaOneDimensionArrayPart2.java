package hackerrank.java;

public class JavaOneDimensionArrayPart2 {

	public static boolean canWin(int leap, int[] game) {
		
		int length = game.length;
		int index = 0;
		while (index < (length - 1) && index + leap < length) {
			if ((index + leap) < length && game[ index + leap ] == 0){
				index += leap;
				continue;
			}
			if (game[ index + 1 ] == 0) {
				index++;
				continue;
			}
			if ((index + leap) == (length - 1) && game[ index + leap ] == 0) {
				return true;
			}

			boolean goOn = false;
			for (int subArrIndex = 1; (subArrIndex < leap) && (index - subArrIndex > 0); subArrIndex++) {
				if (game[ index - subArrIndex ] != 0) break;
				if (game[ index - subArrIndex ] == 0) {
					if(game[ index - subArrIndex + leap ] == 0) {
						index = index - subArrIndex + leap;
						goOn = true;
						break;
					} else {
						game[ index - subArrIndex ] = 1;
					}
				}
			}
			if (goOn) {
				continue;
			}
			if ((index + leap) > length - 1 || game[ index + leap ] == 1) {					
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		// int q = scan.nextInt();
		// while (q-- > 0) {
		// int n = scan.nextInt();
		// int leap = scan.nextInt();
		//
		// int[] game = new int[n];
		// for (int i = 0; i < n; i++) {
		// game[i] = scan.nextInt();
		// }
		//
		// System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
		// }
		// scan.close();
		
//		int[] leaps = new int[] { 2, 6, 3 };
//		// YES, NO, YES
//		int[][] games = new int[][] { { 0, 1, 0, 1, 0, 1 }, { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 }, { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 } };
		
//		int[] leaps = new int[] { 4 };
//		int[][] games = new int[][] { { 0, 1, 1, 0, 0, 1, 1, 0, 1 } };
		
//		11 5
//		0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1
//		11, 5
//		0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1
//		11, 5
//		0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1
//		Y, Y, N
//		int[] leaps = new int[] { 5, 5, 5 };
//		int[][] games = new int[][] { { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1 }, { 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1 }, { 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1 } };
		
//		0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1
//		0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1
//		0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1
//		0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1
//		0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1
//		YES YES NO YES NO
		int[] leaps = new int[] { 5, 5, 5, 7, 7 };
		int[][] games = new int[][] {
			{ 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1 },
			{ 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1 },
			{ 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1 },
			{ 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1 }
		};
		
		int[] game = null;
		for (int i = 0; i < games.length; i++) {
			game = games[i];
			System.out.println((canWin(leaps[i], game)) ? "YES" : "NO");
		}
	}
}