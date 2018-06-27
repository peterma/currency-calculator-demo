package hackerrank;

public class InsertionSort1 {

    static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {

        int lastItem = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            if (arr[i] > lastItem) {
            	arr[i + 1] = arr[i];
            	printArray(arr);
            	if (i == 0) {
            		arr[i] = lastItem;
            		printArray(arr);
            	}
            } else {
            	arr[i + 1] = lastItem;
            	printArray(arr);
            	break;
            }
        }
    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
    	//int[] arr = new int[] { 2, 4, 6, 8, 3 };
    	int[] arr = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }

        insertionSort1(arr.length, arr);

//        scanner.close();
    }
}

