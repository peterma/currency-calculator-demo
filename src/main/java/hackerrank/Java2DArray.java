package hackerrank;

import java.util.Scanner;

public class Java2DArray {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int[][] arr = new int[6][6];
    	int[][] arr = new int[][]{ 
    		{-1, -1, 0, -9, -2, -2},
	        {-2, -1, -6, -8, -2, -5},
	        {-1, -1, -1, -2, -3, -4},
	        {-1, -9, -2, -4, -4, -5},
	        {-7, -3, -3, -2, -9, -9},
	        {-1, -3, 0, 0, 0, 0}
    	};

//        for (int i = 0; i < 6; i++) {
//            String[] arrRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 6; j++) {
//            	int arrItem = 0;
//            	try {
//            		arrItem = Integer.parseInt(arrRowItems[j]);
//            	} catch(Exception e) {
//            		// do nothing.
//            		e.printStackTrace();
//            	}
//                arr[i][j] = arrItem;
//            }
//        }
//
//        scanner.close();
//System.out.println(arr.toString());
        Integer maxAmount = null;
		for (int i = 0; i < 4; i++) { // Move 3 times for every hourglass
			int amount = 0;
			for (int j = 0; j < 4; j++) {
				amount = getHourGlassAmount(/*columnIndex=*/i, /*rowIndex=*/j, arr);
				if (maxAmount == null || amount > maxAmount) maxAmount = amount;
			}
		}
        System.out.println(maxAmount);
    }
    
    private static int getHourGlassAmount(int rowIndex, int columnIndex, int[][] arr) {
    	int amount = 0;
		int value = 0;
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
                if ((k == 0 || k == 2) && j == 1) continue;
				value = arr[rowIndex + j][columnIndex + k];
				if (value != 0) amount += value;
			}
		}
		System.out.println("Amount:" + amount);
		return amount;
	}
}
