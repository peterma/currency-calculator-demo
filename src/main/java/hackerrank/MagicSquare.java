package hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Position {

	public Position(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	private int row;
	private int column;

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "Position [row=" + row + ", column=" + column + "]";
	}
}

class DuplicateValue {
	private int value;
	private List<Position> positions;

	public DuplicateValue(int t, List<Position> positions) {
		this.value = t;
		this.positions = positions;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Position> getPositions() {
		return positions;
	}

	@Override
	public String toString() {
		return "DuplicateValue [value=" + value + ", positions=" + positions + "]";
	}
}

class Sum {
	private String type;
	private int number;
	private int sum;

	public Sum(String type, int number, int sum) {
		super();
		this.type = type;
		this.number = number;
		this.sum = sum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "Sum [type=" + type + ", number=" + number + ", sum=" + sum + "]";
	}
}

public class MagicSquare {
	private static final String ROW = "ROW";
	private static final String COL = "COLUMN";
	private static final String DIAG = "DIAGONAL";
	private static final int LEFT2RIGHT = -1;
	private static final int RIGHT2LEFT = -2;

	private static List<Sum> sums = null;
	private static final List<Integer> usedValues = new ArrayList<Integer>();
	private static final List<DuplicateValue> duplicateValues = new ArrayList<DuplicateValue>();
	private static final List<Integer> unusedValues = new ArrayList<Integer>();
	private static final List<Integer> ALL_VALUES = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

	private static int[][] srcArr = null;
	private static int[][] origin = null;

	// Complete the formingMagicSquare function below.
	static int formingMagicSquare(int[][] s) {
		srcArr = s;
		origin = cloneArray(s);
		if (isMagicDone())
			return 0;
		int cost = 0;
		// calculate and find duplicate values
		int value;

		List<List<Integer>> rows = new ArrayList<List<Integer>>();
		for (int i = 0; i < srcArr.length; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j < srcArr[i].length; j++) {
				value = srcArr[i][j];
				if (!usedValues.contains(value)) {
					usedValues.add(value);
				}
				row.add(value);
			}
			rows.add(row);
		}

		for (int i = 0; i < rows.size(); i++) {
			for (int j = i + 1; j < rows.size(); j++) {
				duplicateValues.addAll(findDuplicateValues(rows.get(i), rows.get(j), i, j));
			}
		}
		System.out.println(duplicateValues.toString());

		getUnusedValues();

		getSums();

		cost = forceChange();

		return cost;
	}

	private static int[][] cloneArray(int[][] s) {
		int[][] arr = new int[s.length][];
		for (int i = 0; i < s.length; i++) {
			arr[i] = new int[s[i].length];
			for (int j = 0; j < s[i].length; j++) {
				arr[i][j] = s[i][j];
			}
		}
		return arr;
	}

	// private static int forceChange() {
	// for (int i = 0; i < duplicateValues.size(); i++) {
	// List<Position> positions = duplicateValues.get(i).getPositions();
	// for (int j = 0; j < positions.size(); j++) {
	// Position pos = positions.get(j);
	// for (int k = 0; k < unusedValues.size(); k++) {
	// srcArr[pos.getRow()][pos.getColumn()] = unusedValues.get(k);
	// for (int l = i + 1; l < duplicateValues.size(); l++) {
	// List<Position> positionsOthers = duplicateValues.get(l).getPositions();
	// srcArr[pos.getRow()][pos.getColumn()] = unusedValues.get(k);
	// }
	// }
	// }
	// }
	// return 0;
	// }

	private static void printArray(int[][] arr) {
		StringBuffer sb = new StringBuffer();
		for (int m = 0; m < arr.length; m++) {
			for (int n = 0; n < arr[m].length; n++) {
				if (n > 0 && n < arr[m].length - 1) {
					sb.append(", ").append(arr[m][n]);
				} else if(n == 0) {
					sb.append("{ ").append(arr[m][n]);
				} else {
					sb.append(", ").append(arr[m][n]).append(" } ");
				}
			}
		}
		System.out.println("=======================\n" + sb.toString());
		System.out.println("=======================");
	}

	private static int forceChange() {
		int cost = 0;
		int unusedValuesSize = unusedValues.size();
		if (unusedValuesSize == 1) {
			int unusedValue = unusedValues.get(0);
			DuplicateValue duplicateValue = duplicateValues.get(0);
			List<Position> positions = duplicateValues.get(0).getPositions();
			cost = getCost4OneUnusedValue(cost, unusedValue, duplicateValue, positions);
		} else {
			for (int m = 1; m <= unusedValues.size(); m++) {
				printArray(srcArr);
				int idxPos = 0;
				for (int k = 0; k < unusedValues.size(); k++) {
					if ( k < duplicateValues.size() ) {
						List<Position> positions = duplicateValues.get(k).getPositions();
						if (idxPos < positions.size()) {
							Position pos = positions.get(idxPos);
							srcArr[pos.getRow()][pos.getColumn()] = unusedValues.get(k);
							// TODO change other duplicate values by other unused values
						}
					}
				}
				System.out.println("Data changed...");
				printArray(srcArr);

				getSums();
				if (isMagicDone()) {
					System.out.println("========== Magic done.");
					// TODO Get minimal cost
				}
				// Move item from right to left
				Integer item4Last = null;
				for (int n = 0; n < unusedValues.size(); n++) {
					if (n == 0) {
						item4Last = unusedValues.get(n);
						continue;
					}
					if (n < unusedValues.size() - 1) {
						unusedValues.set(n - 1, unusedValues.get(n));
					} else {
						unusedValues.set(n, item4Last);
					}
				}
				System.out.println("Unused values:" + unusedValues.toString());
				srcArr = cloneArray(origin);
			}
		}
		return cost;
	}

