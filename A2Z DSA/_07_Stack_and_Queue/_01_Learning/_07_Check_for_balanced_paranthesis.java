package _07_Stack_and_Queue._01_Learning;

import java.util.Stack;

public class _07_Check_for_balanced_paranthesis {
	public static void main(String[] args) {

		String s = "()[{}()]";
		if (isValid(s) == true)
			System.out.println("True");
		else
			System.out.println("False");
	}

	public static boolean isValid(String s) {

		Stack<Character> st = new Stack<Character>();

		for (char it : s.toCharArray()) {

			if (it == '(' || it == '[' || it == '{') {
				st.push(it);
			} else {
				if (st.isEmpty()) {
					// we have close bracket but not opening in stack
					return false;
				}

				char ch = st.pop();

				if ((it == ')' && ch == '(') || (it == ']' && ch == '[') || (it == '}' && ch == '{')) {
                     //go on next step
					continue;
				} else {
					return false;
				}

			}

		}

		return st.isEmpty();
	}
}
