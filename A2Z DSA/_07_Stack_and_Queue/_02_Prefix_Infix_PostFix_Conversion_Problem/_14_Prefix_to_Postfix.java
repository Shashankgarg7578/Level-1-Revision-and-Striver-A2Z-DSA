package _07_Stack_and_Queue._02_Prefix_Infix_PostFix_Conversion_Problem;

import java.util.Stack;

public class _14_Prefix_to_Postfix {

	public static void main(String[] args) {
		String s = ("*+AB-CD");
		System.out.println("prefix expression: " + s);
		System.out.print("Postfix expression: ");
		System.out.print(prefixToPostfix(s));
	}

	static String prefixToPostfix(String prefix) {

		Stack<String> st = new Stack<String>();

		// this line is different from previous one
		for (int i = prefix.length() - 1; i >= 0; i--) {
			char c = prefix.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				st.push(c + "");
			} else {

				String t1 = st.pop();
				String t2 = st.pop();

				// this line is different from previous one
				st.push(t1 + t2 + c);
			}
		}

		return st.peek();
	}
}