	private static int getCost4OneUnusedValue(int cost, int unusedValue, DuplicateValue duplicateValue, List<Position> positions) {
		for (Iterator<Position> iterator = positions.iterator(); iterator.hasNext();) {
			Position pos = iterator.next();

			srcArr[pos.getRow()][pos.getColumn()] = unusedValue;
			getSums();
			if (isMagicDone()) {
				System.out.println("========== Magic done.");
				// Get cost
				cost = Math.abs(srcArr[pos.getRow()][pos.getColumn()] - origin[pos.getRow()][pos.getColumn()]);
				break;
			} else {
				// reset to previous value
				srcArr[pos.getRow()][pos.getColumn()] = duplicateValue.getValue();
			}
		}
		return cost;
	}

	private static void getUnusedValues() {
		for (int value : ALL_VALUES) {
			if (!usedValues.contains(value)) {
				unusedValues.add(value);
			}
		}
		System.out.println("Unused Values:" + unusedValues.toString());
	}

	public static List<DuplicateValue> findDuplicateValues(List<Integer> list1, List<Integer> list2, int list1Index, int list2Index) {
		List<DuplicateValue> list = new ArrayList<DuplicateValue>();

		for (int col1 = 0; col1 < list1.size(); col1++) {
			int value = list1.get(col1);
			if (list2.contains(value)) {
				int col2 = list2.indexOf(value);
				DuplicateValue dup = findDupliateValue(value, list);
				if (dup != null) {
					List<Position> positions = dup.getPositions();
					addPositions(list1Index, list2Index, col1, col2, positions);
				} else {
					List<Position> positions = new ArrayList<Position>();
					addPositions(list1Index, list2Index, col1, col2, positions);
					list.add(new DuplicateValue(value, positions));
				}
			}
		}

		return list;
	}

	private static void addPositions(int list1Index, int list2Index, int col1, int col2, List<Position> positions) {
		boolean pos1Exist = false;
		boolean pos2Exist = false;
		for (Position pos : positions) {
			if (pos.getColumn() == col1 && pos.getRow() == list1Index)
				pos1Exist = true;
			if (pos.getColumn() == col2 && pos.getRow() == list2Index)
				pos2Exist = true;
		}
		if (!pos1Exist) {
			positions.add(new Position(list1Index, col1));
		}
		if (!pos2Exist) {
			positions.add(new Position(list2Index, col2));
		}
	}

	private static DuplicateValue findDupliateValue(int value, List<DuplicateValue> list) {
		for (DuplicateValue dup : list) {
			if (dup.getValue() == value) {
				return dup;
			}
		}
		return null;
	}

	static void getSums() {
		sums = new ArrayList<Sum>();
		int rowSum = 0;
		int colSum = 0;
		int left2RightDiagSum = 0;
		int right2LeftDiagSum = 0;
		for (int rowNo = 0; rowNo < srcArr.length; rowNo++) {
			for (int j = 0; j < srcArr[rowNo].length; j++) {
				rowSum += srcArr[rowNo][j];
				colSum += srcArr[j][rowNo];
				if (rowNo == j) {
					left2RightDiagSum += srcArr[rowNo][j];
				}
				if (j == (srcArr[rowNo].length - 1) - rowNo) {
					right2LeftDiagSum += srcArr[rowNo][j];
				}
			}
			sums.add(new Sum(ROW, rowNo, rowSum));
			sums.add(new Sum(COL, rowNo, colSum));
			rowSum = 0;
			colSum = 0;
		}
		sums.add(new Sum(DIAG, LEFT2RIGHT, left2RightDiagSum));
		sums.add(new Sum(DIAG, RIGHT2LEFT, right2LeftDiagSum));

		System.out.println("Sums:" + sums.toString());
	}

	static boolean isMagicDone() {
		int rowSum = 0;
		int prevRowSum = 0;
		int colSum = 0;
		int prevColSum = 0;
		int left2RightDiagSum = 0;
		int right2LeftDiagSum = 0;
		for (int i = 0; i < srcArr.length; i++) {
			rowSum = 0;
			colSum = 0;
			for (int j = 0; j < srcArr[i].length; j++) {
				rowSum += srcArr[i][j];
				colSum += srcArr[j][i];
				if (i == j) {
					left2RightDiagSum += srcArr[i][j];
				}
				if (j == (srcArr[i].length - 1) - i) {
					right2LeftDiagSum += srcArr[i][j];
				}
			}
			if (prevRowSum == 0) {
				prevRowSum = rowSum;
			} else if (prevRowSum != rowSum) {
				return false;
			}

			if (prevColSum == 0) {
				prevColSum = colSum;
			} else if (prevColSum != colSum) {
				return false;
			}
		}

		if (left2RightDiagSum != right2LeftDiagSum) {
			return false;
		}

		return true;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		//
		// int[][] s = new int[3][3];
		//
		// for (int i = 0; i < 3; i++) {
		// String[] sRowItems = scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		//
		// for (int j = 0; j < 3; j++) {
		// int sItem = Integer.parseInt(sRowItems[j]);
		// s[i][j] = sItem;
		// }
		// }
		//
		// int result = formingMagicSquare(s);
		//
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();
		//
		// bufferedWriter.close();
		//
		// scanner.close();
		// 4 9 2
		// 3 5 7
		// 8 1 5

		// 5 3 4
		// 1 5 8
		// 6 4 2
		int testCase1[][] = { { 5, 3, 4 }, { 1, 5, 8 }, { 6, 4, 2 } };
		int testCase2[][] = { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 5 } };
		int testCase3[][] = { { 4, 3, 2 }, { 4, 5, 7 }, { 6, 1, 6 } };
		int result = formingMagicSquare(testCase3);
		System.out.println("Cost:" + result);
	}
}
