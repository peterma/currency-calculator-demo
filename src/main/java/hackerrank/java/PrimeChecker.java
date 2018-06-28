package hackerrank.java;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Sample Input
//2
//1
//3
//4
//5
//
//Sample Output
//2 
//2 
//2 3 
//2 3 5 

public class PrimeChecker {

	public static void main(String[] args) {
		try {
			// BufferedReader br = new BufferedReader(new InputStreamReader(in));
			// int n1 = Integer.parseInt(br.readLine());
			// int n2 = Integer.parseInt(br.readLine());
			// int n3 = Integer.parseInt(br.readLine());
			// int n4 = Integer.parseInt(br.readLine());
			// int n5 = Integer.parseInt(br.readLine());
			int n1 = 2;
			int n2 = 1;
			int n3 = 3;
			int n4 = 4;
			int n5 = 5;
			Prime ob = new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1, n2);
			ob.checkPrime(n1, n2, n3);
			ob.checkPrime(n1, n2, n3, n4, n5);
			Method[] methods = Prime.class.getDeclaredMethods();
			Set<String> set = new HashSet<>();
			boolean overload = false;
			for (int i = 0; i < methods.length; i++) {
				if (set.contains(methods[i].getName())) {
					overload = true;
					break;
				}
				set.add(methods[i].getName());
			}
			if (overload) {
				throw new Exception("Overloading not allowed");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

class Prime {
	private void printList(List<Integer> list) {
		if (list.size() == 0) {
			System.out.println();
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				Integer value = list.get(i);
				sb.append(value);
				if (i < list.size() - 1) {
					sb.append(" ");
				}
			}
			System.out.println(sb.toString());
		}
	}

	void checkPrime(int... numbers) {
		List<Integer> primes = new ArrayList<Integer>();
		int num;
		for (int i = 0; i < numbers.length; i++) {
			num = numbers[i];
			// TODO
			// if(num % 2 == 0) {
			// primes.add(num);
			// }
		}

		printList(primes);
	}
}
