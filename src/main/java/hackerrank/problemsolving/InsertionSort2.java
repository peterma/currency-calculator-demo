package hackerrank.problemsolving;

public class InsertionSort2 {
	
    static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
    // Complete the insertionSort1 function below.
    static void insertionSort2(int n, int[] arr) {
/*
1 4 3 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 2 3 4 5 6
*/
    	int tmp;
        for(int i = 1; i < n; i++) {
        	if (arr[i] < arr[i - 1]) {
        		tmp = arr[i];
        		arr[i] = arr[i - 1];
        		arr[i - 1] = tmp;
        		for (int j = i - 1; j > 0; j--) {
        			if (arr[j] < arr[j - 1]) {
        				tmp = arr[j];
        				arr[j] = arr[j - 1];
        				arr[j - 1] = tmp;
        			}
        		}
        	}
        	printArray(arr);
        }
    }

//	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
//		int n = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		int[] arr = new int[n];
//
//		String[] arrItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < n; i++) {
//			int arrItem = Integer.parseInt(arrItems[i]);
//			arr[i] = arrItem;
//		}
		//int[] arr = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
		int[] arr = new int[] { 1, 4, 3, 5, 6, 2 };

		insertionSort2(arr.length, arr);

//		scanner.close();
	}
}
