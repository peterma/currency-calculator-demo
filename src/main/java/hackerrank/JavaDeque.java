package hackerrank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaDeque {

	private static int getMaxUniqueNo(int[] arr, int subArrayLength) {
		int lastValue = 0;
		
		Map<Integer, Integer> numberOccurences = new HashMap<Integer, Integer>();
		Set<Integer> uniqueValues = new HashSet<Integer>();
		int uniqueValuesSize = 0;
		int maxUniqueValues = 0;
		
		Integer occurrences = 0;
		for (int dequeIndex = 0; dequeIndex < subArrayLength; dequeIndex++) {
			lastValue = arr[dequeIndex];
			occurrences = numberOccurences.get(lastValue);
			if (occurrences == null) {
				numberOccurences.put(lastValue, 1);
			} else {
				numberOccurences.put(lastValue, occurrences + 1);
			}
			uniqueValues.add(lastValue);
			uniqueValuesSize = uniqueValues.size();
			if (uniqueValuesSize > maxUniqueValues) maxUniqueValues = uniqueValuesSize;
		}

		if (maxUniqueValues == subArrayLength)
			return maxUniqueValues;

		int firstValue = 0;
		
		for (int i = subArrayLength; i < arr.length; i++) {
			firstValue = arr[i - subArrayLength];
			lastValue = arr[i];
			if (lastValue == firstValue) continue;
			
			occurrences = numberOccurences.get(firstValue);
			if (occurrences > 1) {
				numberOccurences.put(firstValue, occurrences - 1);
			} else {
				numberOccurences.put(firstValue, 0);
				uniqueValues.remove(firstValue);
			}
			
			occurrences = numberOccurences.get(lastValue);
			if (occurrences == null) {
				numberOccurences.put(lastValue, 1);
			} else {
				numberOccurences.put(lastValue, occurrences + 1);
			}
			uniqueValues.add(lastValue);
			uniqueValuesSize = uniqueValues.size();
			if (uniqueValuesSize > maxUniqueValues) maxUniqueValues = uniqueValuesSize;
		}
		return maxUniqueValues;
	}

	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(System.in);
		//
		// int n = in.nextInt();
		// int m = in.nextInt();
		//
		// int[] arr = new int[n];
		// for (int i = 0; i < n; i++) {
		// int num = in.nextInt();
		// arr[i] = num;
		// }
		// in.close();

		String path = "/home/lucas/workspace4neon/currency-calculator/src/main/resources/spring/input09.txt";
		DataWrapper wrapper = readDataFromFile(path);
		int[] arr = null;
		int m = 0;
		arr = wrapper.getData();
		m = wrapper.getSubArrayLength();

		arr = new int[] { 5, 3, 5, 2, 3, 2 };
		m = 3;
		int maxUniqueNo = getMaxUniqueNo(arr, m);
		System.out.println(maxUniqueNo);
	}

	private static DataWrapper readDataFromFile(String path) throws IOException {
		Path actualPath = Paths.get(path);// FileSystems.getDefault().getPath("logs", "access.log");
		List<String> lines = Files.readAllLines(actualPath);
		
		DataWrapper wrapper = new DataWrapper();
		String[] line_1 = lines.get(0).split(" ");
		wrapper.setSubArrayLength(Integer.parseInt(line_1[1]));
		String[] line_2 = lines.get(1).split(" ");
		int[] arr = new int[line_2.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(line_2[i]);
		}
		wrapper.setData(arr);
		return wrapper;
	}
}

class DataWrapper {
	private int subArrayLength = 0;
	private int[] data = null;

	public int getSubArrayLength() {
		return subArrayLength;
	}

	public void setSubArrayLength(int subArrayLength) {
		this.subArrayLength = subArrayLength;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

}
