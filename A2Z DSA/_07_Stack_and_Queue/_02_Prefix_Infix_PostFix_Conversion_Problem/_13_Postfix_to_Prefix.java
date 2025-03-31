package _07_Stack_and_Queue._02_Prefix_Infix_PostFix_Conversion_Problem;

import java.util.Stack;

public class _13_Postfix_to_Prefix {
	
	public static void main(String[] args) {
		String s = ("AB+CD-*");
		System.out.println("Postfix expression: " + s);
		System.out.print("prefix expression: ");
		System.out.print(postfixToPrefix(s));
	}
	
	static String postfixToPrefix(String postfix) {

		Stack<String> st = new Stack<String>();

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				st.push(c + "");
			} else {

				String t1 = st.pop();
				String t2 = st.pop();
				st.push(c + t2 + t1);
			}
		}

		return st.peek();
	}
}
