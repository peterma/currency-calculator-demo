package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class JavaStack {

	public static void main(String[] argh) {
		// Scanner sc = new Scanner(System.in);
		//
		// while (sc.hasNext()) {
		// String input = sc.next();
		// // Complete the code
		// }
		String[] text = new String[] { "{}()", "({()})", "{}(", "[]" };

		for (int i = 0; i < text.length; i++) {
			System.out.println(isBalanced(text[i]));
		}

	}

	private static boolean isBalanced(String string) {
		int length = string.length();
		if (length % 2 != 0)
			return false;

		Map<Character, Character> pairs = new HashMap<Character, Character>();
		pairs.put('}', '{');
		pairs.put(')', '(');
		pairs.put(']', '[');

		Stack<Character> stack = new Stack<Character>();
		char[] chars = string.toCharArray();
		stack.push(chars[0]);
		Character bracket;
		for (int i = 1; i < length; i++) {
			bracket = chars[i];
			if (!stack.isEmpty() && stack.peek().equals(pairs.get(bracket))) {
				stack.pop();
			} else {
				stack.push(bracket);
			}
		}

		return stack.isEmpty();
	}
}
