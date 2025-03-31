package _07_Stack_and_Queue._03_Monotonic_Stack_Queue_Problems;

import java.util.Stack;

public class _25_Remove_k_Digits {
	public static void main(String[] args) {

		// remove k digits from number so that it can make smaller number
		String num = "1432219";
		int k = 3;

		System.out.println(removeKdigits(num, k));

	}

	// see video for base case

	public static String removeKdigits(String num, int k) {

		Stack<Character> st = new Stack<Character>();

		//Pop if we have previous bigger value in stack
		for (int i = 0; i < num.length(); i++) {
			while (!st.isEmpty() && k > 0 && st.peek() - '0' > num.charAt(i) - '0') {
				st.pop();
				k = k - 1;
			}
			st.push(num.charAt(i));
		}

		 //Pop when k is still left and string end and also numbers is in increasing formate.
		while (k > 0 && !st.isEmpty()) {
			st.pop();
			k--;
		}

		//for ans make arr for store stack value in reverse from stack
		char[] chArr = new char[st.size()];
		int i = st.size() - 1;
		while (i >= 0)
			chArr[i--] = st.pop();

		//if ans contains "0" in first then we have to trim ans
		int d = 0;
		while (d < chArr.length && chArr[d] == '0') {
			d++;
		}

		// for ans we have to append from char but those not start with "0".
		StringBuilder sb = new StringBuilder();
		while (d < chArr.length) { // this condition for if d is on end and we have not found any number.
			sb.append(chArr[d++]);
		}

		if (sb.length() == 0)
			sb.append("0");

		return sb.toString();
	}
}
