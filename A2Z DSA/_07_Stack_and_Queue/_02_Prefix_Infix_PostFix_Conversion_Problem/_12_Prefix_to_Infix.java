package _07_Stack_and_Queue._02_Prefix_Infix_PostFix_Conversion_Problem;

import java.util.Stack;

public class _12_Prefix_to_Infix {

	// reverse iterate the String other things is same as last one

	public static void main(String[] args) {
		String s = ("*+AB-CD");
		System.out.println("Prefix expression: " + s);
		System.out.print("infix expression: ");
		System.out.print(prefixToInfix(s));
	}

	// TC :- O(N) + O(N)
	// SC :- O(N)
	static String prefixToInfix(String prefix) {

		Stack<String> st = new Stack<String>();

		//this line is different from previous one
		for (int i = prefix.length() - 1; i >= 0; i--) {
			char c = prefix.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				st.push(c + "");
			} else {

				String t1 = st.pop();
				String t2 = st.pop();
				
				//this line is different from previous one
				st.push("(" + t1 + c + t2 + ")");
			}
		}

		return st.peek();
	}
}
